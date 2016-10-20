<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<hr>
	<center>
		<form action="RegisterServlet" method="post">
			<h3>Register Here</h3>
			<table>
				<tr>
					<th>Login Id</th>
					<td><input type="text" name="loginId"
						placeholder="Enter Login Id"></td>
				</tr>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName"
						placeholder="First Name"></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastName" placeholder="Last Name"></td>
				</tr>
				<tr>
					<th>Email Address</th>
					<td><input type="email" name="emailAddress"
						placeholder="Email Address"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password"
						placeholder="Enter Password"></td>
				</tr>
				<tr>
					<th>Confirm Password</th>
					<td><input type="password" name="confirmPassword"
						placeholder="Confirm Password"></td>
				</tr>
			</table>
			<hr>
			<input type="submit" name="submitButton" value="Register"><br>
			Already registered!! <a href="Login.jsp">Login Here</a>
		</form>
	</center>
</body>
</html>

