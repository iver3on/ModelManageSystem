$(document).ready(function() {
	var idint = modelId;
	console.log("js页面的......"+modelId);
	$(".collapse").collapse("show"); 
	$("#enter").click(function() {
		var jsonData = createPracticeinput(idint);
		console.log(jsonData);
		judgeData(jsonData);
	});
	
});

//利用ajax 不刷新页面 进行推理结果的计算
function judgeData(jsonData){
	 $.ajax({
         url: 'reason/reasonGo',
         type: 'POST',
         dataType: 'json',
         data: jsonData,
     }).done(function() {
         // console.log("success");
     }).fail(function(XMLHttpRequest, textStatus, errorThrown, data) {
    	 console.log("失败");
         // console.log("error");
         // console.log(XMLHttpRequest.status);
         // console.log(XMLHttpRequest.readyState);
         // console.log(data);
         // console.log(textStatus);
     }).always(function(text, textStatus) {
    	 console.log("进入ajax")
    	 var json = eval(text);
    	 console.log(json);
    	 $("#td1").text(json.startPoint);
    	 $("#td2").text(json.length);	 
     });
}

function createPracticeinput(idint){
	var input1 = $("[name='in1']").length;
	var input2 = $("[name='in2']").length;
	var input3 = $("[name='in3']").length;
	var input4 = $("[name='in4']").length;
	var input5 = $("[name='in5']").length;
	var input6 = $("[name='in6']").length;
	var input7 = $("[name='in7']").length;
	var in1String="";
	var in2String="";
	var in3String="";
	var in4String="";
	var in5String="";
	var in6String="";
	var in7String="";
	if(input1>0){
		in1String = $("[name='in1']").val();
	}
	if(input2>0){
		in2String = $("[name='in2']").val();
	}
	if(input3>0){
		in3String = $("[name='in3']").val();
	}
	if(input4>0){
		in4String = $("[name='in4']").val();
	}
	if(input5>0){
		in5String = $("[name='in5']").val();
	}
	if(input6>0){
		in6String = $("[name='in6']").val();
	}
	if(input7>0){
		in7String = $("[name='in7']").val();
	}
	var json = {
			id:idint,
	        in1:in1String,
			in2:in2String,
			in3:in3String,
			in4:in4String,
			in5:in5String,
			in6:in6String,
			in7:in7String,
	    };
	return json;
}