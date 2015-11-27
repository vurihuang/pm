<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'nav_info.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
body ul li {margin-left:80px; padding: 10px; font-size: 30px; }
ul { list-style-type: none; height: 38px; width:1200px;border-bottom:10px solid #21530C;margin-top:30px;margin-left:-30px;}
li { float: left; }
.li1{margin-left:120px;}
li a{
    text-decoration:none;
    display:inline-block;
    color:#000;
    height:30px;
    line-height:30px;
    margin:0 5px;
    padding-left:9px;
}
li a span{
    height:29px;
    display:inline-block;
    padding-right:9px;   
}

li a:hover{
    background:url(http://img.mukewang.com/538588030001c52300090027.jpg) no-repeat;
}

li a:hover span{
    background:#21530c url(http://img.mukewang.com/5385882d0001030900080027.jpg) no-repeat top right;
    color:#fff;
}

</style>
  </head>
  
<body>
<ul>
    <li class="li1"><a href="<c:url value='/fuckServlet?method=getBaseData&scope=english'/>" class="ac" target="rightmainframe"><span>总分情况</span></a></li>
    <li><a href="<c:url value='/fuckServlet?method=getBaseData&scope=chinese'/>" target="rightmainframe"><span>语文</span></a></li>
    <li><a href="<c:url value='/fuckServlet?method=getBaseData&scope=math'/>" target="rightmainframe"><span>数学</span></a></li>
    <li><a href="<c:url value='/fuckServlet?method=getBaseData&scope=english'/>" target="rightmainframe"><span>英语</span></a></li>
</ul>
</body>
</html>
