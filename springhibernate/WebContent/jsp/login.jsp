<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>		
	</head>
	<body>
		<font color="red">${message}</font>
		<form:form method="post" action="login" modelAttribute="loginBean">

			<form:label path="username">Enter your user-name</form:label>
			<form:input path="username" />
			<form:errors path="username"/><br>
			<form:label path="password">Please enter your password</form:label>
			<form:password path="password" />
			<form:errors path="password"/><br>
			<form:label path="age">Please enter your age</form:label>
			<form:input path="age" />
			<form:errors path="age"/><br>
			<input type="submit" value="Submit" />			
		</form:form>
	</body>
</html>