<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录失败</title>
</head>
<style>
	body{
		color:blue;
		font-size: 14px;
		margin: 20px auto;
	}
	#error{
		text-align:center;
	}
</style>
<body>
	<div id="error">
		登录失败<br/>
		<%
			Object obj = request.getAttribute("msg");
			if(obj != null){
				out.println(obj.toString());
			}
			else{
				out.println("其他错误");
			}
		%>
		<br/>
		用户名：<%= request.getParameter("username") %><br/>
		密码：<%= request.getParameter("password") %><br/>
		<a href="<%= request.getContextPath() %>/login/login.jsp">返回登录页面</a>
	</div>
</body>
</html>