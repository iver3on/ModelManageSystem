<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>rulesDeleteConfirm</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/rules-delete.css">

<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
var used = ${model.used};
</script>
<script type="text/javascript" src="resources/js/model-delete.js"></script>

<style type="text/css">
body {
	margin: 0 20px 0 25px;
	padding: 0;
	font-family: Microsoft YaHei, SimHei, sans-serif;
}

.p1 {
	font-size: 16px;
}

#items {
	padding: 0px;
	margin: 0px;
}

#items ul {
	padding: 0;
	margin: 0;
	border: 1px dashed silver;
}

.glyphicon-warning-sign {
	color: #d9534f;
}

.confirm {
	width: 100px;
	margin-left: 10px;
}
/* 模态框中的取消和确认按钮 */
.cancel {
	width: 76px;
	margin-right: 4px;
}

.ok {
	width: 78px;
	margin-right: 10px;
}
/* 模态框背景 */
.modal-backdrop {
	background-color: #E6E6FA;
}

.modal-backdrop.in {
	filter: alpha(opacity =   50);
	opacity: .5;
}
</style>
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div id="header" class="col-sm-12">
				<h3 class="my-title">
					<span class="glyphicon glyphicon-list text-primary"></span> 删除模型
				</h3>
			</div>
		</div>
		<div id="myAlert" class="alert alert-warning" style="display:none;">
			<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>警告！</strong>此模型使用过，请谨慎操作！
		</div>
		<div id="myInfo" class="alert alert-info" style="display:none;">
			<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>提示！</strong>此模型未被使用过，请继续操作！
		</div>
		<p class="p1">是否确认删除？</p>
		<a class="btn btn-default" href="model/delete" role="button">返回删除页面</a>
		<button id="deleteConfirm" type="button"
			class="btn btn-primary confirm" data-toggle="modal"
			data-target="#myModal" style="display:none;">确认删除</button>
		<button id="sleepConfirm" type="button"
			class="btn btn-primary confirm" data-toggle="modal"
			data-target="#myModalSleep" style="display:none;">休眠</button>

		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<form action="model/${model.id}/deleteConfirm" method="post">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">
								<span class="glyphicon glyphicon-warning-sign"></span>
								再次确认是否删除！？
							</h4>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default cancel"
								data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-danger ok">确认删除?</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="myModalSleep" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<form action="model/${model.id}/sleepConfirm" method="post">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">
								<span class="glyphicon glyphicon-warning-sign"></span>
								再次确认是否休眠！？
							</h4>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default cancel"
								data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-danger ok">确认休眠?</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- <form action="" method="post">
		<input type="submit" value="confirm">
	</form> -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="resources/js/jquery-1.11.1.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.min.js"></script>

</body>
</html>
