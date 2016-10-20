<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.nagarro.model.ImageModel"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<center>
	<h3>Edit Image</h3>
	<hr>
	<c:forEach items="${requestScope.imageModel}" var="ImageList">
	 	<form action="UpdateFileServlet" method="post" enctype="multipart/form-data">  
		<input type="hidden" value="${ImageList.id}" name="imageid"/><br>
		fileName:<input type="text" value="${ImageList.fileName}"/><br>
		filePath:<input type="file" name="editFile"/><br><hr>
		<input type="submit" name="submit" value="submit" />
		<input type="submit" name="submit" value="cancel" />
	 	</form>    
	</c:forEach>
	</center>
</body>
</html>