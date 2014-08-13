<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="http://localhost:8080/spring/resources/css/bootstrap-3.1.1-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
<script src="http://localhost:8080/spring/resources/js/jquery-1.11.1.min.js"></script>
<script src="http://localhost:8080/spring/resources/css/bootstrap-3.1.1-dist/js/bootstrap.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>Czy na pewno chcesz usunąć wiązkę?</div>
<div class="row">
	<a href="/spring/bundle/delete?id=${id}"><button type="submit">TAK</button></a>
	<a href="/spring/bundle/listbundle"><button type="submit">NIE</button></a>
	
</div>
</body>
</html>