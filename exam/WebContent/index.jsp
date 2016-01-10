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
		<div class="container">
			<div class="row">
				<!-- <div class="col-xs-2">
				</div> -->
				<div class="col-xs-12 text-center welcome"><p>试卷管理分析系统</p></div>

			</div>				
			<div class="row main">
				<div class="col-sm-6 text-right">
					<div><img src="<c:url value='/index/image/logo.jpg'/>" class="img-rounded img" width="100%" height="100%"></div>
				</div>
				<div class="col-sm-6 rdiv">
					<div class="border">
						<form action="<%=request.getContextPath() %>/CheckLoginServlet" method="post" name="loginform" class="form">
							<input class="input" type="text" name="username" placeholder="账号"/>
							<input class="input" type="password" name="password" placeholder="密码"/>
							<input type="hidden" name="method" value="checkInfo"/>
							<div class="radio row">
								<div class="col-xs-6"><input type="radio" name="user" value="teacher" checked="checked">
									<span>教师</span>
								</div>
								<div class="col-xs-6"><input type="radio" name="user" value="student">
								<span>学生</span>
								</div>
							</div>
							<button type="submit" id="login_button" onclick="return check(this);">登录</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body> 
</html> 
