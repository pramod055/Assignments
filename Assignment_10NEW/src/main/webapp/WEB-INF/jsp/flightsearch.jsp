<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<!-- <link rel="stylesheet" type="text/css" href="src/main/webapp/WEB-INF/css/flightsearchCSS.css" /> -->
<style >
#table1
{
	border-collapse: collapse;
	width : 50%;
	text-align:center; 
}

#th,#td,#table1
{
	border: 1px solid black;
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
<h3></h3>
<body>
<center>
	<h3>Search Flight !!!</h3>
	<form:form commandName="flightsearch" method="post">
		<table>
			<tr>
			<tr>
				<td>Departure Location:</td>
				<td><form:select path="Dep_Loc">
						<form:option value="Select" label="Select" />
						<form:option value="DEL" label="DELHI" />
						<form:option value="MUB" label="MUMBAI" />
						<form:option value="BGR" label="BANGALORE" />
					</form:select></td>
				<td><form:errors path="Dep_Loc" cssClass="error" /></td>
			</tr>
			<td>Arrival Location:</td>
			<td><form:select path="Arr_Loc">
					<form:option value="Select" label="Select" />
					<form:option value="DEL" label="DELHI" />
					<form:option value="MUB" label="MUMBAI" />
					<form:option value="BGR" label="BANGALORE" />
				</form:select></td>
			<td><form:errors path="Arr_Loc" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Flight Date:</td>
				<td><form:input type="Date" path="Flight_Date" /></td>
				<td><form:errors path="Flight_Date" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Flight Class:</td>
				<td><form:radiobutton path="Flight_Class" value="1" />
					Business <form:radiobutton path="Flight_Class" value="2" />
					Economy</td>
				<td><form:errors path="Flight_Class" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Output Preference:</td>
				<td><form:radiobutton path="Output_Preference" value="Fare" />
					Sorted By Fare <form:radiobutton path="Output_Preference"
						value="Fare and Duration" /> Sorted By Both Fare And Flight
					Duration</td>
				<td><form:errors path="Output_Preference" cssClass="error" /></td>
			</tr>


			<tr>
				<td colspan="3"><input type="submit" value="Search"></td>
				
			</tr>
		</table>
	</form:form>
	<a id='logoutBtn' href="logout.html">LogOut</a>
	</center>
	<hr />
	
	<h1>${headerMsg}</h1>
	<table  id ="table1" width="70%">
		<tr>
			<th id="th">Flight No.</th>
			<th id="th">Dep LOC</th>
			<th id="th">Arr LOC</th>
			<th id="th">Valid Till</th>
			<th id="th">Duration</th>
			<th id="th">Time</th>
			<th id="th">Fare</th>
		</tr>
		<c:forEach items="${resultList}" var="flight" varStatus="status">
			<tr>
				<td id="td">${flight.flight_NO}</td>
				<td id="td">${flight.dep_Loc}</td>
				<td id="td">${flight.arr_Loc}</td>
				<td id="td">${flight.valid_Till}</td>
				<td id="td">${flight.flight_Dur}</td>
				<td id="td">${flight.flight_Time}</td>
				<td id="td">${flight.fare}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<input type="button" value="Back" onclick="javascript:history.back()" />
</body>
</html>