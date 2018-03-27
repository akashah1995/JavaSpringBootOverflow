<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Question's Dashboard</h2>
	<form action = '/questions/add' method = 'POST'>
		Question: <input type = "text" name = "question">
		Tags: <input type = "text" name = "tags">
		<input type = "submit" value = "Post">
	</form>
</body>
</html>