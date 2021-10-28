<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Contact</title>
</head>
<body>
	<jsp:include page="search-contact.jsp"/>

	<%-- <c:out value=" ${searchResults.count} adet kayit bulundu."/> --%>
	
	<c:forEach var="element" items="${searchResults}">
		<form action="/contactWebApp/edit" method="get">
		<c:out value="${element.getName()} ${element.getGsm()}"/>
		<input type="hidden" name="id" value= <c:out value="${element.getId()}"/> />
		<input type="submit" value="Edit!"/>
		<br>
		<br>
		</form>
	</c:forEach>
</body>
</html>