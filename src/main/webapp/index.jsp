<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DevOps Bookstore Login</title>
</head>
<body>
<h1>Welcome to DevOps BookStore</h1>
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
</td>
<td>
<input type="password" name="password" required>
</td>
</tr>

<tr>
<td>
<input type="submit" name="btnlogin" value="Login">
</td>
<td>
<a href="ResetPassword.jsp">
   <input type="button" value="ResetPassword" />
</a> 
</td>
</tr>
</table>
<!-- UserName: <input type="text" name="email" required>
Please enter your registered email as username<br>  
User Password: <input type="password" name="password" required><br>

<input type="submit" value="Sign In">


<a href="ResetPassword.jsp">
   <input type="button" value="ResetPassword" />
</a> <br><br> 
-->
If you have not already registered:

<a href="Register.jsp?username=${username}" >
   <input type="button" value="Register" />
</a>
</form> 




</body>
</html>