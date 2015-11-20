$(document).ready(function() {

	$(".collapse").collapse("show"); 
    /**
     * 录脿脤媒checkbox赂脛卤盲碌脛路陆路篓
     */
	  $("[name=checkbox]").change(function() {
	        $('[exampletr]').remove();
	        checkboxShowValue(this);
	    });
    /**
     * 碌茫禄梅脤谩陆禄掳麓脜楼脢卤碌脛露炉脳梅
     */
    $('.ok').click(function() {
    	console.log("点击了创建模型按钮");
        var jsonData = createJsonData();
        console.log(jsonData);

        //judge data legal
        judgeDataLegal(jsonData);
    });

    // 鹿枚脪鲁脙忙虏脜脧脭脢戮路碌禄脴露楼虏驴
    $(window).scroll(function() {
        if ($(window).scrollTop() > 100) {
            $("#top").fadeIn(500);
        } else {
            $("#top").fadeOut(500);
        }
    });
    // 碌茫禄梅禄脴碌陆露楼虏驴
    $("#top").click(function() {
        $("body").animate({
            scrollTop: "0"
        }, 500);
    });
});

/**
 * judgeDataLegal
 * @param {json} jsonData
 */
function judgeDataLegal(jsonData) {
    console.log("----------------");
    if (jsonData.leftList === "") {
        console.log("leftList cannot be empty");
        $('#leftErrorModal').modal('show');
    } /*else if (jsonData.rightMap === "") {
        console.log("right cannot be empty");
        $("#myModalLabel").html('<span class="glyphicon glyphicon-warning-sign"></span>杈撳嚭鍙傛暟涓嶈兘涓虹┖');
        $('#leftErrorModal').modal('show');
    }*/ else {
        $.ajax({
            url: 'model/add',
            type: 'POST',
            dataType: 'json',
            data: jsonData,
        }).done(function() {
            // console.log("success");
        }).fail(function(XMLHttpRequest, textStatus, errorThrown, data) {
            // console.log("error");
            // console.log(XMLHttpRequest.status);
            // console.log(XMLHttpRequest.readyState);
            // console.log(data);
            // console.log(textStatus);
        }).always(function(msg) {
           console.log(msg.responseText);
           console.log("complete");
            if (msg.responseText == "OK") {
                console.log("great");
                $(".modal-header").html('<h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-ok"></span>添加模型成功！</h4>');
                $(".modal-footer").html('<a href="model/add" class="btn btn-primary " role="button">再添加一个模型</a>');
                $('#leftErrorModal').modal({
                    backdrop: 'static',
                    keyboard: false,
                    show: true
                });
            }else if(msg.responseText == "SAME_INPUT"){
            	console.log("SAME_INPUT");
            	$(".modal-header").html('<h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-remove"></span>错误，输入参数重复！</h4>');
                $(".modal-footer").html('<a href="model/add" class="btn btn-primary " role="button">重新添加</a>');
                $('#leftErrorModal').modal({
                    backdrop: 'static',
                    keyboard: false,
                    show: true
                });
            }else if(msg.responseText == "SAME_NAME"){	
            	console.log("SAME_NAME");
            	$(".modal-header").html('<h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-remove"></span>错误，名称重复！</h4>');
                $(".modal-footer").html('<a href="model/add" class="btn btn-primary " role="button">重新添加</a>');
                $('#leftErrorModal').modal({
                    backdrop: 'static',
                    keyboard: false,
                    show: true
                });
            }else if(msg.responseText == "SAME_INPUT_AND_NAME"){	
            	console.log("SAME_INPUT_AND_NAME");
            	$(".modal-header").html('<h4 class="modal-title" id="myModalLabel"><span class="glyphicon glyphicon-remove"></span>错误，输入参数和名称重复！</h4>');
                $(".modal-footer").html('<a href="model/add" class="btn btn-primary " role="button">重新添加</a>');
                $('#leftErrorModal').modal({
                    backdrop: 'static',
                    keyboard: false,
                    show: true
                });
            }       
        });
    }
}

/**
 * 鹿鹿脭矛Json赂帽脢陆碌脛脢媒戮脻
 *
 * @return {json} json脢媒戮脻
 */
function createJsonData() {

    //query left id and weight
    var aTr = $('#front tr');
    /*var bTr = $('#back tr');
    var bInput = $('#back>tr>td>input'); */
    var leftListResultString = "";
   // var rightMapResultString = "";
    console.log(aTr);
    console.log(aTr.length);
    for (var i = 0; i < aTr.length; i++) {
        var metaDataId = aTr[i].getAttribute("metaid-intable");
         if (metaDataId) {
        	 leftListResultString += metaDataId + ",";
        }
       // leftMapResultString += metaDataId +",";
    }
    leftListResultString = leftListResultString.slice(0, -1); //delete last","
    console.log(leftListResultString);

    //query right id

/* for (var i = 0; i < bTr.length; i++) {
        var metaDataId1 = bTr[i].getAttribute("metaid-intable");
        // if (metaDataId1) {
        //     rightMapResultString += metaDataId1 + ":" + bInput[i].value + ",";
        // }
        rightMapResultString += metaDataId1+",";
    }
    rightMapResultString = rightMapResultString.slice(0, -1); //delete last","
*/

    // var rightId = -1;
    // var rightIdResult = $("[metaid-inrightdiv]").attr("metaid-inrightdiv");
    // if (rightIdResult) {
    //     rightId = rightIdResult;
    // }

    //query reliablity
    //var reliablityResult = $("#reliablity").val();

    var usernameId = $("#metaDataManagerName").val();
    var name = $("#modelName").val();

    var json = {
        leftList: leftListResultString,
        //rightMap: rightMapResultString,
       //reliablity: reliablityResult,
        name: name,
        username: usernameId
    };
    return json;
}

/**
 * 脙驴脪禄赂枚checkbox赂脛卤盲潞贸碌脛露炉脳梅
 *
 * @param {element}
 *            element 麓芦脠毛碌脛DOM脭陋脣脴
 */
function checkboxShowValue(element) {
	//console.log("hhhh");
    //console.log(element+"hhhhhhh"+element.checked);
    if (element.checked === true) {
        addCheckedNameAndIdToTable(element.getAttribute("meta-id"),
            element.value);
    }
    if (element.checked === false) {
        removeTrInTable(element.getAttribute("meta-id"));
    }
}

/**
 * 陆芦checked脰脨碌脛name潞脥id脤铆录脫碌陆卤铆赂帽脰脨
 *
 * @param {String}
 *            name 脭陋脢媒戮脻脙没
 * @param {String}
 *            id 脭陋脢媒戮脻id
 */
function addCheckedNameAndIdToTable(id, name) {
    $("#front")
        .append(
            '<tr metaid-intable="' + id + '"><td>' + name + '</td></tr>');
        var x = $("input[type='checkbox']:checked").length;
        console.log(x);
        $("#count").text(x);
        $("#modelName").val(x);
}
/**
 * 赂霉戮脻id脪脝鲁媒卤铆赂帽脰脨碌脛脪禄脨脨
 *
 * @param {String}
 *            id 麓芦脠毛碌脛id
 */
function removeTrInTable(id) {
    $('[metaid-intable=' + id + ']').remove();
      var x = $("input[type='checkbox']:checked").length;
        console.log(x);
        $("#count").text(x);
         $("#modelName").val(x);
}
