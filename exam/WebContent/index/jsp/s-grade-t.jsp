<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="<c:url value='/index/bower_components/bootstrap/dist/css/bootstrap.min.css'/>" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<c:url value='/index/bower_components/metisMenu/dist/metisMenu.min.css'/>" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="<c:url value='/index/dist/css/timeline.css'/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value='/index/dist/css/sb-admin-2.css'/>" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="<c:url value='/index/bower_components/morrisjs/morris.css'/>" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<c:url value='/index/bower_components/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="<c:url value='/index/css/drop-down.css'/>" />
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	    <!-- jQuery -->
    <script src="<c:url value='/index/bower_components/jquery/dist/jquery.min.js'/>"></script>
	<script src="<c:url value='/index/js/jquery-ui.min.js'/>"></script>
	<script src="<c:url value='/index/js/select-widget-min.js'/>"></script>
	<style>
		#page-wrapper{
			//border:1px solid #e7e7e7;
		}
		.pass{
			border:1px solid #aaa;
			width:200px;
			height:100px;
			border-radius:10px;
			margin-left:100px;
			margin-top:50px;
			margin-bottom:50px;
			opacity:0.5;
			float:left;
		}
		.pass:hover{
			opacity:1;
		}
		.best{
			border:1px solid #aaa;
			width:200px;
			height:100px;
			border-radius:10px;
			margin-left:100px;
			margin-top:50px;
			margin-bottom:50px;
			opacity:0.5;
			float:left;
		}
		.best:hover{
			opacity:1;
		}
		.p{
			font-size:20px;
			margin-left:120px;
			margin-top:13px;
		}
		.img{
			 width:100px;
			 height:100px;
			 float:left;
		}
		.lab{
			width:10px;
			height:10px;
			background-color:blue;
			left:340px;
			top:5px;
			position:absolute;
		}
		.span{
			left:340px;
			position:relative;
		}
		/*.lab1{
			width:10px;
			height:10px;
			background-color:rgba(255,30,30,1);
			left:80px;		
			top:5px;
			position:absolute;
		}
		.stu{
			left:80px;
			position:relative;
		}*/
		.lab2{
			width:10px;
			height:10px;
			background-color:rgba(70,161,248,1);
			left:240px;		
			top:5px;
			position:absolute;
		}
		.max{
			left:240px;
			position:relative;
		}
		.lab3{
			width:10px;
			height:10px;
			background-color:rgba(251,223,30,1);
			left:430px;		
			top:5px;
			position:absolute;
		}
		.min{
			left:385px;
			position:relative;
		}
		.lab4{
			width:10px;
			height:10px;
			background-color:rgba(128,255,0,1);
			left:610px;		
			top:5px;
			position:absolute;
		}
		.avg{
			left:518px;
			position:relative;
		}
		.form{
			margin-top:100px;
			margin-left:50px;
		}
		.chart{
			float:left;
			width:750px;
			margin-left:50px;
		}
		.sec{
			position:absolute;
			right:40px;
		}
	</style>
</head>

