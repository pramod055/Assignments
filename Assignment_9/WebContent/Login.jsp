<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend
			style="font-size: 18px; font-weight: bold; color: maroon; font-family: Georgia, serif;">
			Login </legend>
		<s:form action="verify">
			<table border="0" cellpadding="3" cellspacing="0">
				<tr>
					<td align="right">
					<s:textfield label="Enter Username" key="manager.uname" />

				</tr>

				<tr>
					<td align="right">
					<s:password label="Enter Password" key="manager.password" />
					</td>
				</tr>
				
				<tr>
					<td align="right">
					<s:submit value="Login" align="center" />
					</td>
				</tr>
				

			</table>

			

		</s:form>
	</fieldset>
</body>
</html>

