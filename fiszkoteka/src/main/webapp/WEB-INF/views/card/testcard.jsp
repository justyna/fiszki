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
	<jsp:include page="../menu/menuuser.jsp" />
	<form:form modelAttribute="testValidator"  action="/spring/card/checkanswer?id=${id}">
		<form:errors path="*"/>
		<br/>
		<label></label>
		<form:input path="idCard" readonly="true" cssClass="hidden" ></form:input>
		<label></label>
		<form:input  path="question" readonly="true"/>
		<label></label>
		<form:input path="answer"/>
		<form:errors path="answer"></form:errors>
		
		<form:button  >Sprawdź</form:button>
	</form:form>
</body>
</html>