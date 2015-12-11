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
		.info{
			float:left;
			width:750px;
			margin-left:50px;
			margin-top:30px;
		}
		.sec{
			position:absolute;
			left:820px;
			top:60px;
		}
	</style>
</head>

<body>
			<div class="info">
				<!-- 试卷信息 -->
				<table class="table table-bordered">
					<caption class="text-center title">历史错题</caption>
					<thead>
						<tr>
							<th class="text-center">题目</th>
							<th width="100px" class="text-center">错误率</th>
							<th width="100px" class="text-center">学生状态</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</td>
							<td>68%</td>
							<td>对</td>
						</tr>
						<tr>
							<td>XXXX</td>
							<td>86%</td>
							<td>错</td>
						</tr>
						<tr>
							<td>X</td>
							<td>50%</td>
							<td>对</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="sec">
			<!-- 下拉选择框 -->
				<form action="" method="get" class="form">
					<select name="drop1" class="ui-select">
						<option value="0">历史错题</option>
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
