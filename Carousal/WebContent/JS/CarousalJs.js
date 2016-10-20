(function () {

    // Declare your variables here
    var $topDiv, $parentDiv, $leftDiv, $ulDiv, $rightDiv, $ulItems, $btnRight, leftRight, $btnLeft, left, $numberOfImages, $btnShow,count;
    // initialiaze your variables here
    
    $topDiv = $('#topDiv');
    $parentDiv = $('#parentDiv');
    $leftDiv = $('#leftDiv');
    $ulDiv = $('#ulDiv');
    $rightDiv = $('#rightDiv');
    $ulItems = $('#ulItems');
    $btnRight = $('#btnRight');
    $btnLeft = $('#btnLeft');
    $numberOfImages = $('#numberOfImages');
    $btnShow = $('#btnShow');
    // Write your functions here
  
    var incr = (function () 
    {
    	return function () 
    	{
    				return count++;
    	}
    })();

     var decr = (function () 
    {
    	return function () 
    	{
    				return count--;
    	}
    })();
    
    
    function moveRight()
    {
    	var count= decr();
    	var numOfImages = $numberOfImages.val();
    	//console.log(count);
      	if(!(count === parseInt(numOfImages)-25))
          $ulItems.animate({ 'left': "-=155px" },{ duration:500, 
													  start : function ()
													  {  
											               $btnRight.unbind('click',moveRight);
											               $btnLeft.unbind('click' , moveLeft); 
													  },
										                 done:function ()
										    		     {  
										                  $btnRight.bind('click',moveRight);
										                  $btnLeft.bind('click', moveLeft); 
										   		         }
        });
      	else
      		incr();
    }

    function moveLeft() 
    {
    	var count =incr();
    	var numOfImages = $numberOfImages.val();
    	//console.log(count);
    	if(!(count === 0))
        $ulItems.animate({ 'left': "+=155px" },{ duration:500, 
			                                         start : function ()
			                                         {  
	                                                      $btnRight.unbind('click',moveRight);
	                                                      $btnLeft.unbind('click', moveLeft); 
			                                         },
                                                     done:function ()
    		                                         {  
                                                          $btnRight.bind('click', moveRight);
                                                          $btnLeft.bind('click', moveLeft); 
   		                                             }
         });
    	else
    		decr();
    		
    }

    function setWidth()
    {
    	count=0;
        var numOfImages = $numberOfImages.val();
        $ulItems.animate({ 'left': "0" },0, function () {   
       });
        if(parseInt(numOfImages)<1 || parseInt(numOfImages)>10)
        	{
        		alert("Please enter correct value bw 2-10!!!")
        	}
        //console.log($btnRight.width());
       // console.log($ulDiv.width());
        
        var newWidth = 155 * parseInt(numOfImages) + 2*($btnRight.width());;
        newWidth +="px" ;
        $parentDiv.css('width', newWidth);
    }

    // init function here
    function Init()
    {
        $btnRight.bind('click', moveRight);
        $btnLeft.bind('click', moveLeft);
        $btnShow.bind('click', setWidth);
    }
    // call init function
    Init();
}())