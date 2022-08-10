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
<title>Expenses</title>
</head>
<body>
	<div id="container">
		<h1>Save Travels</h1>
		<table class="table table-striped">
			<thead>
				<tr>
				<th scope="col" class="text-center">Expense</th>
				<th scope="col" class="text-center">Vendor</th>
				<th scope="col" class="text-center">Amount</th>
				<th scope="col" class="text-center">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
					<tr>
						<td class="text-center"><a href="/expenses/${expense.id}/view"><c:out value="${expense.type}"/></a></td>
						<td class="text-center"><c:out value="${expense.vendor}"/></td>
						<td class="text-center"><c:out value="${expense.amount}"/></td>
						<td class="text-center d-flex justify-content-around"><a href="/expenses/${expense.id}/edit" class=" btn btn-primary">Edit</a>
						<form action="/expenses/${expense.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="Delete" class=" btn btn-danger">
						</form>
						</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="expenseContainer">
		<h1>Add an expense:</h1>
		<form:form action="/expenses" method="post" modelAttribute="expense">
		
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
			
			<input type="submit" value="Create" class="btn btn-primary"/>
			
		</form:form>
	</div>
</body>
</html>