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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<!-- jQuery -->
    <script src="<c:url value='/index/bower_components/jquery/dist/jquery.min.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/index/css/drop-down.css'/>" />
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
		.glyphicon{
			margin-top:30px;
			margin-left:30px;
			font-size:30px;
			float:left;
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
		.lab1{
			width:10px;
			height:10px;
			background-color:rgba(255,30,30,1);
			left:130px;		
			top:185px;
			position:absolute;
		}
		.stu{
			left:146px;
			top:180px;
			position:absolute;
		}
		.lab2{
			width:10px;
			height:10px;
			background-color:rgba(70,161,248,1);
			left:293px;		
			top:185px;
			position:absolute;
		}
		.max{
			left:310px;
			top:180px;
			position:absolute;
		}
		.lab3{
			width:10px;
			height:10px;
			background-color:rgba(251,223,30,1);
			left:463px;		
			top:185px;
			position:absolute;
		}
		.min{
			left:481px;
			top:180px;
			position:absolute;
		}
		.lab4{
			width:10px;
			height:10px;
			background-color:rgba(128,255,0,1);
			left:643px;		
			top:185px;
			position:absolute;
		}
		.avg{
			left:660px;
			top:180px;
			position:absolute;
		}
		.form{
			margin-top:100px;
			margin-left:50px;
		}
		.chart{
			float:left;
			width:800px;
			margin-left:50px;
		}
		.sec{
			position:absolute;
			right:40px;
		}
	</style>
</head>

<body>
			<div class="chart">
				<div class="pass">
					<!-- <span class="glyphicon glyphicon-user"></span> -->
					<img class="img" src="<c:url value='/index/image/user.png'/>"/>
					<p class="p">及格率</p>
					<p class="p">${passRate}%</p>			
				</div>
				<div class="best">
					<!-- <span class="glyphicon glyphicon-user"></span> -->
					<img class="img" src="<c:url value='/index/image/user.png'/>"/>
					<p class="p">优秀率</p>
					<p class="p">${ excellentRate}%</p>			
				</div>
				<div class="">
				<div>
					<div class="lab1"></div>
					<span class="stu">学生</span>
					<div class="lab2"></div>
					<span class="max">最高分</span>
					<div class="lab3"></div>
					<span class="min">最低分</span>
					<div class="lab4"></div>
					<span class="avg">平均分</span>
				</div>
				<canvas id="canvas" height="200px" width="600px"></canvas>
				</div>
			</div>
			<div class="sec">
				<!-- 下拉选择框 -->
				<form action="" method="get" class="form">
					<select name="drop1" class="ui-select" id="sel">
							<option>选择学生</option>
					<c:forEach items="${studentList}" var="student">
    						<option value="${student.studentID}" 
    							<c:if test="${student.studentID eq studentID}" >
  								selected='selected'
  								</c:if>>
  						${student.sname}</option>
    					</c:forEach>	
					</select>
				</form>
			</div>

	<script src="<c:url value='/index/js/Chart.js'/>"></script>
	<script>
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
					data : [89,91,80,85,88,91,94]
				},
				{
					label: "Min",
					fillColor : "rgba(251,223,30,0)",
					strokeColor : "rgba(251,223,30,1)",
					pointColor : "rgba(251,223,30,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(251,223,30,1)",
					data : [38,47,53,36,48,56,42]
				},
				{
					label: "Avg",
					fillColor : "rgba(128,255,0,0)",
					strokeColor : "rgba(128,255,0,1)",
					pointColor : "rgba(128,255,0,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(128,255,0,1)",
					data : [66,73,61,63,69,70,75]
				},
				{
					label: "Stu",
					fillColor : "rgba(255,30,30,0)",
					strokeColor : "rgba(255,30,30,1)",
					pointColor : "rgba(255,30,30,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(255,30,30,1)",
					data : [64,70,68,72,57,63,72]
				}
			]

		}
	
	<%-->设置折线图数据	--%>
	var value0 = [];
	var value1 = [];
	var value2 = [];
	var value3 = [];
	var value4 = [];
	 <c:forEach items="${maxScoreList}" var="maxScore">
	    value0.push("${maxScore.score}"); 
	 </c:forEach>
	 <c:forEach items="${minScoreList}" var="minScore">
	    value1.push("${minScore.score}"); 
	 </c:forEach>
	 <c:forEach items="${avgScoreList}" var="avgScore">
	    value2.push("${avgScore.score}"); 
	 </c:forEach>
	 <c:forEach items="${stuScoreList}" var="stuScore">
	    value3.push("${stuScore.score}"); 
	 </c:forEach>
	 <c:forEach items="${avgScoreList}" var="avgScore">
	    value4.push("${avgScore.testID}"); 
	 </c:forEach>
	lineChartData['datasets'][0]['data'] = value0;
	lineChartData['datasets'][1]['data'] = value1;
	lineChartData['datasets'][2]['data'] = value2;
	lineChartData['datasets'][3]['data'] = value3;
	lineChartData['labels'] = value4;
	
	window.onload = function(){
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myLine = new Chart(ctx).Line(lineChartData, {
			responsive: true
		});
	}
	//下拉选择框
	$(document).ready(function(){		
		$(".ui-select").selectWidget({
			change       : function (changes) {
				studentID = $("#sel").val();
				studentName = $("#sel option:checked").text();
				
				location.href= "<c:url value='/TeacherServlet?method=courseInfo&courseName=chinese&studentID='/>" +studentID+"&studentName="+studentName;
			},
			effect       : "slide",
			keyControl   : true,
			speed        : 200,
			scrollHeight : 300
		});
		
	});	
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
