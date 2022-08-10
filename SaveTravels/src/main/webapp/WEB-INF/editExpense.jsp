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
<title>Edit</title>
</head>
<body>
	<div id="editContainer">
		<h1>Edit <c:out value="${expense.type}"/></h1>
		<form:form action="/expenses/${expense.id}/update" method="post" modelAttribute="expense" class="form">
			<input type="hidden" name="_method" value="put"/>
			
			<form:label path="type">Expense Name: </form:label><br>
			<form:errors path="type" class="alert-danger"/>
			<form:input type="text" path="type" style="width:100%;"/>
			
			<form:label path="vendor">Vendor Name: </form:label><br>
			<form:errors path="vendor" class="alert-danger"/>
			<form:input type="text" path="vendor" style="width:100%;"/>
			
			<form:label path="amount">Amount: </form:label><br>
			<form:errors path="amount" class="alert-danger"/>
			<form:input type="text" path="amount" style="width:100%;"/>
			
			<form:label path="description">Description: </form:label><br>
			<form:errors path="description" class="alert-danger"/>
			<form:textarea path="description" style="width:100%; rows:20%;"/>
			
			<input type="submit" value="Update" class="btn btn-primary"/>
			
		</form:form>
	</div>
</body>
</html>