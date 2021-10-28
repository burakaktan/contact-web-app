<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Contact</title>
</head>
<body>
	<form action="/contactWebApp/create" method = "post">
		<label for="name_id">Name:</label>
			<br> 
			<input type="text" id="name_id" name="name">
			<br>
			<label for="gsm_id"> GSM Number:</label>
			<br>
			<input type="text" id="gsm_id" name="gsm">
			<input type="submit" value="Submit">
	</form>

</body>
</html>