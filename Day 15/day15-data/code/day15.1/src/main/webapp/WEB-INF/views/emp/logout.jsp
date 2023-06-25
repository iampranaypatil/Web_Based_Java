<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Hello , ${requestScope.details.firstName}
		${requestScope.details.lastName}</h5>
	<h5>You have logged out and will be auto taken to the home page
		shortly....</h5>
</body>
</html>