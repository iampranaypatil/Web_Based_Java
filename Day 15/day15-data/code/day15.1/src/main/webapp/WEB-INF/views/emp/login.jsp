<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Login Form</title>
</head>
<body>
	<h4 style="color: red">${requestScope.message}</h4>
	<form method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter Emp Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Emp Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Emp Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>