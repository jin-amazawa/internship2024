<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	.option{
		display: inline-block;
		width: 80px;
	}

</style>
</head>
<body>
	<p>${errorMsg}</p>
	<form action = "/servletSample/signin" method = "POST">
	
		<p><div class = "option">ID</div> <input type = "text" name = "id"></p>
		<p><div class = "option">Password</div> <input type= "password" name = "password"></p>
		<p><input type = "submit" value = "SignIn"></p>
		
		<a href = "registration">新規登録はこちら</a>
	
	</form>
</body>
</html>