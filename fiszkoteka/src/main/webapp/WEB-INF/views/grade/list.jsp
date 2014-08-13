<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
</head>
<body>
<jsp:include page="../menu/menuteacher.jsp" />
	<div class="container">
	<table>
		<c:forEach items="${grades}" var="grade">
		<tr>
			<td>${grade.forwhat}</td>
			<td>${grade.grade}</td>
			<td><form:form action="/spring/grade/edit?id=${grade.idgrades}"><button>Edytuj</button></form:form>
			</td>
			<!-- <td><form:form action="/spring/grade/delete?id=${grade.idgrades}"><button>Usuń</button></form:form></td> -->
			<td><button onclick="usun(${grade.idgrades})">Usuń</button></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div id="dialog" title="Basic dialog" class="hidden">
  		<p>This is the default dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon.</p>
		<form:form action="/spring/group/delete?id=${user.idUser}"><button type="submit">Usuń</button></form:form>
	</div>
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
  	<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
  	<script type="text/javascript">
  jQuery.noConflict();
  function usun(id){
		// alert(id);
		 jQuery( "#dialog" ).removeClass('hidden').dialog({
			 buttons: {
				"Potwierdzam": function() {
					jQuery(this).dialog("close");
					jQuery.ajax({
						url: "/spring/grade/delete?id="+id,
						success: function() {
						    window.location.reload(true);
						}
					});
				},
				Cancel: function() {
					jQuery(this).dialog("close");
				}
			 }
		 });
		 
		  

	 };
	 
  /*jQuery(document).ready(function(){
 	alert('in');
	
	jQuery( "#dialog" ).dialog();
  
	 });*/
	
  
  </script>
</body>
</html>