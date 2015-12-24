<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>试卷管理分析系统(教师端)</title>

<!-- Bootstrap Core CSS -->
<link
	href="<c:url value='/index/bower_components/bootstrap/dist/css/bootstrap.min.css'/>"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="<c:url value='/index/bower_components/metisMenu/dist/metisMenu.min.css'/>"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="<c:url value='/index/dist/css/timeline.css'/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value='/index/dist/css/sb-admin-2.css'/>"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link
	href="<c:url value='/index/bower_components/morrisjs/morris.css'/>"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<c:url value='/index/bower_components/font-awesome/css/font-awesome.min.css'/>"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- jQuery -->
<script
	src="<c:url value='/index/bower_components/jquery/dist/jquery.min.js'/>"></script>
<link rel="stylesheet" href="<c:url value='/index/css/drop-down.css'/>" />
<script src="<c:url value='/index/js/jquery-ui.min.js'/>"></script>
<script src="<c:url value='/index/js/select-widget-min.js'/>"></script>
<script src="<c:url value='/index/js/highcharts.js'/>"></script>
<style>
#page-wrapper { //
	border: 1px solid #e7e7e7;
}

.title {
	font-size: 30px;
	color: black;
}

tr:hover {
	background-color: #eeeeee;
}

.table {
	word-break: break-all;
	word-wrap: break-all;
}

td {
	text-align: center;
}

.info {
	width: 900px;
	margin-left: 100px;
	margin-bottom: 100px;
}

.divp {
	text-align: left;
	font-size: 20px;
	margin-bottom: 10px;
}

.sec1 {
	position: absolute;
	left: 770px;
	top: 40px;
}

.sec2 {
	position: absolute;
	left: 950px;
	top: 40px;
}

.dropdown-menu {
	width: 730px; //
	text-align: center;
}

.d {
	word-break: break-all;
	word-wrap: break-all;
}

.uli:hover {
	background-color: #eeeeee
}

#container {
	width: 750px;
}
</style>
</head>

