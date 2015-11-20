<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>changeWarning</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/jquery-1.11.1.min.js"></script>
<script src="resources/js/jquery.form.js"></script>
<script src="resources/js/bootstrap.min.js"></script>

<style type="text/css">
body {
	margin: 0;
	padding: 0 5px 0 0;
	font-family: Microsoft YaHei, SimHei, sans-serif;
}

.header {
	margin: 0;
	padding: 10px;
	background-color: #ECF0F1;
}

.header span {
	color: #d9534f;
	line-height: 24px;
}

table thead {
	font-weight: 600;
}

p {
	font-size: 18px;
}

textarea { /* 禁止文本域被拖动 */
	resize: none;
}

.cancel {
	width: 122px;
	margin-right: 10px;
}

.ok {
	width: 120px;
}

/* 模态框背景 */
.modal-backdrop {
	background-color: #E6E6FA;
}

.modal-backdrop.in {
	filter: alpha(opacity =       50);
	opacity: .5;
}

.glyphicon-ok {
	color: #468847;
}

.modal-footer a {
	margin-right: 10px;
	padding-left: 29px;
	padding-right: 29px;
}
</style>
</head>
<script type="text/javascript">
$(document).ready(function() {
var tag =${tag};
if(tag==0){
var used = ${model.used};
if(used==1){
$("#myAlert").show();
}
}else{
var results="${result}";
console.log("........."+results);
if(results=="FAIL"){
$("#myAlertNameChange").show();
}else if(results=="OK"){
console.log("........");
$("#myModal").modal(
{
show:true
});
}
}
});

</script>
<body scroll="no" style="overflow-x:hidden">
	<div class="container-fluid">
		<!-- 标题 -->
		<div class="row">
			<h3 class="header">模型修改</h3>
			<hr>
		</div>

		<!-- 被引用状态区域 -->
		<div class="row">
			<div id="notUsed">
				<p>修改输入参数默认值</p>
			</div>
			<hr>
		</div>
		<div id="myAlert" class="alert alert-warning" style="display:none;">
			<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>警告！</strong>此模型使用过，请谨慎操作！
		</div>

		<div id="myAlertNameChange" class="alert alert-warning"
			style="display:none;">
			<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>警告！</strong>已有相同名称的模型存在！请改为其他名称！
		</div>
		<!-- 表单区域 -->
		<div class="row">
			<form id="myForm" action="model/${model.id }/changeName"
				method="post">
				<div class="row">
					<!-- 第一列开始 -->
					<div class="col-xs-6">
						<div class="form-group">
							<h5>当前名称：</h5>
							<input type="text" class="form-control" required="required"
								readonly="readonly" value="${model.name}">
							<h5>修改为：</h5>
							<input type="text" name="afterChange" class="form-control"
								required="required">
						</div>
					</div>

					<!-- 第二列开始 -->
					<div class="col-xs-6">
						<div class="form-group">
							<label for="rulesId">模型编号</label> <input type="text"
								class="form-control" id="rulesId" value="${model.id}" readonly>
						</div>
						<div class="form-group">
							<label for="metaDataManagerName">当前管理员（您的登陆名）</label> <input
								type="text" class="form-control" id="metaDataManagerName"
								name="metaDataManagerName" value="userName" readonly>
						</div>
						<div class="form-group">
							<label for="metaDataDate">当前日期</label> <input type="text"
								class="form-control" id="metaDataDate" name="metaDataDate"
								value="${changeTime}" readonly>
						</div>
					</div>
				</div>

				<hr>
				<a href="model/change" class="btn btn-default cancel" role="button">返回模型修改</a>
				<button type="submit" class="btn btn-primary ok">保存修改</button>
			</form>

		</div>
	</div>

	<!-- 修改提交后弹出的模态框Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">
						<span class="glyphicon glyphicon-ok"></span> 修改成功！
					</h4>
				</div>
				<div class="modal-footer">
					<a href="model/change" class="btn btn-primary " role="button">确认</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
