<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question Dashboard</title>
</head>
<body>
	<table>
		<tr>
			<th> Question </th>
			<th> Tags </th>
		</tr>
		<c:forEach items =  "${questions}" var = "question" varStatus = "loop">
			<tr>
				<td><a href = "/questions/${question.getId()}">${question.question}</a></td>
				<td><c:forEach items = "${question.tags}" var = "tag" varStatus = "loop">
					<c:out value = "${tag.subject},"></c:out>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>