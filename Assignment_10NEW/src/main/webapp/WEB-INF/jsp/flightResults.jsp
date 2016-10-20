<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Spring 3 MVC Multiple Row Submit</title>
</head>
<body>
<a id='logoutBtn' href="./logout">LogOut</a>
<h1>${headerMsg}</h1>
<h2>Show Contacts</h2>
<table width="70%">
	<tr>
		<th>Flight No.</th>
		<th>Dep LOC</th>
		<th>Arr LOC</th>
		<th>Valid Till<th>
		<th>Duration</th>
		<th>Time</th>
		<th>Fare</th>
	</tr>
	<c:forEach items="${resultList}" var="flight" varStatus="status">
		<tr>
			<td>${flight.flight_NO}</td>
			<td>${flight.dep_Loc}</td>
			<td>${flight.arr_Loc}</td>
			<td>${flight.valid_Till}</td>
			<td>${flight.flight_Dur}</td>
			<td>${flight.flight_Time}</td>
			<td>${flight.fare}</td>
		</tr>
	</c:forEach>
</table>	
<br/>
<input type="button" value="Back" onclick="javascript:history.back()"/>
</body>
</html>