<body style="background-color: white">
	<div id="container"></div>
	<div class="info">
		<!-- 试卷信息 -->
		<table class="table table-bordered">
			<caption class="text-center title">错题分析</caption>
			<thead>
				<tr>
					<th class="text-center">编号</th>
					<th width="490px" class="text-center">试卷题目</th>
					<th class="text-center">做题人数</th>
					<th class="text-center">正确人数</th>
					<th class="text-center">错误率</th>
					<th class="text-center">学生状态</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${vQuestionList}" var="vQuestion">
					<tr>
						<td>${vQuestion.sequence}</td>
						<td>${vQuestion.subject}</br> (A): ${vQuestion.choiceA}</br> (B):
							${vQuestion.choiceB}</br> (C): ${vQuestion.choiceC}</br> (D):
							${vQuestion.choiceD}</br>
						</td>
						<td>${vQuestion.num}</td>
						<td>${vQuestion.successNum}</td>
						<td>${vQuestion.rate * 100}%</td><!--  错误率扩大100倍-->
						<td>${vQuestion.stustatus}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="sec1">
		<div class="divp">选择年级</div>
		<!-- 年级下拉选择框 -->
		<form action="" method="get" class="form">
			<select name="drop" class="ui-select" id="grade-select">
				<c:forEach items="${vScopeList}" var="vScope">
					<option value="${vScope.name}"
						<c:if test="${vScope.name eq selectGrade}" >
  									selected='selected'
  								</c:if>>
						${vScope.name}</option>
				</c:forEach>
			</select>
		</form>
	</div>


	<div class="sec2">
		<div class="divp">选择试卷</div>
		<!-- 试卷下拉选择框 -->
		<form action="" method="get" class="form">
			<select name="drop" class="ui-select" id="test-select">
				<c:forEach items="${vTestMainList}" var="vTestMain">
					<option value="${vTestMain.pk_test_main_ID}"
						<c:if test="${vTestMain.pk_test_main_ID eq selectTest}" >
  									selected='selected'
  								</c:if>>
						${vTestMain.pk_test_main_ID}</option>
				</c:forEach>
			</select>
		</form>
	</div>

	<script>
		//下拉选择框
		$(document)
				.ready(
						function() {
							$("#grade-select")
									.selectWidget(
											{
												change : function(changes) {
													subject = "${selectSubject}";
													grade = $("#grade-select")
															.val();
													location.href = "<c:url value='/StudentTestServlet?method=loadGrade&grade='/>"
															+ grade
															+ "&subject="
															+ subject;
												},
												effect : "slide",
												keyControl : true,
												speed : 200,
												scrollHeight : 250
											});

							$("#test-select")
									.selectWidget(
											{
												change : function(changes) {
													subject = "${selectSubject}";
													testID = $("#test-select")
															.val();
													grade = $("#grade-select")
															.val();
													location.href = "<c:url value='/StudentTestServlet?method=loadGrade&testID='/>"
															+ testID
															+ "&grade="
															+ grade
															+ "&subject="
															+ subject;
												},
												effect : "slide",
												keyControl : true,
												speed : 200,
												scrollHeight : 250
											});

						});
		//错误率图
		$(document)
				.ready(
						function() {
							var chart = {
								type : 'bar'
							};
							var title = {
								text : '知识点错误率'
							};
							var xAxis = {
								categories : [ '知识点A', '知识点B', '知识点C', '知识点D',
										'知识点E' ],
								title : {
									text : null
								}
							};
							var yAxis = {
								min : 0,
								title : {
									text : '',
									align : 'high'
								},
								labels : {
									overflow : 'justify'
								}
							};
							var tooltip = {
								valueSuffix : '%'
							};
							var plotOptions = {
								bar : {
									dataLabels : {
										enabled : true
									}
								}
							};
							var legend = {
								layout : 'vertical',
								align : 'right',
								verticalAlign : 'top',
								x : -40,
								y : 0,
								floating : true,
								borderWidth : 1,
								backgroundColor : ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
								shadow : true
							};
							var credits = {
								enabled : false
							};

							var series = [ {
								name : '错误率',
								data : [ 90, 80, 70, 60, 50 ]

							} ];
							//取出后端返回数据给知识点错误率图表赋值
							var xAxisData = [];
							<c:forEach items="${vQuestionKeywordList}" var="vQuestion">
							xAxisData.push("${vQuestion.keyword}");
							</c:forEach>
							//有值才赋值，没值就展现初始值
							if (xAxisData.length > 1) {
								xAxis['categories'] = xAxisData;
							}
							var seriesData = [];
							<c:forEach items="${vQuestionKeywordList}" var="vQuestion">
							//此处将字符串转化为float类型，否则图画不出来
							seriesData.push(parseFloat("${vQuestion.wrong * 100}"));/*  错误率扩大100倍*/
							</c:forEach>
							//有值才赋值，没值就展现初始值
							if (seriesData.length > 1) {
								series[0]['data'] = seriesData;
							}

							var json = {};
							json.chart = chart;
							json.title = title;
							json.tooltip = tooltip;
							json.xAxis = xAxis;
							json.yAxis = yAxis;
							json.series = series;
							json.plotOptions = plotOptions;
							json.legend = legend;
							json.credits = credits;
							$('#container').highcharts(json);

						});
	</script>


	<!-- /#wrapper -->

	<!-- Bootstrap Core JavaScript -->
	<script
		src="<c:url value='/index/bower_components/bootstrap/dist/js/bootstrap.min.js'/>"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="<c:url value='/index/bower_components/metisMenu/dist/metisMenu.min.js'/>"></script>

	<!-- Morris Charts JavaScript -->
	<script
		src="<c:url value='/index/bower_components/raphael/raphael-min.js'/>"></script>
	<script
		src="<c:url value='/index/bower_components/morrisjs/morris.min.js'/>"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<c:url value='/index/dist/js/sb-admin-2.js'/>"></script>

</body>

</html>
