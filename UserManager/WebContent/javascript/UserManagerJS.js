(function(){
	
	var $tabuser,$btnAdd,$formTitle,$txtName,$txtEmail,$txtPhone,$txtWeb,$btnSave,$btnCal,$popup,
	$overlay,$tr,$userId = -1,$btnUpd,$focusedrow;
	$tabuser = $('#tabuser');
	$btnAdd = $('#btnAdd');
	$formTitle = $('#formTitle');
	$txtName = $('#txtName');
	$txtEmail = $('#txtEmail');
	$txtPhone = $('#txtPhone');
	$txtWebsite = $('#txtWebsite');
	$btnSave = $('#btnSave');
	$btnCal = $('#btnCal');
	$btnUpd = $('#btnUpd');
	$popup = $('#popup');
	$overlay = $('#overlay');

	$tr =$('<tr/>');
	$tr.append('<td prop=action><span action="Edit">Edit | </span><span action="Delete">Delete</span></td>');
	$tr.append('<td prop="name"></td>');
	$tr.append('<td prop="email"></td>');
	$tr.append('<td prop="phone"></td>');
	$tr.append('<td prop="website"></td>');

	function AddRow(user)
	{
		//console.log("hi");
		var $trNew = $tr.clone();
		$trNew.find('td[prop=name]').html(user.name);
		$trNew.find('td[prop=email]').html(user.email);
		$trNew.find('td[prop=phone]').html(user.phone);
		$trNew.find('td[prop=website]').html(user.website);
		$tabuser.append($trNew);
		$($btnUpd).css('display', 'block');
		

	}
	function PreparePopup($tr)
	{
		$txtName.val($tr.find('[prop=name]').html());
		$txtEmail.val($tr.find('[prop=email]').html());
		$txtPhone.val($tr.find('[prop=phone]').html());
		$txtWebsite.val($tr.find('[prop=website]').html());
	}
	function Cancel()
	{
		$popup.toggle();
		$overlay.toggle();
		$($btnUpd).css('display', 'block');
		$($btnSave).css('display', 'block');
	}
	function Togglepopup()
	{
		$popup.toggle();
		$overlay.toggle();
	}
	
	function DeleteUser()
	{
		if(confirm("Really You  want to delete?"))
			$(this).closest('tr').remove();
	}
	
	function EditUser()
	{
		$($btnSave).css('display', 'none');
		$formTitle.html('EditUser');
		$focusedrow =$(this).closest('tr');
		PreparePopup($focusedrow);
		Togglepopup();
				//set user id
	}
	
	function UpdateUser()
	{
		//alert("hi");
		/*$focusedrow.children(':nth-child(2)').html($("input[name=name]").val());
		$focusedrow.children(':nth-child(3)').html($("input[name=email]").val());
		$focusedrow.children(':nth-child(4)').html($("input[name=phone]").val());
		$focusedrow.children(':nth-child(5)').html($("input[name=website]").val());*/
				
		$focusedrow.find('td[prop=name]').html($txtName.val());
		$focusedrow.find('td[prop=email]').html($txtEmail.val());
		$focusedrow.find('td[prop=phone]').html($txtPhone.val());
		$focusedrow.find('td[prop=website]').html($txtWebsite.val());
		$($btnSave).css('display', 'block');
		Togglepopup();
		

	}
	function AddUser()
	{
		$($btnUpd).css('display', 'none');
		Togglepopup();
		$formTitle.html('AddUser');
		PreparePopup($tr);
	}
	function SaveUser()
	{
		var user ={};
		user.name = $txtName.val();
		user.email = $txtEmail.val();
		user.phone = $txtPhone.val();
		user.website = $txtWebsite.val();
		AddRow(user);
		Togglepopup();
	}
	
	function Init()
	{
		$.ajax({
			url:'http://jsonplaceholder.typicode.com/users',
			success:function(data)
			{
				$.each(data,function(index,user)
						{
					AddRow(user);
						})
			}
		  })

		$(document).on('click','[action = Edit]',EditUser);
		$(document).on('click','[action = Delete]',DeleteUser);
		$btnAdd.bind('click',AddUser);
		$btnCal.bind('click',Cancel);
		$btnSave.bind('click',SaveUser);
		$btnUpd.bind('click',UpdateUser);
		

	}

	Init();
		}());