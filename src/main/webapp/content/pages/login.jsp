<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SandBox Login</title>
</head>
<body>
	<s:actionerror/>
	<s:form action="login" method="post">
		<s:textfield label="User Name" name="securityOne" /><br>
		<s:textfield label="Password" name="securityTwo" /><br>
		<s:submit value="Submit"/>
	</s:form>
</body>
</html>