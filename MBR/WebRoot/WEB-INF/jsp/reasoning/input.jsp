<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>paraInput</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="resources/css/metadata_tree_format.css" rel="stylesheet"> -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/js/jquery-1.11.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/reason.js"></script>
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

body {
	margin: 0;
	padding: 0;
	font-family: Microsoft YaHei, SimHei, sans-serif;
}

#top {
	position: fixed;
	right: 10px;
	bottom: 10px;
	width: 60px;
	height: 60px;
	background-color: #ECF0F1;
	text-align: center;
	line-height: 60px;
	font-size: small;
	filter: alpha(opacity :   70);
	opacity: 0.7;
}
</style>
<script type="text/javascript">
</script>
</head>
<body>
	<div id="intro">选择模型进行训练</div>

	<form action="xx" method="post">
		<div class="row">
			<div class="col-md-12">
			<div class="table-responsive">
				<table class="table table-bordered table-striped table-hover">
					<thead>
						<tr>
							<td>模型编号</td>
							<td>模型名称</td>
							<td>模型输入参数</td>
							<td>模型输出参数</td>
							<td>创建者</td>
							<td>创建时间</td>
							<td>模型状态</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${modelList}" var="model">
							<tr>
								<td>${model.id }</td>
								<td>${model.name}</td>
								<td><c:forEach items="${model.mbrModelConditions}"
										var="condition">
									${condition.mbrMetaData.name }<br>
									</c:forEach>
								</td>
								<td>交接坯起始位置<br>长度<br>
								</td>
								<td>${model.userName}</td>
								<td>${model.createTime}</td>
								<td>${model.used}</td>
								<td><a href="practice/${model.id}/practicePage"
									class="btn btn-primary">训练</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>
			</div>
		</div>
	</form>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="resources/js/jquery-1.11.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