<body  onload="fun1(),fun2();">
			<div class="chart">				
				<div class="col-lg-12">
					<div class="lab"></div>
					<span class="span">分段人数</span>
					<canvas id="canvas" height="250" width="600"></canvas>
				</div>
				<div class="col-lg-12 div2">
					<div>
						<!-- <div class="lab1"></div>
						<span class="stu">平均分</span> -->
						<div class="lab2"></div>
						<span class="max">最高分</span>
						<div class="lab3"></div>
						<span class="min">最低分</span>
						<div class="lab4"></div>
						<span class="avg">平均分</span>
					</div>	
					<canvas id="canvas2" height="250" width="600"></canvas>				
				</div>
				
			</div>
			<%-- <div class="sec">
				<!-- 下拉选择框 -->
				<form action="" method="get" class="form">
					<select name="drop1" class="ui-select">
						<c:forEach items="${stuList }" var="stu">
						<option value="${stu.studentID }">${stu.sname }</option>
						</c:forEach>
					</select>
				</form>
			</div>   --%> 

	<script src="<c:url value='/index/js/Chart.js'/>"></script>
	<script>
	var barChartData = {
		labels : ["< 180","180~210","210~240","240~270","270~300"],
		datasets : [
			{
				fillColor : "rgba(151,187,205,0.5)",
				strokeColor : "rgba(151,187,205,0.8)",
				highlightFill : "rgba(151,187,205,0.75)",
				highlightStroke : "rgba(151,187,205,1)",
				data : [5,8,14,13,6]
			}
		]

	}
	var lineChartData = {
			labels : ["第一单元","第二单元","第三单元","第四单元","期中考","第五单元","第六单元","第七单元","第八单元","期末考"],
			datasets : [				
				{
					label: "Max",
					fillColor : "rgba(70,161,248,0)",
					strokeColor : "rgba(70,161,248,1)",
					pointColor : "rgba(70,161,248,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(70,161,248,1)",
					data : [289,291,280,285,288,291,294]
				},
				{
					label: "Min",
					fillColor : "rgba(251,223,30,0)",
					strokeColor : "rgba(251,223,30,1)",
					pointColor : "rgba(251,223,30,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(251,223,30,1)",
					data : [138,147,153,136,148,156,142]
				},
				{
					label: "Avg",
					fillColor : "rgba(128,255,0,0)",
					strokeColor : "rgba(128,255,0,1)",
					pointColor : "rgba(128,255,0,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(128,255,0,1)",
					data : [206,213,201,203,209,210,215]
				},
			]

		}
	<%-->设置柱状图数据	--%>
	var barValue = [];
	<c:forEach items="${sumcounts}" var="sumcount">
    barValue.push("${sumcount}"); 
 	</c:forEach>
 	barChartData['datasets'][0]['data'] = barValue;
	
	<%-->设置折线图数据	--%>
	var value0 = [];
	var value1 = [];
	var value2 = [];
	var value3 = [];
	var value4 = [];
	 <c:forEach items="${sumMaxScoreList}" var="sumMaxScore">
	    value0.push("${sumMaxScore.score}"); 
	 </c:forEach>
	 <c:forEach items="${sumMinScoreList}" var="sumMinScore">
	    value1.push("${sumMinScore.score}"); 
	 </c:forEach>
	 <c:forEach items="${sumAvgScoreList}" var="sumAvgScore">
	    value2.push("${sumAvgScore.score}"); 
	 </c:forEach>
	 <c:forEach items="${sumStuScoreList}" var="sumStuScore">
	    value3.push("${sumStuScore.score}"); 
	 </c:forEach>
	 <c:forEach items="${sumStuScoreList}" var="sumStuScore">
	    value4.push("${sumStuScore.testID}"); 
	 </c:forEach>
	lineChartData['datasets'][0]['data'] = value0;
	lineChartData['datasets'][1]['data'] = value1;
	lineChartData['datasets'][2]['data'] = value2;
	lineChartData['datasets'][3]['data'] = value3;
	lineChartData['labels'] = value4;
	
	
	function fun1(){
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myBar = new Chart(ctx).Bar(barChartData, {
			responsive : true
		});
	}
	function fun2(){
		var ctx = document.getElementById("canvas2").getContext("2d");
		window.myLine = new Chart(ctx).Line(lineChartData, {
			responsive: true
		});
	}
	</script>


    <!-- /#wrapper -->


    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='/index/bower_components/bootstrap/dist/js/bootstrap.min.js'/>"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<c:url value='/index/bower_components/metisMenu/dist/metisMenu.min.js'/>"></script>

    <!-- Morris Charts JavaScript -->
    <script src="<c:url value='/index/bower_components/raphael/raphael-min.js'/>"></script>
    <script src="<c:url value='/index/bower_components/morrisjs/morris.min.js'/>"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<c:url value='/index/dist/js/sb-admin-2.js'/>"></script>

</body>

</html>
