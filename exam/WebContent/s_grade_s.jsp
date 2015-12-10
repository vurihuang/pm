<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>试卷管理分析系统(学生端)</title>

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
	<style>
		#page-wrapper{
			border:1px solid #e7e7e7;
		}
		.glyphicon{
			margin-top:30px;
			margin-left:30px;
			font-size:30px;
			float:left;
		}
		.lab1{
			width:10px;
			height:10px;
			background-color:rgba(175,202,216,1);
			left:125px;		
			top:214px;
			position:relative;
		}
		.chinese{
			left:140px;
			position:relative;
		}
		.lab2{
			width:10px;
			height:10px;
			background-color:rgba(227,227,227,1);
			left:380px;		
			top:214px;
			position:absolute;
		}
		.math{
			left:349px;
			position:relative;
		}
		.lab3{
			width:10px;
			height:10px;
			background-color:rgba(97,103,116,1);
			left:620px;		
			top:214px;
			position:absolute;
		}
		.english{
			left:556px;
			position:relative;
		}
	</style>
</head>

<body onload="fun1(),fun2();">

    <div id="wrapper">

        <!-- 导航 -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">试卷管理分析系统</a>
            </div>

            <!-- /.退出 -->
            <ul class="nav navbar-top-links navbar-right">                
                <li class="">                  
                        <a href="login.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                </li>
            </ul>
            <!-- /.左边导航 -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
						<!-- 个人信息 -->
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <p class="text-left">学生信息：</p>
								<p class="text-left">姓名：<span>${name }</span></p>
								<p class="text-left">年级：<span>${course }</span></p>
								<p class="text-left">班级：<span>${sex }</span></p>
                            </div>
                            <!-- /功能 -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-dashboard fa-fw"></i> 成绩分析<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
                                <li>
                                    <a href="s_grade_s.jsp">综合</a>
                                </li>
                                <li>
                                    <a href="s_chinese_s.jsp">语文</a>
                                </li>
								<li>
                                    <a href="s_math_s.jsp">数学</a>
                                </li>
                                <li>
                                    <a href="s_english_s.jsp">英语</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 试卷分析<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="p_chinese_s.jsp">语文</a>
                                </li>
								<li>
                                    <a href="p_math_s.jsp">数学</a>
                                </li>
                                <li>
                                    <a href="p_english_s.jsp">英语</a>
                                </li>
                            </ul>
                        </li>                                                
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> 知识点分析</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> 聚类分析</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

		<div id="page-wrapper">
			
			<!-- 统计图 -->
			<div class="col-lg-12">
				<div class="col-lg-12 chart">
					<div>
						<span class="pr">PR</span>
					</div>
					<canvas id="canvas1" height="100px" width="600px"></canvas>
				</div>
				<div>
					<div class="lab1"></div>
					<span class="chinese">语文</span>
					<div class="lab2"></div>
					<span class="math">数学</span>
					<div class="lab3"></div>
					<span class="english">英语</span>
				</div>
				<canvas id="canvas2" height="200px" width="600px"></canvas>
				<center>学生语数英成绩图</center>
			</div>
		</div>
        

    </div>	
	<script src="<c:url value='index/js/Chart.js'/>"></script>
	<script>
		var barChartData = {
		labels : ["2015-10-15","2015-10-21","2015-10-27","2015-11-2","2015-11-8","2015-11-14","2015-11-20"],
		datasets : [
			{
				fillColor : "rgba(175,202,216,0.5)",
				strokeColor : "rgba(175,202,216,0.8)",
				highlightFill : "rgba(175,202,216,0.75)",
				highlightStroke : "rgba(175,202,216,1)",
				data : [75,78,73,68,88,60,87]
			},
			{
				fillColor : "rgba(227,227,227,0.5)",
				strokeColor : "rgba(227,227,227,0.8)",
				highlightFill : "rgba(227,227,227,0.75)",
				highlightStroke : "rgba(227,227,227,1)",
				data : [85,80,78,86,88,89,91]
			},
			{
				fillColor : "rgba(97,103,116,0.5)",
				strokeColor : "rgba(97,103,116,0.8)",
				highlightFill : "rgba(97,103,116,0.75)",
				highlightStroke : "rgba(97,103,116,1)",
				data : [63,66,68,70,72,60,61]
			}
		]

	}
	var lineChartData = {
			labels : ["2015-10-15","2015-10-21","2015-10-27","2015-11-2","2015-11-8","2015-11-14","2015-11-20"],
			datasets : [				
				{
					label: "pr",
					fillColor : "rgba(70,161,248,0)",
					strokeColor : "rgba(70,161,248,1)",
					pointColor : "rgba(70,161,248,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(70,161,248,1)",
					data : [89,91,80,85,88,91,94]
				}
			]

		}

	function fun1(){
		var ctx = document.getElementById("canvas1").getContext("2d");
		window.myLine = new Chart(ctx).Line(lineChartData, {
			responsive: true
		});
	}

	function fun2(){
		var ctx = document.getElementById("canvas2").getContext("2d");
		window.myBar = new Chart(ctx).Bar(barChartData, {
			responsive : true
		});
	}

	</script>

    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<c:url value='/index/bower_components/jquery/dist/jquery.min.js'/>"></script>

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
