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
	<jsp:include page="../menu/menuuser.jsp" />
	<div class="container">
	<c:forEach items="${groups}" var="group">
	
	<tr>
		<td> ${group.namegroups}</td>
		<td>
			<form:form action="/spring/group/withdraw?id=${group.idgroup}"><button type="submit">Wypisz się</button></form:form>
			<form:form action=""><button type="submit">Moje oceny</button></form:form>
		</td>
		
	</tr>
	
	</c:forEach>
	</div>
</body>
</html>