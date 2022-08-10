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
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure...this is for your style sheet -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>View</title>
</head>
<body>
	<div id="viewContainer">
		<div id="header">
			<h1>Expense Details</h1>
			<a href="/expenses">Go Back</a>
		</div>
		<p>Expense Name: <c:out value="${expense.type}"/></p>
		<p>Expense Name: <c:out value="${expense.vendor}"/></p>
		<p>Expense Name: <c:out value="${expense.description}"/></p>
		<p>Expense Name: <c:out value="${expense.amount}"/></p>
	</div>
</body>
</html>