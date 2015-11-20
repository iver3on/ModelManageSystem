<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>模型推理子系统</title>
<!-- Bootstrap -->

<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/index.css" rel="stylesheet">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="./resources/js/jquery-1.11.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="./resources/js/bootstrap.min.js"></script>

<style type="text/css">
.NavBg{
	background: #E6E6FA;
}
.nav-tabs>li.active>a,.nav-tabs>li.active>a:hover,.nav-tabs>li.active>a:focus{
	/* background-color: #ECF0F1; */
}
hr{
	margin:15px 0;
}
</style>

<!-- jQuery的prev ~ siblings选择器用于匹配prev元素之后的所有同辈的siblings元素，将其封装为jQuery对象并返回。

注意：选择器siblings的查找范围必须是"prev元素"之后的元素，并且是同辈元素(即与"prev元素"有同一个的父元素)。 -->
<script type="text/javascript">
$(function(){
/* 	//鼠标滑过左边导航，背景高亮
	$("#guide_ul li").hover(function(){
		$(this).addClass("NavBg");
	},function(){
		$(this).removeClass("NavBg");
	}); */
	
	//左边导航默认载入的时候首页高亮
	$("#homeNav").addClass("NavBg");
	
	//点击左边导航，Tab跟着变换
	//x
	$("#homeNav").click(function(){
		$("#myTab>li:eq(0)").tab('show');
		$("#homeNav").parent().children().removeClass("NavBg");
		$(this).addClass("NavBg");
	});
	$("#homeNav~li:lt(5)").click(function(){
		$("#myTab>li:eq(1)").tab('show');
		$("#homeNav").parent().children().removeClass("NavBg");
		$(this).addClass("NavBg");
	});
	
	$("#homeNav~li:gt(4):lt(2)").click(function(){
		$("#myTab>li:eq(2)").tab('show');
		$("#homeNav").parent().children().removeClass("NavBg");
		$(this).addClass("NavBg");
	});
	
	$("#homeNav~li:gt(6):lt(3)").click(function(){
		$("#myTab>li:eq(3)").tab('show');
		$("#homeNav").parent().children().removeClass("NavBg");
		$(this).addClass("NavBg");
	});
	$("#homeNav~li:gt(9):lt(3)").click(function(){
		$("#myTab>li:eq(4)").tab('show');
		$("#homeNav").parent().children().removeClass("NavBg");
		$(this).addClass("NavBg");
	});
	$("#homeNav~li:gt(12):lt(2)").click(function(){
		$("#myTab>li:eq(5)").tab('show');
		$("#homeNav").parent().children().removeClass("NavBg");
		$(this).addClass("NavBg");
	});
	
	//点击Tab，左边导航跟着变换，同时改变iframe中的内容
	$("#myTab a:first").click(function () {
		$("#homeNav").parent().children().removeClass("NavBg");
  		$("#homeNav").addClass("NavBg");
  		$("#iframe").attr("src","intro/MBRintroduce");
	});
	$("#myTab a:eq(1)").click(function () {
		$("#homeNav").parent().children().removeClass("NavBg");
  		$("#homeNav~li:eq(0)").addClass("NavBg");
  		$("#iframe").attr("src","description/reasoning");
	});
	$("#myTab a:eq(2)").click(function () {
		$("#homeNav").parent().children().removeClass("NavBg");
  		$("#homeNav~li:eq(6)").addClass("NavBg");
  		$("#iframe").attr("src","description/modelManage");
	});
	$("#myTab a:eq(3)").click(function () {
		$("#homeNav").parent().children().removeClass("NavBg");
  		$("#homeNav~li:eq(8)").addClass("NavBg");
  		$("#iframe").attr("src","description/modelPractice");
	});
	$("#myTab a:eq(4)").click(function () {
		$("#homeNav").parent().children().removeClass("NavBg");
  		$("#homeNav~li:eq(11)").addClass("NavBg");
  		$("#iframe").attr("src","jsp/modelManage/add.html");
	});
	$("#myTab a:eq(5)").click(function () {
		$("#homeNav").parent().children().removeClass("NavBg");
  		$("#homeNav~li:eq(14)").addClass("NavBg");
  		$("#iframe").attr("src","log/query");
	});
});
</script>


