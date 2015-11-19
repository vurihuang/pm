<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title> -->
<meta charset="UTF-8">
    <title>欢迎来到试卷管理系统</title>
    <link rel="stylesheet" href="../css/style.css"/>
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
    <div class="wrapper">
        <div class="container">
            <h1>Welcome</h1>

            <form action="<%=request.getContextPath() %>/LoginServlet" method="post" name="loginform">
                <input type="text" name="username" placeholder="账号"/>
                <input type="password" name="password" placeholder="密码"/>
                <button type="submit" id="login_button" onclick="return check(this);">登录</button>
                
            </form>
        </div>
        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</body>
</html>