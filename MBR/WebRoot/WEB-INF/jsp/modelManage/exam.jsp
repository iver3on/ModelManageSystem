<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>rules Query</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/rules-query.css">

<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/model-query.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div id="header" class="col-sm-12">
				<h3 class="my-title">
					<span class="glyphicon glyphicon-search text-primary"></span> 审核模型
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<h4>
					共有<strong>${needExamListLength}</strong>个模型待审核。详情如下：
				</h4>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<td>模型编号</td>
							<td>模型名称</td>
							<td>模型输入参数</td>
							<td>创建者</td>
							<td>创建时间</td>
							<td>审核状态</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${needExamList}" var="model">
							<tr>
								<td>${model.id}</td>
								<td>${model.name}</td>
								<td><c:forEach items="${model.mbrModelConditions}"
										var="condition">
									${condition.mbrMetaData.name }<br>
									</c:forEach>
								</td>
								<td>${model.userName}</td>
								<td>${model.createTime}</td>
								<td>${model.state}</td>
								<td><a href="model/${model.id}/examDetail"
									class="btn btn-default btn-sm">执行审核</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>
</html>