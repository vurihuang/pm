<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<style>
	body{
		color:blue;
		font-size: 14px;
		margin: 20px auto;
	}
	#success{
		text-align: center;
	}
</style>
<body>
	<div id="success">
		登录成功<br/>
		用户名：<%= request.getParameter("username") %><br/>
		密码：<%= request.getParameter("password") %><br/>
		<a href="<%= request.getContextPath() %>/login/login.jsp">返回登录页面</a>
	</div>
</body>
</html>