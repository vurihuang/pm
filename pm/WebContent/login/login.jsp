<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
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
	<form action="<%= request.getContextPath()%>/CheckLoginServlet" method="post" name="loginform">
		<table border="5" cellspacing="5" bordercolor="silver" align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="snow">登录</td>
			</tr>
			<tr>
				<td>账号<input type="text" name="username" /></td>	
			</tr>
			<tr>
				<td>密码<input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="submit" onclick="return check(this);"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>