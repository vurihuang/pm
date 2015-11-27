<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>index</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>
	<frameset cols="325,*" framespacing="2" frameborder="yes" border="0" bordercolor="#000000">
		<frame src="<%=request.getContextPath() %>/index/nav_side.jsp" noresize="noresize" name="scoretopFrame" scrolling="No" id="scoretopFrame" title="scoretopFrame">
		<frame src="<%=request.getContextPath() %>/index/base_info.jsp" name="mainframe">
	</frameset> 
</html>
