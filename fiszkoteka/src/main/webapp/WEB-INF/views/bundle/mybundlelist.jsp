<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

</head>
<body>
<jsp:include page="../menu/menuuser.jsp" />





<div class="container">
<div class="row">
<form:form class="form-inline" action="/spring/bundle/searchOwn" commandName="search" method="post">
	<div class="form-group">
		<label for="searchTxt"></label>
		<form:input class="form-control" id="searchTxt" path="searchText"/>
		<form:errors path="searchText" />
	</div>
	<button type="submit" class="btn btn-default">Szukaj!</button>
</form:form>
</div>
<br/>
<div class="row" >
<table class="table table-bordered">
<tr><th></th><th></th></tr>


<c:forEach items="${bundles}" var="bundle" >
<tr>
<spring:url value="/bundle/edit" var="edytuj">
	<spring:param name="id" value="${bundle.idBundle}"></spring:param>
</spring:url>
<td class="col-md-4"> ${bundle.nameBundle} </td>
<td class="col-md-4">
<a href="/spring/card/list?id=${bundle.idBundle}" >
    <button type="submit">Fiszki</button>
</a>
</td>
<td class="col-md-4">
	<a href="/spring/bundle/edit?id=${bundle.idBundle}" >
    <button type="submit">Edytuj</button>
</a>
</td>
<td class="col-md-4">
	<a href="/spring/bundle/reallydelete?id=${bundle.idBundle}">
    <button type="submit">Usuń</button>
	</a>
</td>
</tr>
</c:forEach>

</table>
</div>
</div>
</body>
</html>