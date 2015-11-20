$(document).ready(function() {
	console.log("xxxxx");
	var isUsed = used;
	console.log(isUsed);
	if(isUsed==0){
		$("#myInfo").show();
		$("#deleteConfirm").show();
	}else if(isUsed==1){
		$("#myAlert").show();
		$("#sleepConfirm").show();
		$("#table").show();
		$("#tag").show();
	}else if(isUsed==3){
		$("#mySleep").show();
	}
});