<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="../menu/menuteacher.jsp" />
	<table>
		<thead></thead>
		<c:forEach items="${users}" var="user">
		<tr>
			<td> ${user.email} </td>
			<!-- <td><button onclick="usun(${user.idUser})">Usuń</button></td> -->
			<td><form:form action="/spring/grade/add?id=${user.idUser}"><button type="submit">Wystaw ocenę</button></form:form></td>
			<td><form:form action="/spring/grade/show?id=${user.idUser}&gid=${groupId}"><button type="submit">Pokaż oceny</button></form:form></td>
		</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>