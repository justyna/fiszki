<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodaj fiszkę</title>
</head>
<body>
<jsp:include page="../menu/menuuser.jsp" />
	<form:form method="post" commandName="card" >
	<table>
	<tr>
		<td><label  for="wordId">Słowo</label></td>
		<td><form:input id="wordId" path="word"/></td>
		<td><form:errors path="word"></form:errors></td>
	</tr>
	<tr>
		<td><label for="translationId">Tłumaczenie</label></td>
		<td><form:input id="translationId" path="translation" /></td>
		<td><form:errors path="translation"></form:errors></td>
	</tr>
	<tr>
		<td><label for="langwordId">Język słowo</label></td>
		<td><form:input id="langwordId" path="langword"/></td>
		<td><form:errors path="langword"></form:errors></td>
	</tr>
	<tr>
		<td><label for="langtranslationId">Tłumaczenie</label></td>
		<td><form:input id="langtranslationId" path="langtranslation" /></td>
		<td><form:errors path="langtranslation"></form:errors></td>
	</tr>
	<tr>
		<td><label for="definitionId">Definicja</label></td>
		<td><form:input id="definitionId" path="definition"/></td>
		<td><form:errors path="definition"></form:errors></td>
	</tr>
	<tr>
		<td><label for="pictureId">Obraz</label></td>
		<td><form:input id="pictureId" path="picture" /></td>
		<td><form:errors path="picture"></form:errors></td>
	</tr>
	<tr>
		<td><label for="mp3fileId">Wymowa</label></td>
		<td><form:input id="mp3fileId" path="mp3file" /></td>
		<td></td>
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