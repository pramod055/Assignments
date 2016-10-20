(function(){
	var gl,txtGlossary,boxA,boxB,btnRemove,imgid;
	boxA= document.querySelector('#boxB');
	boxB= document.querySelector('#boxA');
	imgid = document.querySelector('#imageId');
	
function dragStart(ev) {
	   ev.dataTransfer.setData("text", ev.target.id);
}

function dragEnter(ev) {
	console.log("dragEnter");
		event.preventDefault();
	return true;
}

function dragOver(ev) {
	  ev.preventDefault();
}

function dragDrop(ev) {
	 ev.preventDefault();
	    var data = ev.dataTransfer.getData("text");
	    ev.target.appendChild(document.getElementById(data));

}
function Init(){
	//alert('a');
	console.log("Init");
	
	imgid.addEventListener('dragstart', dragStart);
	//boxA.addEventListener('dragenter', dragEnter);
	boxA.addEventListener('drop', dragDrop);
	boxA.addEventListener('dragover', dragOver);
	//boxB.addEventListener('dragenter', dragEnter);
	boxB.addEventListener('drop', dragDrop);
	boxB.addEventListener('dragover', dragOver);
}
	
	Init();
}());


