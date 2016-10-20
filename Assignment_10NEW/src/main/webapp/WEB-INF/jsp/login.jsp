<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<style>
p
{
 color:red;
}
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
<center>
	<p>${userName}<br> </p>	
	<!-- Language : <a href="?language=en">English</a> | <a href="?language=es">Spanish</a> --> 
	<form:form commandName="LoginModel" method="post">
		<table>
			<tr>
				<td><spring:message code="goal.text" /></td>
				<td><form:input path="userId"/></td>
				<td><form:errors path="userId" cssClass="error"/></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><form:input type="password" path="password" /></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form:form>
	<h3>${ErrorMessage}</h3>
	Not Registered?<a href="register.html">Register Here</a> <br>
	<a id='logoutBtn' href="logout.html">LogOut</a>
	</center>
</body>
</html>



























<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="springForm"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Search</title>
<link rel="stylesheet" type="text/css" href="global.css">
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>${headerMsg}</h1>
	<form:form id="formID" action="checkLogin.html" method="get"
		commandName="flightSearchUser">
		Username: <form:input id="userId" path="userId"  />
		<springForm:errors path="userId" cssClass="error" />
		<br>
		<br> Password: <form:input path="password"  />
		<springForm:errors path="password" cssClass="error" />
		<br>
		<br>
		<input type="submit" value="Submit">
	</form:form>
	<h3>${errorMsg}</h3>
	<a id='registerBtn' href="./loadRegister">Register</a>
	<a id='forgetPasswordBtn' href="./forgetPassword">Forget Password</a>

	
</body>
</html> --%>