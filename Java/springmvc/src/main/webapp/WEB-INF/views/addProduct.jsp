<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
	<h2>Add New Product</h2>
	
	<s:form method="POST" action="save" modelAttribute="product">

		<div>
			<p>
				<s:label path="id">ID: </s:label>
			</p>
			<div>
				<s:input path="id"/>
			</div>
			<span>
				<s:errors path="id"></s:errors>
			</span>
			
		</div>
		
		<div>
			<p>
				<s:label path="name">Name: </s:label>
			</p>
			<div>
				<s:input path="name"/>
			</div>
			<span>
				<s:errors path="name"></s:errors>
			</span>
		</div>
		
		<div>
			<p>
				<s:label path="price">Price: </s:label>
			</p>
			<div>
				<s:input path="price"/>
			</div>
			<span>
				<s:errors path="price"></s:errors>
			</span>
		</div>
		
		<div>
			<button type="submit">Save</button>
		</div>
	
	</s:form>
	
</body>
</html>