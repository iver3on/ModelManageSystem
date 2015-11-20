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
<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
var modelId = ${id};
console.log("jsp页面的。。"+modelId);
</script>
<script type="text/javascript" src="resources/js/model-reason.js"></script>
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
<body>
	<div id="intro">执行推理：</div>
	<%-- <form action="reason/${id}/reason" method="post"> --%>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<c:forEach items="${inputPara}" var="inputPara">
								<td>${inputPara.mbrMetaData.name}</td>
							</c:forEach>
						</tr>
					</thead>
					<tbody id="optionContainer">
						<tr>
							<c:forEach items="${inputPara}" var="inputPara">
								<c:if test="${inputPara.mbrMetaData.id==1}">
									<td><input type="text" class="form-control" name="in1"
										required="required" value="3.5*6"
										onfocus="if (value =='3.5*6'){value =''}"
										onblur="if (value ==''){value='3.5*6'}">
									</td>
								</c:if>
								<c:if test="${inputPara.mbrMetaData.id==2}">
									<td><input type="text" class="form-control" name="in2"
										required="required" value="2000"
										onfocus="if (value =='2000'){value =''}"
										onblur="if (value ==''){value='2000'}">
									</td>
								</c:if>
								<c:if test="${inputPara.mbrMetaData.id==3}">
									<td><input type="text" class="form-control" name="in3"
										required="required" value="2.6"
										onfocus="if (value =='2.6'){value =''}"
										onblur="if (value ==''){value='2.6'}">
									</td>
								</c:if>
								<c:if test="${inputPara.mbrMetaData.id==4}">
									<td><input type="text" class="form-control" name="in4"
										required="required" value="4"
										onfocus="if (value =='4'){value =''}"
										onblur="if (value ==''){value='4'}">
									</td>
								</c:if>
								<c:if test="${inputPara.mbrMetaData.id==5}">
									<td><input type="text" class="form-control" name="in5"
										required="required" value="4%"
										onfocus="if (value =='4%'){value =''}"
										onblur="if (value ==''){value='4%'}">
									</td>
								</c:if>
								<c:if test="${inputPara.mbrMetaData.id==6}">
									<td><input type="text" class="form-control" name="in6"
										required="required" value="5%"
										onfocus="if (value =='5%'){value =''}"
										onblur="if (value ==''){value='5%'}">
									</td>
								</c:if>
								<c:if test="${inputPara.mbrMetaData.id==7}">
									<td><input type="text" class="form-control" name="in7"
										required="required" value=3
										" onfocus="if (value ==3'){value =''}"
										onblur="if (value ==''){value='3'}">
									</td>
								</c:if>
							</c:forEach>
						</tr>
					</tbody>
				</table>
				<!-- <td><input type="text" class="form-control"
								required="required"  value="3.5*6" onfocus="if (value =='3.5*6'){value =''}" onblur="if (value ==''){value='3.5*6'}"></td>
								<td><input type="text" class="form-control"
									required="required" value="2000" onfocus="if (value =='2000'){value =''}" onblur="if (value ==''){value='2000'}"></td>
									<td><input type="text" class="form-control"
										required="required" value="5" onfocus="if (value =='5'){value =''}" onblur="if (value ==''){value='5'}"></td> -->
				<div style="text-align: right;"></div>
				<!-- <i id="practice" class="icon-plus"></i> -->
				<div style="text-align: right;">
					<button id="enter" class="btn btn-primary">执行推理</button>
				</div>
	<!-- </form> -->
	<h4>推理结果：</h4>					
	<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<td>交接坯起始位置X(m)</td>
							<td>交接坯长度Y(m)</td>
						</tr>
					</thead>
					<tbody id="optionContainer">
					<tr>
							<td id="td1"></td>
							<td id="td2"></td>
						</tr>
						</tbody>
						</table>
						<br>
						<br>
	<button id="pic" class="btn btn-default"
							type="button" data-toggle="collapse"
							data-target="#cube" aria-expanded="true"
							aria-controls="cube">▼ 结果示意图</button>
		<div id="cube" class="row collapse">
         <img src="resources/pic/cubeF.bmp" 
         alt="推理视图">
      </div>
</body>
</html>
