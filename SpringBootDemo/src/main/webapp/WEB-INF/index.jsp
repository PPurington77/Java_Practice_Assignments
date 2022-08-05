<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Names</title>
</head>
<body>
	<h2>Your Name is:</h2>
	<p>First Name: <c:out value="${firstName}"/></p>
	<p>Last Name: <c:out value="${lastName}"/></p>
	    <h1>Dojo Locations</h1>
    <c:forEach var="oneDojo" items="${dojosFromMyController}">
        <p><c:out value="${oneDojo}"></c:out></p>
    </c:forEach>
</body>
</html>