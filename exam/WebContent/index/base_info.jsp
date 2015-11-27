<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'base_info.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <frameset rows="74,*" framespacing="2" frameborder="yes" border="0" bordercolor="#000000">
		<frame src="nav_info.jsp" noresize="noresize" name="scoretopFrame" scrolling="No" id="scoretopFrame" title="scoretopFrame">
		<frame src="<c:url value='/fuckServlet?method=getBaseData&scope=english'/>" name="rightmainframe">
	</frameset>
</html>
