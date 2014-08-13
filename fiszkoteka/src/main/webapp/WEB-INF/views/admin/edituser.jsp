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

	<jsp:include page="../menu/menuadmin.jsp" />
	<form:form commandName="user"  action="/spring/admin/editform">
		<div>
			<form:label path="">E-mail</form:label>
			${user.email}
			
		</div>
		<form:hidden path="idUser"/>
		<div>
			<form:label path="">Hasło</form:label>
			<form:input path="pass"/>
		</div>
		<div>
			<form:label path="">Rola</form:label>
			<form:select path="roleUser">
			 <form:option value="-" label="--Wybierz rolę">  
				<form:options items="${role}"/>
			</form:option>	
			</form:select>
		</div>
			<input type="submit" name="ok" value="change"  />
			<input type="submit" name="cancel" value="cancel" />
	</form:form>
</body>
</html>