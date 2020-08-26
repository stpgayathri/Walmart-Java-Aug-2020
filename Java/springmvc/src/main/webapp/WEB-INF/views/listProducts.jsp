<%@page import="com.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
</head>
<body>
	<h2>List of Products</h2>
	
	<% List<Product> products = (List<Product>)request.getAttribute("allProducts"); %>
	
	<p>
		<a href="add">Add New</a>
	</p>
	
	<table>
		<thead>
			<tr>
				<th>Product ID</th>
				<th>Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<% for(Product product: products){ %>
				<tr>
					<td>
						<%=product.getId() %>
					</td>
					<td>
						<%=product.getName() %>
					</td>
					<td>
						<%=product.getPrice() %>
					</td>
				</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>








