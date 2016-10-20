<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.nagarro.model.ImageModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Image Management</title>
<link rel="stylesheet" type="text/css" href="ImageManagement.css" />
</head>
<body>
	<form action="ImageManagementServlet" method="post" enctype="multipart/form-data">
		<!-- 	<input type="file" name="image" />
		<input type="submit" value="Upload" /> -->
		<h2>Image Management Utility</h2>
		<hr>
		
			<p>Please select an image file to upload(max size 1 MB)</p>
			<div id="upper">
				<input type="file" name="file_Uploaded" placeholder="select file" /><br>
				<br> <input type="submit" name="submit" value="submit" />
				<input type="submit" name="submit" value="cancel" />
			</div>
			<hr>
		</form>	
			<div id="lower">
				<h3>Uploaded Images</h3>
				<table id="TABLE">
					<tr>
						<!-- <th>Serial No.</th> -->
						<th>SerialId</th>
						<th>Name</th>
						<th>Preview</th>
						<th>Size</th>
						<th colspan="2">actions</th>
					</tr>
					<tr>
						<c:forEach items="${requestScope.imageList}" var="ImageList">
							<tr>
								<td>${ImageList.id}</td>
								<td>${ImageList.fileName}</td>
								<td><img src="${ImageList.filePath}" style="width: 100px; height: 100px"></td>
								<td>${ImageList.fileSize}</td>
								<td>
								<form action="DeleteServlet" method="post">
								<input type="hidden" name="id" value="${ImageList.id}" />
								<input type="submit" value="delete"/>
								</form>
								</td>
								<td>
								<form action="EditServlet" method="post">
								<input type="hidden" name="id" value="${ImageList.id}"/>
								<input type="submit" value="edit"/>
								<!-- <img src="actionImages/edit.png" width="30px"/> -->
								</form>
								</td>
							</tr>
						</c:forEach>
					</tr>
				</table>
			</div>
</body>
</html>
