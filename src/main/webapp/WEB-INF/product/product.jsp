<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8" />
    <title>${ product.name }</title>
    
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <!-- <script type = "text/js" src = "/js/script.js"></script> -->
    <link rel = "stylesheet" type = "text/css" href = "/css/index.css" />
    <link rel = "stylesheet" type = "text/css" href = "/css/category/category.css" />

</head>

<body>

	<h3>${ product.name }</h3>

	<div id = "container">

		<div id = "right">

			<h4>Categories:</h4>

			<ul>

				<c:forEach items = "${ categories }" var = "category">

					<li>${ category.name }</li>

				</c:forEach>

			</ul>

		</div>

		<div id = "left">

			<h4>Add Category</h4>

			<form:form action = "/product/category/add/id/${ product.id }" method = "post" modelAttribute = "category" class = "form-group">

				<form:select path = "id">

					<c:forEach items = "${ notCategories }" var = "category">

						<form:option value="${ category.id }" class = "form-control">${ category.name }</form:option>

					</c:forEach>

				</form:select>

				<form:button class = "btn btn-primary">Submit</form:button>

			</form:form>

		</div>

	</div>

	<h4><a href = "/category/new">New Category</a></h4>
	<h4><a href = "/product/new">New Product</a></h4>
	<h4><a href = "/category/all">All Categories</a></h4>
	<h4><a href = "/product/all">All Products</a></h4>

</body>

</html>