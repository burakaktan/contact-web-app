<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Contact</title>
</head>
<body>
	<form action = "/contactWebApp/search" method="post">
		<label for="name_id">enter name to search: </label>
		<br>
		<input type="text" id = "name_id" name = "name" >
		<input type="submit" value="Search!">
	</form>
</body>
</html>