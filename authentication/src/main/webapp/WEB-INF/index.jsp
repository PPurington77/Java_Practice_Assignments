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
<title>Login & Registration</title>
</head>
<body>
	<div id="container">
		<h1>Welcome!</h1>
		<p>Join our growing community.</p>
		<div id="loginAndReg" class="d-flex justify-content-between">
			<div id="reg">
				<h2>Register</h2>
				
				<form:form action="/register" method="post" modelAttribute="newUser">
				
					<form:label path="userName">User Name</form:label>
					<form:errors path="userName" class="alert-danger"/>
					<form:input type="text" path="userName"/>
					
					<form:label path="email">Email</form:label>
					<form:errors path="email" class="alert-danger"/>
					<form:input type="email" path="email"/>
					
					<form:label path="password">Password</form:label>
					<form:errors path="password" class="alert-danger"/>
					<form:input type="password" path="password"/>
					
					<form:label path="confirm">Confirm PW</form:label>
					<form:errors path="confirm" class="alert-danger"/>
					<form:input type="password" path="confirm"/>
				
					<input type="submit" value="submit" class="btn btn-primary" />
				</form:form>
			</div>
			<div id="login">
			<h2>Login</h2>
			
			<form:form action="/login" method="post" modelAttribute="newLogin">
			
				<form:label path="email">Email</form:label>
				<form:errors path="email" class="alert-danger"/>
				<form:input type="email" path="email"/>
				
				<form:label path="password">Password</form:label>
				<form:errors path="password" class="alert-danger"/>
				<form:input type="text" path="password"/>
				
				<input type="submit" value="submit" class="btn btn-primary" />
			
			</form:form>
			
			</div>
		</div>
	</div>
</body>
</html>