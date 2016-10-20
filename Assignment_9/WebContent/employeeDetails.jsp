<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css"/>
</head>
<body>
    <fieldset>
	<legend>Employee Management</legend>
	<form action="upload" method="post" enctype="multipart/form-data">
		<label for="myFile">Upload your file</label> <br> 
		<input type="file" name="myFile" />
		<input type="submit" value="Upload" />
	</form>

	<s:form action="download" method="post"><br>
	<s:submit value="Download" />
	</s:form>
	

	<s:form action="logout" method="post"><br>
	<s:submit value="Logout" />
	</s:form>
	</fieldset>
	<table border="1" cellpadding="3" cellspacing="2" id="tblUsers">
		<tr>
			<th>Employee Code</th>
			<th>Employee Name</th>
			<th>Location</th>
			<th>Email</th>
			<th>Date of Birth</th>
			<th>Action</th>
		</tr>
		<s:iterator value="WPEmployees">
			<tr>
				<td><s:property value="empcode" /></td>
				<td><s:property value="empname" /></td>
				<td><s:property value="location" /></td>
				<td><s:property value="email" /></td>
				<td><s:date name="dateofbirth" format="dd-MM-yyyy" /></td>
				<td>
				<input type="button" class="edit-class" emp-id="<s:property value="employeeID"/>" value="Edit">

				</td>
			</tr>
		</s:iterator>
	</table>
	
	<div id="popup" class="hidden">
        <fieldset>
        	<legend>User Info</legend>
			<s:form action="update">
			   <s:hidden name="id" label="Employee Id" id="hdnUserId"/>
			   <s:textfield name="empcode"  label="Employee Code" id="empCode"/>
			   <s:textfield name="employee.empname" label="Name" id="name"/>
			   <s:textfield name="employee.location" label="Location" id="location"/>
			   <s:textfield name="employee.email" label="Email Address" id="email"/>
			   <s:textfield name="dateofbirth" format="dd-MM-yyyy" label="Date of birth" id="dob"/>
			   <%-- <s:textfield name="dateofbirth.dateofbirth" label="Date of birth" id="dateofbirth"/> --%>
			   <s:submit value="Save"/>
            </s:form>
            <button id="cancelEdit">Cancel</button>
        </fieldset>
    </div>
    <div id="overlay" class="hidden"></div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/JS/jquery-3.1.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/JS/xyz.js"></script>
</body>
</html>