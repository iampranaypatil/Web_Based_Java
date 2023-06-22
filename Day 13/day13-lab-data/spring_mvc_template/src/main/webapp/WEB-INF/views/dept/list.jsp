<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="background-color: lightgrey; margin: auto">
		<caption>All Departments</caption>
		<c:forEach var="dept" items="${requestScope.dept_list}">
			<tr>
				<td>${dept.id}</td>
				<td>${dept.departmentName}</td>
				<td>${dept.location}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>