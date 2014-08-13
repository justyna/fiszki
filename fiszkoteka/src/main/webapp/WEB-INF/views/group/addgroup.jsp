<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodaj grupę</title>
</head>
<body>
	<jsp:include page="../menu/menuteacher.jsp" />
	<div class="container">
	<br/>
	${ message }
	<br/>
	<form:form method="post" commandName="group" action="/spring/group/add">
		<form:label path="" >Nazwa</form:label>
		<form:hidden path="idgroup"/>
		<form:input path="namegroups" id="namegroups" />
		<form:button >Utwórz</form:button>
		
	</form:form>
	</div>
</body>
</html>