<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Service Desk</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script src="js/login.js"></script>
</head>
<body>
<table width="100%" bgcolor="pink" border="0" cellpadding="0" cellspacing="0">
<tr><td align="right" valign="top" height="20px">
<div id="loginDiv" style="display:block">
<a href="loginPage"><font color="blue"><b>Login</b></font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br>
<font color="red"><b>&nbsp;</b></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>
<div id="logoutDiv" style="display:none">
Welcome&nbsp;<b>${username}</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br><br>
<a href="logout"><font color="blue"><b>Logout</b></font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>
</td></tr>
<tr><td align="center" height="20px"><h1>Service Desk</h1></td></tr>
</table>

<table width="100%" bgcolor="grey" height="20px" border="0">
<tr><td width="15%">&nbsp;</td></tr>
</table>
<br><br>
<div id="imageDiv"></div>
<table align="center">
<tr><td><img src="resources/images/index.jpg" width="800px" height="400px"/></td></tr>
</table>
</div>
</body>
</html>