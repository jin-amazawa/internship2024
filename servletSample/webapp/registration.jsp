<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<style>

	.option{
		display: inline-block;
		width: 100px;
	}

</style>
</head>
<body>

	<form action = "/servletSample/registration" method = "POST">
	
		<p><div class = "option">ID</div> <input type = "text" name = "id"></p>
		<p><div class = "option">Password</div> <input type= "password" name = "password"></p>
		<p><div class = "option">User Name</div> <input type= "text" name = "username"></p>
		<p><div class = "option">Age</div> <input type= "number" name = "age"></p>
		<p><input type = "submit" value = "Register"></p>

	</form>

</body>
</html>