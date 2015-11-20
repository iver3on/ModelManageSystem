var rowCount=1;  //行数默认4行 
var p = 0;
var xlength = inputLength;
var timer;
$(document).ready(function() { 
	
	$("#loading").css("display","none");
  //删除行  
//添加行 
$('#addLine').click(function() {
	$("#practice").attr("disabled",false);
	$("#myAlert").hide();
	p=0;
	$("div[class=progress-bar]").css("width","0%");
	$("#x").text("0%");
	
	rowCount++;  
	var newRow="";
	console.log(xlength+"ccccccc");
	if(xlength==1){
		newRow='<tr id="input'+rowCount+'"><td><input type="text" id="in1" class="form-control" required="required"></td><td><a onclick=delRow('+rowCount+')>删除</a></td></tr>';  
	}
	if(xlength==2){
		newRow='<tr id="input'+rowCount+'"><td><input type="text" id="in1" class="form-control" required="required"></td><td><input type="text" id="in2" class="form-control" required="required"></td><td><a  onclick=delRow('+rowCount+')>删除</a></td></tr>';  
	}
	if(xlength==3){
		newRow='<tr id="input'+rowCount+'"><td><input type="text" id="in1" class="form-control" required="required"></td><td><input type="text" id="in2" class="form-control" required="required"></td><td><input type="text" id="in3" class="form-control" required="required"></td><td><a  onclick=delRow('+rowCount+')>删除</a></td></tr>';  
	}
	if(xlength==4){
		newRow='<tr id="input'+rowCount+'"><td><input type="text" id="in1" class="form-control" required="required"></td><td><input type="text" id="in2" class="form-control" required="required"></td><td><input type="text" id="in3" class="form-control" required="required"></td><td><input type="text" id="in4" class="form-control" required="required"></td><td><a onclick=delRow('+rowCount+')>删除</a></td></tr>';  
	}
	if(xlength==5){
		newRow='<tr id="input'+rowCount+'"><td><td><input type="text" id="in1" class="form-control" required="required"></td><td><input type="text" id="in2" class="form-control" required="required"></td><input type="text" id="in3" class="form-control" required="required"></td><td><input type="text" id="in4" class="form-control" required="required"></td><td><input type="text" id="in5" class="form-control" required="required"></td><td><a  onclick=delRow('+rowCount+')>删除</a></td></tr>';  
	}
	if(xlength==6){
		newRow='<tr id="input'+rowCount+'"><td><input type="text" id="in1" class="form-control" required="required"></td><td><input type="text" id="in2" class="form-control" required="required"></td><td><input type="text" id="in3" class="form-control" required="required"></td><td><input type="text" id="in4" class="form-control" required="required"></td><td><input type="text" id="in5" class="form-control" required="required"></td><td><input type="text" id="in6"class="form-control" required="required"></td><td><a onclick=delRow('+rowCount+')>删除</a></td></tr>';  
	}
	if(xlength==7){
		newRow='<tr id="input'+rowCount+'"><td><input type="text" id="in1" class="form-control" required="required"></td><td><input type="text" id="in2" class="form-control" required="required"></td><td><input type="text" id="in3" class="form-control" required="required"></td><td><input type="text" id="in4" class="form-control" required="required"></td><td><input type="text" id="in5" class="form-control" required="required"></td><td><input type="text" id="in6"class="form-control" required="required"></td><td><input type="text" id="in7" class="form-control" required="required"></td><td><a onclick=delRow('+rowCount+')>删除</a></td></tr>';  

	}
	//var newRow='<tr id="input'+rowCount+'"><td><input type="text" class="form-control" required="required"></td></tr>';  
	$('#optionContainer').append(newRow);  
});
/*$('#practice').click(function() {
	$("#practice").attr("disabled",true);
	$("#addLine").attr("disabled",true);
	run();
});
*/
$('#practice').click(function() {
	$("#myAlertWrong").hide();	
	$("#loading").css("display","block");
	$("#stopPractice").show();
	$("#practice").hide();
	$("#addLine").hide();
	run();
	createPracticeinput();
	
});
$("#stop").click(function(){
	$("#myAlertWrong").show();	
	$("#loading").css("display","none");
	p=0;
/*	$("div[class=progress-bar]").css("width","0%");*/
	$("#practice").show();
	$("#addLine").show();
	//清除定时器
	clearTimeout(timer);
	$("#myModal").modal("hide");
	$("#stopPractice").hide();
});
});
function delRow(rowIndex){  
	$("#input"+rowIndex).remove();  
	rowCount--;  
} 

