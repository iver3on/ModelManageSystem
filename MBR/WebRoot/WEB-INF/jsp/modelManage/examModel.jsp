
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

<title>My JSP 'examingRule.jsp' starting page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
-->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/model-exam.css">
<script type="text/javascript" src="resources/js/model-query.js"></script>
<style type="text/css">
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
			<div id="header" class="col-xs-12">
				<h3 class="my-title">
					<span class="glyphicon glyphicon-list-alt text-primary"></span>
					执行审核
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<h5>
					<strong>当前待审核模型为：</strong>
				</h5>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<td>模型编号</td>
							<td>模型名称</td>
							<td>模型输入参数</td>
							<td>创建者</td>
							<td>创建时间</td>
							<td>审核状态</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${model.id }</td>
							<td>${model.name}</td>
							<td><c:forEach items="${model.mbrModelConditions}"
									var="condition">
									${condition.mbrMetaData.name }<br>
								</c:forEach>
							</td>
							<td>${model.userName}</td>
							<td>${model.createTime}</td>
							<td>${model.state}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row section" id="containarea">
			<div class="col-xs-12">
				<h5 class="uncheck">
					<span class="glyphicon glyphicon-info-sign"></span> 检查模型是否重复<span
						id="containboolean"></span>
				</h5>
				<button class="btn btn-default btn-xs hidden" type="button"
					data-toggle="collapse" data-target="#contain-rules"
					aria-expanded="false" aria-controls="contain-rules">查看详情 ▼</button>
				<div contain class="collapse hidden" id="contain-rules">
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<td>模型编号</td>
								<td>模型名称</td>
								<td>模型输入参数</td>
								<td>创建者</td>
								<td>创建时间</td>
								<td>审核状态</td>
								<td>审核员</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sameInputParaModelList}" var="model">
								<tr>
									<td>${model.id }</td>
									<td>${model.name}</td>
									<td><c:forEach items="${model.mbrModelConditions}"
											var="condition">
									${condition.mbrMetaData.name }<br>
										</c:forEach>
									</td>
									<td>${model.userName}</td>
									<td>${model.createTime}</td>
									<td>${model.state}</td>
									<td>${model.managerName }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="row section">
			<div class="col-xs-12">
				<div class="line"></div>
				<h4>
					<span class="glyphicon glyphicon-question-sign text-primary"></span>
					是否通过审核：
				</h4>
				<a href="model/exam" class="btn btn-default btn-sm">返回模型审核</a>
				<button class="btn btn-default btn-sm cancel" type="button"
					data-toggle="modal" data-target="#rejectModal">不通过</button>
				<button id="okbtn" class="btn btn-primary btn-sm ok" disabled
					type="button" data-toggle="modal" data-target="#passModal">通过</button>
			</div>
		</div>
	</div>


	<!-- rejectModal -->
	<div class="modal fade" id="rejectModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<form action="model/${model.id}/examReject" method="post">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">
							<span class="glyphicon glyphicon-warning-sign text-warning"></span>
							是否确认不通过？
						</h4>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default cancel"
							data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary ok">确认</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- passModal -->
	<div class="modal fade" id="passModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel2" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<form action="model/${model.id}/examPass" method="post">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel2">
							<span class="glyphicon glyphicon-warning-sign text-warning"></span>
							是否确认通过？
						</h4>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default cancel"
							data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary ok">确认</button>
					</div>
				</div>
			</form>
		</div>
	</div>


	<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/rules-table-show2.js"></script>
	<script src="resources/js/model-exam.js"></script>

	<script type="text/javascript">
	var sameLeftRules = "${sameInputParaModelList}";
	console.log("输入条件相同--->"+sameLeftRules);


/*     if (containListRules!="") {//若包含规则不为空，即没通过第一条
    	console.log("未通过包含");
    	containError();
    }else if(containedListRules!=""){//被包含规则不为空，即没通过第二条
    	console.log("未通过被包含");
    	containPass();
    	containedError();
    }else if(deliverDuplicateRulesList!=""){
    	console.log("未通过传递性冗余检查");
    	containPass();
    	containedPass();
    	deliverError();
    }else{
    	containPass();
    	containedPass();
    	deliverPass();
    } */

    //前件相同或后件相同规则
    if (sameLeftRules=="[]") {
    	sameLeftRulesEmpty();
    } else{
    	sameLeftRulesExist();
    }
   /*  if (sameRightRules=="[]") {
    	sameRightRulesEmpty();
    } else{
    	sameRightRulesExist();
    }; */
</script>

</body>
</html>
