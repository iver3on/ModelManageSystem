<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<title>metaData Tab</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
-->
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/rules-query.css">
<link rel="stylesheet" href="resources/css/animate.css">
<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
<style type="text/css">
#intro {
	top: 0;
	left: 0;
	background-color: #ECF0F1;
	width: 100%;
	height: auto;
	padding-top: 10px;
	padding-bottom: 10px;
	padding-left: 24px;
	font-size: 16px;
}

#xxx {
	padding-left: 50px;
	width: 100%;
	height: 100%;
}
</style>
</head>
<script type="text/javascript">
$(document).ready(function() {
//     $('#reason').click(function() {
//     	console.log("111111111111");
// 	$("#xx").addClass("animated slideInLeft");
// 	console.log("1212");
// 	$("#xx").removeClass("animated slideInLeft");
// 	//$("#xx").removeClass("animated slideInLeft");
// });
var svgDocument = document.getElementById("xxx");
var doc = svgDocument.contentDocument;
var reason = doc.getElementById("ca");
console.log(doc+",,,")
console.log(reason.attr("href"));
// var x = svgDocument.src;
// console.log(x);
});
 
  </script>

<body>
	<div id="intro">推理结果：</div>
	<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<td>交接坯起始位置X(m)</td>
							<td>交接坯长度Y(m)</td>
						</tr>
					</thead>
					<tbody id="optionContainer">
						<tr><td>2.15</td>
							<td>8.4</td></tr>
						</tbody>
						</table>
	<div id="intro">结果示意图：</div>
		<a class="thumbnail">
         <img src="resources/pic/cubeF.bmp" 
         alt="推理视图">
      </a>
</body>
</html>
