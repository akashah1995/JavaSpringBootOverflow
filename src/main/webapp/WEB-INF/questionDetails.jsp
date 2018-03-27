<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Answers</title>
</head>
<body>
	<h2>${question.question}</h2>
	<table>
		<tr>
		<th>Answers</th>
		</tr>
	
	<c:forEach items = "${question.answers}" var = "answer" varStatus = "loop">
		<tr>
			<td> ${answer.answer} </td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<br>
	<form action = '/questions/${question.getId()}/answer' method = 'POST'>
		<input type = "text" name = "answer">
		<input type = "submit" value = "answer">
	</form>
</body>
</html>