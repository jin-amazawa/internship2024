<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HelloWorld</h1>
	<p>>${now}</p>
	<%
		for(int i = 0; i < 5; i++){
			out.println("HelloWorld");
		}
	%>
	
	<form action="/servletSample/RequestSample" method="GET">
		<input type = "text" name="user_name">
		<input type = "text" name = "age">
		<input type = "submit" value ="送信">
	</form>
	
	<form action = "/servletSample/RequestSample" method = "Post">
		<input type = "text" name = "id">
		<input type = "password" name = "password">
		<input type = "submit" value = "送信">
	</form>
	
</body>
</html>