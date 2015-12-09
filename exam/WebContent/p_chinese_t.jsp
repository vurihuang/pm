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
	<link rel="stylesheet" href="/index/css/drop-down.css" />
	<script src="<c:url value='/index/js/jquery-ui.min.js'/>"></script>
	<script src="<c:url value='/index/js/select-widget-min.js'/>"></script>
	<style>
		#page-wrapper{
			//border:1px solid #e7e7e7;
		}
		.diff{
			background-color:#337ab7;
			width:240px;
			height:140px;
			border-radius:10px;
			margin-left:0px;
			margin-top:50px;
			margin-bottom:50px;
			opacity:0.5;
			float:left;
		}
		.vali{
			background-color:#5cb85c;
			width:240px;
			height:140px;
			border-radius:10px;
			margin-left:10px;
			margin-top:50px;
			margin-bottom:50px;
			opacity:0.5;
			float:left;
		}
		.reli{
			background-color:#f0ad4e;
			width:240px;
			height:140px;
			border-radius:10px;
			margin-left:10px;
			margin-top:50px;
			margin-bottom:50px;
			opacity:0.5;
			float:left;
		}
		.dist{
			background-color:#d9534f;
			width:240px;
			height:140px;
			border-radius:10px;
			margin-left:10px;
			margin-top:50px;
			margin-bottom:50px;
			opacity:0.5;
			float:left;
		}
		.div:hover{
			opacity:1;
		}
		.p{
			color:white;
		}
		.pp{
			margin-top:30px;
			font-size:80px;
		}
		.title{
			font-size:30px;
			color:black;
		}
		tr:hover{
			background-color:#99ffff;
		}
		.table{
			word-break:break-all; 
			word-wrap:break-all;
		}
		td{
			text-align:center;
		}
	</style>
</head>

<body>

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
                        <a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                </li>
            </ul>
            <!-- /.左边导航 -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
						<!-- 个人信息 -->
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <p class="text-center">老师信息：</p>
								<p class="text-center">姓名：</p>
								<p class="text-center">年级：</p>
                            </div>
                            <!-- /功能 -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-dashboard fa-fw"></i> 成绩分析<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
                                <li>
                                    <a href="s_grade_t.jsp">综合</a>
                                </li>
                                <li>
                                    <a href="s_chinese_t.jsp">语文</a>
                                </li>
								<li>
                                    <a href="s_math_t.jsp">数学</a>
                                </li>
                                <li>
                                    <a href="s_english_t.jsp">英语</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 试卷分析<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="p_chinese_t.jsp">语文</a>
                                </li>
								<li>
                                    <a href="p_math_t.jsp">数学</a>
                                </li>
                                <li>
                                    <a href="p_english_t.jsp">英语</a>
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
			<div class="col-lg-12">
				<div class="div diff">
					<div class="col-xs-3">
						<i class="glyphicon glyphicon-edit p pp"></i>
                    </div>
					<div class="col-xs-9 text-right">
						<div class="huge p">难度：0.65</div>
						<div class="p">难度中等</div>
					</div>
				</div>
				<div class="div vali">
					<div class="col-xs-3">
						<i class="glyphicon glyphicon-tags p pp"></i>
                    </div>
					<div class="col-xs-9 text-right">
						<div class="huge p">效度：0.65</div>
						<div class="p">试卷质量高</div>
					</div>			
				</div>
				<div class="div reli">
					<div class="col-xs-3">
						<i class="glyphicon glyphicon-eye-open p pp"></i>
                    </div>
					<div class="col-xs-9 text-right">
						<div class="huge p">信度：0.65</div>
						<div class="p">试卷可靠程度一般</div>
					</div>			
				</div>
				<div class="div dist">
					<div class="col-xs-3">
						<i class="glyphicon glyphicon-send p pp"></i>
                    </div>
					<div class="col-xs-9 text-right">
						<div class="huge p">区分：0.65</div>
						<div class="p">区分程度优秀</div>
					</div>			
				</div>
			</div>
			<div class="col-lg-8">
				<!-- 试卷信息 -->
				<table class="table table-bordered">
					<caption class="text-center title">试卷1</caption>
					<thead>
						<tr>
							<th class="text-center">试卷题目</th>
							<th width="100px" class="text-center">错误率</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
							<td>68%</td>
						</tr>
						<tr>
							<td>XXXX</td>
							<td>86%</td>
						</tr>
						<tr>
							<td>X</td>
							<td>50%</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-lg-4">
			<!-- 下拉选择框 -->
				<form action="" method="get" class="form">
					<select name="drop1" class="ui-select">
						<option value="1">试卷1</option>
						<option value="2">试卷2</option>
						<option value="3">试卷3</option>
						<option value="4">试卷4</option>
						<option value="5">试卷5</option>
						<option value="6">试卷6</option>
						<option value="7">试卷7</option>
						<option value="8">试卷8</option>
						<option value="9">试卷9</option>
					</select>
				</form>
			</div>
		</div>
        

    </div>	
	<script>
	//下拉选择框
	$(document).ready(function(){		
		$(".ui-select").selectWidget({
			change       : function (changes) {
				return changes;
			},
			effect       : "slide",
			keyControl   : true,
			speed        : 200,
			scrollHeight : 250
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