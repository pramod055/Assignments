<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
	.error{
    	color: red;
	}
</style>
</head>
<body>
	<a id='logoutBtn' href="./logout">LogOut</a>
	<h1>${headerMsg}</h1>

	<form:form action="flightSearch" method="get" commandName="flightSearchForm">
		Dep Loc: <form:input path="depLoc"/>
		<springForm:errors path="depLoc" cssClass="error" />
		<br>
		<br> Arr LOC: <form:input path="arrLoc"/>
		<springForm:errors path="arrLoc" cssClass="error" />
		<br>
		<br> Flight Date: <form:input path="flightDate"/>
		<springForm:errors path="flightDate" cssClass="error" />
		<br>
		<br> Flight Class: <form:select path="flightClass">
								<form:option value="E" label="Economy Class" />
								<form:option value="B" label="Business Class" />
							 </form:select>
		<br>
		<br> <input type="submit" value="Submit">
	</form:form>
</body>
</html>