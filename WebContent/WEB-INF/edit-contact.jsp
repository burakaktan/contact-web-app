<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Contact</title>
</head>
<body>
	<form method="post" action="/contactWebApp/edit">
		<label for="new_name_id">New Name:</label>
		<input type="text" id="new_name_id" name="new_name" />
		<br>
		<br>
		<label for="new_gsm_id">New Gsm Number:</label>
		<input type="text" name="new_gsm" id="new_gsm_id" />
		<input type="hidden" name="idToChange" value= <c:out value = "${idToChange}"/> />
		<br>
		<br>
		<input type="submit" value="Edit" />
	</form>
</body>
</html>