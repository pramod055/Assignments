(function(){
	
	function Init()
	{
		var drawingCanvas = document.getElementById('Drawing');

	    // Check the element is in the DOM and the browser supports canvas
	    if(drawingCanvas.getContext) 
	    {
	        // Initaliase a 2-dimensional drawing context
	        var context = drawingCanvas.getContext('2d');
	    }
	    
	    // Creating the outer yellow circle
	    context.strokeStyle = "#000000";
	    context.fillStyle = "#FFFF00";
	    context.beginPath();
	    context.arc(200,200,190,0,Math.PI*2,true);
	    context.closePath();
	    context.stroke();
	    context.fill();
	    
	    // Creating the eyes outer
	    context.strokeStyle = "#000000";
	    context.fillStyle = "#FFFFFF";
	    context.beginPath();
	    context.arc(130,130,20,0,Math.PI*2,true);
	    context.closePath();
	    context.stroke();
	    context.fill();
	    
	    context.strokeStyle = "#000000";
	    context.fillStyle = "#FFFFFF";
	    context.beginPath();
	    context.arc(270,130,20,0,Math.PI*2,true);
	    context.closePath();
	    context.stroke();
	    context.fill();
	    
	    // Creating the eyes inner
	    context.fillStyle = "#7CFC00";
	    context.beginPath();
	    context.arc(130,130,15,0,Math.PI*2,true);
	    context.closePath();
	    context.fill();
	    
	    context.fillStyle = "#7CFC00";
	    context.beginPath();
	    context.arc(270,130,15,0,Math.PI*2,true);
	    context.closePath();
	    context.fill();

	    // Create the nose angled square or diamond
	    context.fillStyle = "#000000";
	    context.beginPath();
	    context.moveTo(200,240);
	    context.lineTo(225,215);
	    context.lineTo(200,190);
	    context.lineTo(175,215);
	    context.fill();
	 
	    // Creating the mouth arc
	    context.strokeStyle = "#000000";
	    context.beginPath();
	    context.arc(200,190,130,Math.PI*0.85,Math.PI*.15,true);
	    context.stroke();

		
	}
	
	Init();
}());