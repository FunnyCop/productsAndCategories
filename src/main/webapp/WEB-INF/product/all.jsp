<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8" />
    <title>All Products</title>
    
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <!-- <script type = "text/js" src = "/js/script.js"></script> -->
    <link rel = "stylesheet" type = "text/css" href = "/css/index.css" />
    <link rel = "stylesheet" type = "text/css" href = "/css/category/all.css" />

</head>

<body>

	<h3>All Products</h3>

	<table class = "table" id = "language-table">
		<thead class = "thead-dark">
			<tr>
				<th scope = "col">ID</th>
				<th scope = "col">Name</th>
				<th scope = "col">Products</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items = "${products}" var = "product">
				<tr>
					<th scope = "row"><c:out value="${ product.id }" /></th>
					<td><c:out value="${ product.name }" /></td>
					<td><a href = "/product/id/${ product.id }"><c:out value="${ product.categories.size() }" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h4><a href = "/category/new">New Category</a></h4>
	<h4><a href = "/product/new">New Product</a></h4>
	<h4><a href = "/category/all">All Categories</a></h4>

</body>

</html>