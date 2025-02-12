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

	<p>${error}</p>
	<p>${errorID}</p>

	<form action = "/servletSample/registration" method = "POST">
	
		<p><div class = "option">ID</div> <input type = "text" name = "id" required maxlength="50" pattern="[A-Za-z0-9]+"></p>
		<p><div class = "option">Password</div> <input type= "password" name = "password" required maxlength="100"></p>
		<p><div class = "option">User Name</div> <input type= "text" name = "username" maxlength="100"></p>
		<p><div class = "option">Age</div> <input type= "text" name = "age" maxlength="3" pattern="[0-9]+"></p>
		<p><input type = "submit" value = "Register"></p>

	</form>

</body>
</html>