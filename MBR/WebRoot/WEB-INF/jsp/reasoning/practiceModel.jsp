<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
<script type="text/javascript">
        var inputLength = ${inputParaSize};
</script>
<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/model-practice.js"></script>
<style type="text/css">
.loading{  
    width:160px;  
    height:56px;  
    position: absolute;  
    top:50%;  
    left:50%;  
    line-height:56px;  
    color:#fff;  
    padding-left:60px;  
    font-size:15px;  
    background: #000 url(resources/pic/loading.gif) no-repeat 10px 50%;  
    opacity: 0.7;  
    z-index:9999;  
    -moz-border-radius:20px;  
    -webkit-border-radius:20px;  
    border-radius:20px;  
    filter:progid:DXImageTransform.Microsoft.Alpha(opacity=70);  
}  
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div id="header" class="col-sm-12">
				<h3 class="my-title">
					<span class="glyphicon glyphicon-search text-primary"></span> 模型训练
				</h3>
			</div>
		</div>
		<%-- 	<form action="model/${model.id}/practice" method="post"> --%>
		<form action="practice/${id}/practice">
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<c:forEach items="${inputPara}" var="inputPara">
								<td>${inputPara.mbrMetaData.name}</td>
							</c:forEach>
							<td>删除</td>
						</tr>
					</thead>
					<tbody id="optionContainer">
						<tr>
							<c:forEach items="${inputPara}" var="inputPara">
								<c:if test="${inputPara.mbrMetaData.id==1}">
									<td><input type="text" id="inj1" class="form-control"
										name="inj1" required="required" value="3.5*6"
										onfocus="if (value =='3.5*6'){value =''}"
										onblur="if (value ==''){value='3.5*6'}">
									</td>
								</c:if>
								<c:if test="${inputPara.mbrMetaData.id==2}">
									<td><input type="text" id="inj2" class="form-control"
										name="inj2" required="required" value="2000"
										onfocus="if (value =='2000'){value =''}"
										onblur="if (value ==''){value='2000'}">
									</td>
								</c:if>
								<c:if test="${inputPara.mbrMetaData.id==3}">
									<td><input type="text" id="inj3" class="form-control"
										name="inj3" required="required" value="2.6"
										onfocus="if (value =='2.6'){value =''}"
										onblur="if (value ==''){value='2.6'}">
									</td>
								</c:if>
								<c:if test="${inputPara.mbrMetaData.id==4}">
									<td><input type="text" id="inj4" class="form-control"
										name="inj4" required="required" value="4"
										onfocus="if (value =='4'){value =''}"
										onblur="if (value ==''){value='4'}">
									</td>
								</c:if>
								<c:if test="${inputPara.mbrMetaData.id==5}">
									<td><input type="text" id="inj5" class="form-control"
										name="inj5" required="required" value="4%"
										onfocus="if (value =='4%'){value =''}"
										onblur="if (value ==''){value='4%'}">
									</td>
								</c:if>
								<c:if test="${inputPara.mbrMetaData.id==6}">
									<td><input type="text" id="inj6" class="form-control"
										name="inj6" required="required" value="5%"
										onfocus="if (value =='5%'){value =''}"
										onblur="if (value ==''){value='5%'}">
									</td>
								</c:if>
								<c:if test="${inputPara.mbrMetaData.id==7}">
									<td><input type="text" id="inj7" class="form-control"
										name="inj7" required="required" value=3
										" onfocus="if (value ==3'){value =''}"
										onblur="if (value ==''){value='3'}">
									</td>
								</c:if>
							</c:forEach>
						</tr>
					</tbody>
				</table>
				<div id="loading" class="loading">正在训练...</div>  
				<div style="text-align: right;"></div>
				<!-- <i id="practice" class="icon-plus"></i> -->
				<div style="text-align: right;">
					<button id="addLine" class="btn btn-default cancel">添加一行</button>
					<button id="practice" type="submit" data-loading-text="正在训练....." class="btn btn-primary">执行训练</button>
					<button id="stopPractice" data-toggle="modal" class="btn btn-primary" style="display:none;" data-target="#myModal">终止训练</button>
				</div>
			</div>
		</div>
		</form>
		<!-- </form> -->
	<!-- 	<span id="output" style="font-size: 16px">训练进度：</span>
		<div class="progress progress-striped">
			<div class="progress-bar" role="progressbar" aria-valuenow="60"
				aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
				<span id="x"></span>
			</div>

		</div> -->
		<span id="output" style="font-size: 16px">训练时间：</span>
						<span id="time"></span> 
		<div id="myAlert" class="alert alert-success" style="display:none;">
			<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>成功！</strong>训练成功！
		</div>
		<div id="myAlertWrong" class="alert alert-warning"
			style="display:none;">
			<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>警告！</strong>训练异常结束！
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
						<span class="glyphicon glyphicon-ok"></span>您确认要终止训练吗？
					</h4>
				</div>
				<div class="modal-footer">
					<a id="stop" class="btn btn-primary " role="button">确认</a>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>
