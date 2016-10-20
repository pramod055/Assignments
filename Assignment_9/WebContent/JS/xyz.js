(function (a) {
    //declare variables
    var $tblUsers, $popup, $overlay, $hdnUserId, $txtName, $txtEmail, $txtLocation, $txtEmpCode, $txtDob ;

	$tblUsers = $('#tblUsers');
	$popup = $('#popup');
	$overlay = $('#overlay');
	$hdnUserId = $('#hdnUserId');
	$txtName = $('#name');
	$txtEmail = $('#email');
	$txtLocation = $('#location');
	$txtEmpCode = $('#empCode');
	$txtDob = $('#dob');
    
    function EditUser() {
        TogglePopup(true);
        var $tr = $(this).closest("tr");
        $hdnUserId.val(parseInt($(this).attr("emp-id"), 10));
    	$txtEmpCode.val($tr.find("td:nth-child(1)").html());
    	$txtName.val($tr.find("td:nth-child(2)").html());
    	$txtLocation.val($tr.find("td:nth-child(3)").html());
    	$txtEmail.val($tr.find("td:nth-child(4)").html());
    	$txtDob.val($tr.find("td:nth-child(5)").html());
    }
    function DeleteUser() {
        $tblUsers.change(onclick)
        $(this).closest("tr").remove();
    }
     
    function TogglePopup(flag) {
        if(flag) {
            $overlay.removeClass("hidden");
            $popup.removeClass("hidden");
        }
        else {
            $overlay.addClass("hidden");
            $popup.addClass("hidden");
        }
    }
    
    
    $tblUsers.on("click",".edit-class",EditUser);
    $tblUsers.on("click","input[type=image][alt=delete]",DeleteUser);
    $popup.on("click","#cancelEdit", function () {
        TogglePopup(false);
    });
    
})(jQuery);