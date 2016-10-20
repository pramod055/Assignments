<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<!-- 	Language : <a href="?language=en">English</a> | <a href="?language=es">Spanish</a> --> 
	<form:form commandName="login" method="post">
		<spring:message code="goal.text" />
		
		<table>
			<tr>
				<td>User Name</td>
				<td><form:input  id ="user" type ="text" path="userId" /></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><form:input id="password" type="password" path="password" /></td>
			</tr>

			<tr>
				<td><input type="submit" ></td>
			</tr>
		</table>
	</form:form>
</body>
</html>