<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 

<title>Rejestracja</title>
</head>
<body>
	<jsp:include page="../menu/menuuser.jsp" />
	<form:form method="post" commandName="register">
		<table>
		<tr>
			<td>
				<label for="emailId">Email</label>
			</td>
			<td>
				<form:input id="emailId" path="email"/>
				<form:errors path="email"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<label for="passwordId">Hasło</label>
			</td>
			<td>
			<form:password id="passwordId" path="password"/>
			<form:errors path="password"></form:errors>
			</td>
		</tr>
		<tr>
			<td>
				<label for="repasswordId">Powtórz hasło</label>
			</td>
			<td>
				<form:password path="repassword" id="repasswordId"/>
				<form:errors path="repassword"></form:errors>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit">
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>