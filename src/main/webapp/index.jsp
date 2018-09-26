<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DevOps Inventory Login</title>
</head>
<body>
<!-- <table background="" bgcolor="yellowgreen" height="50" width="1200"> <tr><td>  -->
<table background="" bgcolor="bluegreen" height="50" width="1200"> <tr><td>
<h1>Sign In</h1>
</td></tr></table>
<br><br>

<form action="ProcessLogin" method="post"> 
<font size=3 color=<%out.println(request.getAttribute("dfontcolor")); %>></font>
<%if (request.getAttribute("dmessage")!=null) {
out.println(request.getAttribute("dmessage"));
}%>
<br><br>
<table>
<tr>
<td>
UserName:
</td>
<td>
 <input type="text" name="email" required> Please enter your registered email as username<br>
</td>
</tr>

<tr>
<td>
User Password:
<br><br>
</td>
<td>
<input type="password" name="password" required>
<br><br>
</td>
</tr>

<tr>
<td>
<input type="submit" name="btnlogin" value="Login">
</td>

</tr>
</table>
<br><br>
If you have not already registered:

<a href="Register.jsp?username=${username}" >
   <input type="button" value="Register" />
</a>
</form> 




</body>
</html>