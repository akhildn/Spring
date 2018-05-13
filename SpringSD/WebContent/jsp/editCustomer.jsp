<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightyellow">

<%@ include file="header.jsp" %>
<br><br><br><br><br><br>
<form:form method="post" action="updateCustomer" modelAttribute="customer">
<table width="30%" align="center" border="0">

<tr bgcolor="grey"><td colspan="2"><b>Edit Customer</b></td></tr>
<tr><td colspan="3">&nbsp;<form:hidden path="id" /></td></tr>
<tr><td><b><form:label path="username">Username</form:label></b></td>
<td><form:input path="username" /></td>
<td><form:errors path="username"/></td></tr>
<tr><td><b><form:label path="password">Password</form:label></b></td>
<td><form:password path="password" /></td>
<td><form:errors path="password"/></td></tr>
<tr><td><b><form:label path="email">Email</form:label></b></td>
<td><form:input path="email" /></td>
<td><form:errors path="email"/></td></tr>
<tr><td><b><form:label path="contactno">Contact No.</form:label></b></td>
<td><form:input path="contactno" /></td>
<td><form:errors path="contactno"/></td></tr>
<tr><td colspan="3">&nbsp;</td></tr>
<tr><td colspan="3" align="center"><input type="submit" value="Submit"/></td></tr>
</table>
</form:form>
</body>
</html>