</head>
<body>

	<!-- 栅格布局 -->
	<div class="container">

		<div id="header" class="row">

			<div class="span12">
				<img alt="" src="resources/pic/top_02.jpg"> <span
					style="margin: 0 0 0 400;"><a href="#">消息 (1)</a> | 专家 | Name
					<a>返回首页</a> </span>
			</div>

		</div>
		
		<hr class="divider">
			<!-- context -->
		<div class="row">
			
			<!-- nav list -->
			<div id="left" class="col-xs-2">
				<ul id="guide_ul">
					<li id="homeNav" class="eneditable_li"><a href="intro/MBRintroduce" target="contentFrame"><span
							class="glyphicon glyphicon-home"></span> 首页 </a>
					</li>
					<hr>
					<li class="eneditable_li"><a href="description/modelManage"
						target="contentFrame"> <span
							class="glyphicon glyphicon-folder-close"></span> 模型管理 </a>
					</li>
					<li class="guide_words_pos"><a 
						href="model/query" target="contentFrame">查看</a>
					</li>
					<li class="guide_words_pos"><a 
						href="model/add" target="contentFrame">增加</a>
					</li>
					<li class="guide_words_pos"><a 
						href="model/change" target="contentFrame">修改</a>
					</li>
					<li class="guide_words_pos"><a 
						href="model/delete" target="contentFrame">删除</a>
					</li>
					<hr>
					<li id="modelPractice" class="eneditable_li"><a href="description/modelPractice"
						target="contentFrame"> <span
							class="glyphicon glyphicon-folder-close"></span> 模型训练 </a>
					</li>
					<li class="guide_words_pos"><a 
						href="practice/startPractice" target="contentFrame">执行训练</a>
					<hr>
					
					<li class="eneditable_li"><a href="description/reasoning"
						target="contentFrame"> <span
							class="glyphicon glyphicon-folder-close"></span> 基于模型推理 </a>
					</li>
					
					<li class="guide_words_pos"><a 
						href="reason/startReason" target="contentFrame">输入参数</a>
					</li>
					<li class="guide_words_pos"><a 
						href="reason/result" target="contentFrame">推理结果</a>
					</li>
					<hr>
					<li class="eneditable_li"><a href="jsp/message/receive.html" target="contentFrame"> <span
							class="glyphicon glyphicon-folder-close"></span> 消息管理 </a>
					</li>
					<li class="guide_words_pos"><a 
						href="jsp/message/receive.html" target="contentFrame">已收消息</a>
					</li>
					<li class="guide_words_pos"><a 
						href="jsp/message/send.html" target="contentFrame">已发消息</a>
					</li>
					<hr>
					<li class="eneditable_li"><a href="log/query"
						target="contentFrame"><span
							class="glyphicon glyphicon-calendar"></span> 日志 </a>
					</li>
					<li class="guide_words_pos"><a 
						href="log/query" target="contentFrame">查询</a>
					</li>
				</ul>
			</div>
			
			<!-- tabs -->
			<div class="col-xs-10">
				<!-- Nav tabs -->
				<ul id="myTab" class="nav nav-tabs" role="tablist">
					<li class="active"><a href="#homeTab" role="tab"
						data-toggle="tab">MBR介绍</a>
					</li>
					<li><a href="#modelManageTab" role="tab" data-toggle="tab">模型管理</a>
					</li>
					<li><a href="#modelPracticeTab" role="tab" data-toggle="tab">模型训练</a>
					</li>
					<li><a href="#reasonalTab" role="tab" data-toggle="tab">基于模型推理</a>
					</li>
					<li><a href="#messageTab" role="tab" data-toggle="tab">消息管理</a>
					</li>
					<li><a href="#logsTab" role="tab" data-toggle="tab">日志记录</a>
					</li>
				</ul>
				<iframe id="iframe" src="intro/MBRintroduce" name="contentFrame"
					id="contentFrame" frameborder="0" scrolling="auto"
					style="overflow-x:hidden; overflow-y:auto;" width="100%"
					height="650px"></iframe>
			</div>
		</div>
		<hr>
		
		<!-- footer -->
		<div class="row">
			<div class="col-xs-12">
				<p class="text-center">Copyright &copy; 2014, 中国重型机械研究院股份公司</p>
			</div>
		</div>
	</div>

</body>
</html>
