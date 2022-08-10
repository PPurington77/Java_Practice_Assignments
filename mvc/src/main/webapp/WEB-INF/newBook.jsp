<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure...this is for your style sheet -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Create a book</title>
</head>
<body>
	<form:form action="/createBook" method="post" modelAttribute="book">
		<form:label path="title">Title:</form:label>
		<form:errors path="title" class="alert-danger"/>
		<form:input type="text" path="title"/>
		
		<form:label path="description">Description:</form:label>
		<form:errors path="description" class="alert-danger"/>
		<form:input type="text" path="description"/>
		
		<form:label path="language">Language:</form:label>
		<form:errors path="language" class="alert-danger"/>
		<form:input type="text" path="language"/>
		
		<form:label path="numberOfPages">Number of Pages:</form:label>
		<form:errors path="numberOfPages" class="alert-danger"/>
		<form:input type="text" path="numberOfPages" />
		
		<input type="submit" value="Create"/>
	</form:form>
</body>
</html>