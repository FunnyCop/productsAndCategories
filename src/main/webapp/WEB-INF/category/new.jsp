<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8" />
    <title>New Category</title>
    
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <!-- <script type = "text/js" src = "/js/script.js"></script> -->
    <link rel = "stylesheet" type = "text/css" href = "/css/index.css" />
    <link rel = "stylesheet" type = "text/css" href = "/css/category/new.css" />

</head>

<body>

	<h3>New Category</h3>

	<form:form action = "/category/new/submit" method = "post" modelAttribute = "category" class = "form-group">

		<form:label path = "name">Name</form:label>
		<form:errors path = "name" style = "color: red;" />
		<form:input path = "name" class = "form-control" required = "true" />
		
		<form:button class = "btn btn-primary">Submit</form:button>

	</form:form>

	<h4><a href = "/product/new">New Product</a></h4>
	<h4><a href = "/category/all">All Categories</a></h4>
	<h4><a href = "/product/all">All Products</a></h4>

</body>

</html>