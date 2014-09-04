<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${message}
	<br/>
	<form:form modelAttribute="remindPasswordValidator" action="/spring/send">
		<label>Email</label>
		<form:input path="email"/>
		<form:errors path="email"></form:errors>
		<form:button>Przypomnij hasło</form:button>
	</form:form>
	
</body>
</html>