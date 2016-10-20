<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body >
<div >
<hr>
<center>
<form action="LoginServlet" method="post">
<h3>Login</h3> 
  Login Id: <input type="text" name="loginId" placeholder="enter Login Id"/><br><br>
  Password: <input type="password" name="password" placeholder="enter password"/><br>
  <hr>
  <input type="submit" name="Login" value="Login"/><br>
  Not Registered?<a href="Register.jsp">Register Here</a>

</form>
</center>
</div>
</body> 
</html>