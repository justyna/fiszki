<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	
	<c:forEach items="${cards}" var="card">
	<tr>
	<td>${card.word}</td>
	<td>${card.translation}</td>
	<td>${card.numberanswer}</td>
	<td>${card.incorrect}</td>
	<td>${card.correct}</td>
	<td><a href="/spring/card/show?id=${card.idcard}"><button>Pokaż</button></a></td>
	</tr>
	</c:forEach>
	
</table>
</body>
</html>