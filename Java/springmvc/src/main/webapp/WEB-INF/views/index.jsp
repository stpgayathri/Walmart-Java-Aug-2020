<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h2>Welcome to Spring MVC</h2>
	
	<p>This is a sample web application</p>
	
	<p>
		Message: ${formattedMessage}     <%-- <%=request.getAttribute("formattedMessage") %> --%>
	</p>
	
	<p>
		Message Cookie: ${msgCookie} <%-- <%=request.getAttribute("msgCookie") %> --%>
	</p>
	
	<div>
		<a href="readcookie">View Cookie</a>
	</div>
</body>
</html>