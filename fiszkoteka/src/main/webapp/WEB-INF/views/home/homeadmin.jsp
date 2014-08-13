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
	
	<br/>
		<label>${ message }</label>
	<br/>
	<table>
   <thead>
<tr>
     <td width="2%"></td>
     <td width="30%">Email</td>
     <td width="10%">Rola</td>
     <td width="58%">Skasowany</td>
     <td></td>
    </TR>
</THEAD>
   <tbody>
   
    <c:forEach items="${users}" var="row" varStatus="status">
<tr class="${status.count % 2 == 0 ? 'even' : 'odd'}">
      <td>${first + status.count}</td>
      <td>${row.email}</td>
      <td>${row.roleUser}</td>
      <td>${row.deleted}</td>
      <td><form:form action="/spring/admin/edit?id=${row.idUser}">
      <button type="submit">Edytuj</button>
      </form:form></td>
      <td><form:form action="/spring/admin/delete?id=${row.idUser}">
      <button type="submit">Usuń</button>
      </form:form></td>
     </tr>
</c:forEach>
   </tbody>
  </table>
</body>
</html>