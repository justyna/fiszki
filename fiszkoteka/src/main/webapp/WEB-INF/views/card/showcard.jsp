<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../menu/menuuser.jsp" />
<div class="container">
	<br/>
	${card.word}
	<br/>
	${card.translation}
	<br/>
	${card.langword}
	<br/>
	${card.langtranslation}
	<br/>
	${card.definition}
	<br/>
	 <img src="http://localhost:8080/spring/resources/data/${card.picture}" alt="Brak zdjęcia" height="42" width="42"> 
	
	<br/>
	<audio controls>
  		<source src="http://localhost:8080/spring/resources/data/${card.mp3file}" type="audio/mpeg">
  		Your browser does not support the audio element.
	</audio>
</div>
</body>
</html>