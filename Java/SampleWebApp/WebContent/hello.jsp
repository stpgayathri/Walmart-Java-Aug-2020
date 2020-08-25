<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello</title>
</head>
<body>

	<h2>Hello JSP</h2>
	
	<p>
		Generated date: <%=new java.util.Date().toString() %>
	</p>
	
	<p>
		Message: <%=request.getParameter("msg") %>
	</p>
</body>
</html>