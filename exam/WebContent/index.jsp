<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
	<head> 
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
		<link href="<c:url value='/index/bower_components/bootstrap/dist/css/bootstrap.min.css'/>" rel="stylesheet">
		<link rel="stylesheet" href="<c:url value='/index/css/login-style.css'/>"/>
		<script src="<c:url value='/index/bower_components/jquery/dist/jquery.min.js'/>"></script>
		<script src="<c:url value='/index/bower_components/bootstrap/dist/js/bootstrap.min.js'/>"></script>
		<title>登录</title> 
		<style type="text/css"> 
			
		</style> 
		<script type="text/javascript">
			function check(form){
				if(document.forms.loginform.username.value == ""){
					alert("用户名不能为空！");
					document.forms.loginform.username.focus();
					return false;
				}
				if(document.forms.loginform.password.value == ""){
					alert("密码不能为空！");
					document.forms.loginform.password.focus();
					return false;
				}
				
			}

    </script>
	</head> 
	<body> 
		<div class="top">
			<div class="col-lg-3 text-right">
				<div class="glyphicon glyphicon-new-window"></div>
			</div>
			<div class="col-lg-7 text-left welcome"><p>欢迎使用</p><p>试卷管理系统</p></div>
		</div>
		<div class="middle">		
			<div class="main">
				<div class="col-lg-6 text-right">
					<img src="<c:url value='/index/image/logo.jpg'/>" class="img-rounded img" width="500px" height="300px">
				</div>
				<div class="col-lg-6 rdiv text-left">
					<div class="border">
					<form action="<%=request.getContextPath() %>/CheckLoginServlet" method="post" name="loginform" class="form">
						<input class="input" type="text" name="username" placeholder="账号"/>
						<input class="input" type="password" name="password" placeholder="密码"/>
						<input type="hidden" name="method" value="checkInfo"/>
						<input type="radio" name="user" class="tear" value="teacher" checked><span class="teap">教师</span>
						<input type="radio" name="user" class="stur" value="student"><p class="stup">学生</p>
						
						<button type="submit" id="login_button" onclick="return check(this);">登录</button>
                    </form>
					</div>
				</div>
			</div>
		</div>
		<div class="bottom"></div>
	</body> 
</html> 
