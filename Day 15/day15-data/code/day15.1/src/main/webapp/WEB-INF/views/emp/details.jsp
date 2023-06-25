<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Validated emp details : ${sessionScope.emp_dtls}</h5>
	<h5>Emp Address : ${requestScope.adr_details}</h5>
	<h5>Message : ${requestScope.message}</h5>
	<h5>
		<spring:url var="url" value="/emp/logout"></spring:url>
		<a href="${url}">Log Out</a>
	</h5>
</body>
</html>