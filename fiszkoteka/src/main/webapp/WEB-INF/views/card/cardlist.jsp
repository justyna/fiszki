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
<jsp:include page="../menu/menuuser.jsp" />
<br/>
<a href="/spring/card/add?id=${id}"><button>Dodaj fiszkę</button></a>
<br/>
<table>
	<tr>
	<c:forEach items="${cards}" var="card">
	<td>${card.word}</td>
	<td>${card.translation}</td>
	<td>${card.numberanswer}</td>
	<td>${card.incorrect}</td>
	<td>${card.correct}</td>
	<td><a href="/spring/card/show?id=${card.idcard}"><button>Pokaż</button></a></td>
	<td><a href="/spring/card/edit?id=${card.idcard}"><button>Edytuj</button></a></td>
	<td><a href="/spring/card/deleteconfirmation?id=${card.idcard}"><button>Usuń</button></a></td>
	</c:forEach>
	</tr>
</table>
</body>
</html>