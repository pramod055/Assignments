<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<style>
.error {
	color: #ff0000;
}
.errorblock {
	color: #ffEEEE;
	background-color: #ff0000;
	border: 3px solid black;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
	<form:form commandName="RegisterModel" method="post">
		<table>
			<tr>
				<td>User Name:</td>
				<td><form:input path="userName"/></td>
				<td><form:errors path="userName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>User Id:</td>
				<td><form:input path="userId"/></td>
				<td><form:errors path="userId" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Email Address:</td>
				<td><form:input type="email" path="emailAddress" /></td>
				<td><form:errors path="emailAddress" cssClass="error"/></td> 
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input type="password" path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
	<h3>${ErrorMessage}</h3>
	Already Registered?
	<a href="login.html">Login Here</a>
</body>
</html>



























<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body> 
	<form:form commandName="register" method="post">
		<table>
			<tr>
				<td>User Name:</td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>User Id:</td>
				<td><form:input path="userId" /></td>
			</tr>
			<tr>
				<td>Email Address:</td>
				<td><form:input type="email" path="emailAddress" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input type="password" path="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" ></td>
			</tr>
		</table>
	</form:form>
</body>
</html> --%>