<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">

<title>Log Query</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/rules-query.css">

<script type="text/javascript"
	src="resources/My97DatePicker/WdatePicker.js"></script>
</head>
<script type="text/javascript">
  	window.onload = function() {
  	 	var btn = document.getElementById("btn");
	 	var text = document.getElementById("t"); 
	 	var date = document.getElementById("d1"); 
	 	var date2 = document.getElementById("d2"); 
		var formTable = document.getElementById("f"); 
		var act = document.getElementById("a"); 
		var content = document.getElementById("c");
  	 	btn.onclick = function() {
  	 		
			act.options[act.options.selectedIndex].selected =true;
  	 		if(text.value=="" && date.value=="" && content.value=="" && act.value==0){
  	 			alert("查询内容不能为空");
  	 		}else{
  	 		if(text.value==""){
  	 			text.value="0";
  	 		}	
  	 		if(date.value==""){
  	 			date.value="0";
  	 		}
  	 		if(date2.value==""){
  	 			date2.value="0";
  	 		}	
  	 		if(content.value==""){
  	 			content.value="0";
  	 		}	
  	 			formTable.submit();
  	 		}
  	 	
  		 };
  	};  
  	function getAction(){
  		window.location.href="log/getLogAction";
  	}
  
  </script>
<body>
	<div class="container-fluid">
		<div class="row">
			<div id="header" class="col-sm-12">
				<h3 class="my-title">
					<span class="glyphicon glyphicon-search text-primary"></span> 查看日志
				</h3>
			</div>
		</div>
		<div>
			<form id="f" action="log/query/1/search" class="form-inline"
				method="post">
				<!--  <input id="txt1" type="text" class="form-control"style="width: 200px;" onfocus="searchOn()" onblur="searchOut()">-->
				<!--<input id="a" type="text" name="action"  style="width: 200px;height: 35px;border:#939393 1px solid;" placeholder="请输入动作">或-->
				动作：<select id="a" name="actionId"
					style="width: 100px;height: 36px;border:#939393 1px solid;">

					<option value="0">请选择动作</option>
					<option value="202">增加模型</option>
					<option value="204">删除模型</option>
					<option value="201">查询规则</option>
					<option value="203">修改模型</option>
					<option value="205">审核模型</option>
					<!-- <option value="4">查询日志</option> -->

					<!--  
			<c:forEach items="${logAct}" var="la">
				<option value="${la.actionNumber}">${la.actionName}</option>
			</c:forEach>
			-->


				</select> 操作人：<input id="t" type="text" name="searchName"
					style="width: 100px;height: 36px;border:#939393 1px solid;">


				日期：<input id="d1" name="timedate" class="laydate-icon"
					style="width: 130px;height: 36px;border:#939393 1px solid;"
					onclick="laydate()" readonly="readonly"> <span
					class="icon-minus "></span> <input id="d2" name="timedateLate"
					class="laydate-icon"
					style="width: 130px;height: 36px;border:#939393 1px solid;"
					onclick="laydate()" readonly="readonly"> 内容：<input id="c"
					type="text" name="content"
					style="width: 150px;height: 36px;border:#939393 1px solid;">
				<input id="btn" type="button"
					style="width: 50px;height: 36px;border:#939393 1px solid;"
					value="搜索">
			</form>
		</div>
		
		<span style="width: 25px">${logPage.searchInfo}</span>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>

							<td>动作</td>
							<td>操作人</td>
							<td>操作日期</td>
							<td>内容</td>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${logPage.list}" var="l">
							<tr>
								<td>${l.action }</td>
								<td>${l.userName }</td>
								<td>${l.dateTime }</td>
								<td>${l.content }</td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
				<br/>
				<table border='0' cellpadding='0' cellspacing='0' align="center">
					<tr>
						<td width='98%' align="right">共<span style='color:#FF0000'>${logPage.sum}</span>条记录&nbsp;&nbsp;&nbsp;&nbsp;
							每页<span style='color:#FF0000'>${logPage.pageSize}</span>条&nbsp;&nbsp;&nbsp;&nbsp;
							第<span style='color:#FF0000'>${logPage.index}</span>页/共${logPage.pageSum}页&nbsp;&nbsp;&nbsp;&nbsp;
							<c:choose>
								<c:when test="${logPage.search==false}">
									<c:if test="${logPage.index==1}">

									</c:if>
									<c:if test="${logPage.index!=1}">
										<a style='color: red' href="log/query/1/page">首&nbsp;&nbsp;页</a>
						                       &nbsp;&nbsp;&nbsp;&nbsp;
						                       <a style='color: red'
											href="log/query/${logPage.index-1}/page">上一页</a>
						                       &nbsp;&nbsp;&nbsp;&nbsp;
						                </c:if>
									<c:if test="${logPage.index >= logPage.pageSum}">

									</c:if>
									<c:if test="${logPage.index < logPage.pageSum}">
										<a style='color: red' href="log/query/${logPage.index+1}/page">下一页</a>
						                       &nbsp;&nbsp;&nbsp;&nbsp;
						                       <a style='color: red'
											href="log/query/${logPage.pageSum}/page">末&nbsp;&nbsp;页</a>

									</c:if>
								</c:when>
								<c:otherwise>
								 	<c:if test="${logPage.index==1}">
						                     <!--   首&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp; -->
						                </c:if>
									<c:if test="${logPage.index!=1}">
						                       <a style='color: red' href="log/query/1/${logPage.searchName}/${logPage.actionId}/${logPage.startTime}/${logPage.endTime}/${logPage.content}/search" >首&nbsp;&nbsp;页</a>
						                       &nbsp;&nbsp;&nbsp;&nbsp;
						                       <a style='color: red' href="log/query/${logPage.index-1}/${logPage.searchName}/${logPage.actionId}/${logPage.startTime}/${logPage.endTime}/${logPage.content}/search">上一页</a>
						                       &nbsp;&nbsp;&nbsp;&nbsp;
						                </c:if>
									<c:if test="${logPage.index >= logPage.pageSum}&&${logPage.index!=1}">
						                    <a style='color: red' href="log/query/1/${logPage.searchName}/${logPage.actionId}/${logPage.startTime}/${logPage.endTime}/${logPage.content}/search" >首&nbsp;&nbsp;页</a>
						                       &nbsp;&nbsp;&nbsp;&nbsp;
						                       <a style='color: red' href="log/query/${logPage.index-1}/${logPage.searchName}/${logPage.actionId}/${logPage.startTime}/${logPage.endTime}/${logPage.content}/search">上一页</a>
						                       &nbsp;&nbsp;&nbsp;&nbsp;
						                </c:if>
									   <c:if test="${logPage.index < logPage.pageSum}">
						                       <a style='color: red' href="log/query/${logPage.index+1}/${logPage.searchName}/${logPage.actionId}/${logPage.startTime}/${logPage.endTime}/${logPage.content}/search">下一页</a>
						                       &nbsp;&nbsp;&nbsp;&nbsp;
						                       <a style='color: red' href="log/query/${logPage.pageSum}/${logPage.searchName}/${logPage.actionId}/${logPage.startTime}/${logPage.endTime}/${logPage.content}/search">末&nbsp;&nbsp;页</a>
						                       <br/>
						                      <!--   <a>${logPage.searchName}</a>-->
						               </c:if>
								</c:otherwise>

							</c:choose>
						</td>
					</tr>
				</table>
			</div>
		</div>

	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="resources/js/jquery-1.11.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/datetime.js"></script>
	<script src="resources/laydate/laydate.js"></script>
</body>
</html>
