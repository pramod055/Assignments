<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
	<form:form commandName="FlightModel">
		<table>
			<tr>
				<td>Departure Location:</td>
				<td><form:input path="departureLocation" /></td>
			</tr>
			<tr>
				<td>Arrival Location:</td>
				<td><form:input path="arrivalLocation" /></td>
			</tr>
			<tr>
				<td>Flight Date:</td>
				<td><form:input path="flightDate" /></td>
			</tr>
			<tr>
				<td>Flight Class:</td>
				<td><form:input path="flightClass" /></td>
			</tr>
			<tr>
				<td>Output Preference:</td>
				<td><form:input path="outputPreference" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>