function run(){
	p+=1;
	$("#time").text(p+"秒");
	if(p<100){
		timer=setTimeout("run()",1000);
	}else{
		alert("训练完毕！");
		$("#myAlert").show();
		$("#practice").attr("disabled",true);
		$("#addLine").attr("disabled",false);
		$("#stopPractice").hide();
	}
}


function createPracticeinput(){
	var input1 = $("#inj1").length;
	var input2 = $("#inj2").length;
	var input3 = $("#inj3").length;
	var input4 = $("#inj4").length;
	var input5 = $("#inj5").length;
	var input6 = $("#inj6").length;
	var input7 = $("#inj7").length;
	var map0={};
	if(input1>0){
		map0[1]=$("#inj1").val();
	}
	if(input2>0){
		map0[2]=$("#inj2").val();
	}
	if(input3>0){
		map0[3]=$("#inj3").val();
	}
	if(input4>0){
		map0[4]=$("#inj4").val();
	}
	if(input5>0){
		map0[5]=$("#inj5").val();
	}
	if(input6>0){
		map0[6]=$("#inj6").val();
	}
	if(input7>0){
		map0[7]=$("#inj7").val();
	}
	var map  = new Array(rowCount);
	for(var i=1;i<rowCount;i++){
		map[i]={};
		if(xlength==1){
			map[i][1]=$("tr#input"+(i+1)+' #in1').val();
		}
		if(xlength==2){
			map[i][1]=$("tr#input"+(i+1)+' #in1').val();
			map[i][2]=$("tr#input"+(i+1)+' #in2').val();
		}
		if(xlength==3){
			map[i][1]=$("tr#input"+(i+1)+' #in1').val();
			map[i][2]=$("tr#input"+(i+1)+' #in2').val();
			map[i][3]=$("tr#input"+(i+1)+' #in3').val();
		}
		if(xlength==4){
			map[i][1]=$("tr#input"+(i+1)+' #in1').val();
			map[i][2]=$("tr#input"+(i+1)+' #in2').val();
			map[i][3]=$("tr#input"+(i+1)+' #in3').val();
			map[i][4]=$("tr#input"+(i+1)+' #in4').val();
		}
		if(xlength==5){
			map[i][1]=$("tr#input"+(i+1)+' #in1').val();
			map[i][2]=$("tr#input"+(i+1)+' #in2').val();
			map[i][3]=$("tr#input"+(i+1)+' #in3').val();
			map[i][4]=$("tr#input"+(i+1)+' #in4').val();
			map[i][5]=$("tr#input"+(i+1)+' #in5').val();
		}
		if(xlength==6){
			map[i][1]=$("tr#input"+(i+1)+' #in1').val();
			map[i][2]=$("tr#input"+(i+1)+' #in2').val();
			map[i][3]=$("tr#input"+(i+1)+' #in3').val();
			map[i][4]=$("tr#input"+(i+1)+' #in4').val();
			map[i][5]=$("tr#input"+(i+1)+' #in5').val();
			map[i][6]=$("tr#input"+(i+1)+' #in6').val();
		}
		if(xlength==7){
			map[i][1]=$("tr#input"+(i+1)+' #in1').val();
			map[i][2]=$("tr#input"+(i+1)+' #in2').val();
			map[i][3]=$("tr#input"+(i+1)+' #in3').val();
			map[i][4]=$("tr#input"+(i+1)+' #in4').val();
			map[i][5]=$("tr#input"+(i+1)+' #in5').val();
			map[i][6]=$("tr#input"+(i+1)+' #in6').val();
			map[i][7]=$("tr#input"+(i+1)+' #in7').val();
		}	
	}
	$.each(map[6],function(key,value){ 
		console.log("key:"+key+";value:"+value); 
		}); 
}
	
