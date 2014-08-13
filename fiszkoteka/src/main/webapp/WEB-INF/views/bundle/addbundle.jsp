<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodaj wiązkę</title>
</head>
<body>

<jsp:include page="../menu/menuuser.jsp" />

${message}
<br/>
	<form:form method="post"   modelAttribute="bundleValidator">
	<table>
	<tr>
		<td><label  for="">Nazwa</label></td>
		<td><form:input id="" path="name"/></td>
		<td><form:errors path="name"></form:errors></td>
	</tr>
	<tr>
			<td><form:label path="">Publiczny</form:label></td>
			<td><form:select path="visible">
			 <form:option value="-" >  
				<form:options items="${visible}"/>
			</form:option>	
			</form:select></td>
			<form:errors path="visible"></form:errors>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Submit">
		</td>
	</tr>
	</table>
	</form:form>
</body>
</html>