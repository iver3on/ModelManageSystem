<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'intro.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
* {
	font-family: Microsoft YaHei, SimHei, sans-serif;
}

#title2 {
	font-weight: bold;
	margin-left: 10px;
	font-family: Microsoft YaHei, SimHei, sans-serif;
}

#words {
	padding: 5px 10px 5px 10px;
}
</style>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
	<h4 id="title2">MBR系统简述</h4>
	<img alt="" src="./resources/pic/MBRV2.svg" class="img-responsive">
	<div id="words">
		<p>模型推理系统应用模糊理论实现各控制单元参数的模糊化处理；采用MBR来研究连铸工艺流程单元合理的推理模型，形成MBR模型库。我们建立基于模型推理子系统来推理钢水成分的变化和交接坯的起始位置，可以提高切除的精度，从而降低工程成本。
	</div>
</body>
</html>
