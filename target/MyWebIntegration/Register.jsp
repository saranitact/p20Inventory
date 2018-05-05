<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Devops Bookstore Register</title>
</head>
<body>
<h1>Welcome to Devops BookStore</h1>
<br><br>
<form action="ProcessRegistration" method="post"> 
<table>
<tr>
<td>
User Email:
</td>

<td>
 <input type="email" name="email" required> 
You will need to enter your email as your username for logging in. <br> <br>
</td>
</tr>

<tr>
<td>
User Password:
</td>

<td>
<input type="password" name="password" required><br> <br>
</td>
</tr>

<tr>
<td>
Name
</td>

<td>
<input type="text" name="username" required><br> <br>
</td>
</tr>

<tr>
<td>
Favorite Domain:
</td>

<td>
<input list="domains" name="domain" required>
<datalist id="domains">
  <option value="Continuous Integration">
  <option value="Continuous Deployment">
  <option value="Production Monitoring">
 </datalist>
</td>
</tr>

<tr>
<td><br>
<input type="submit" value="Submit">
</td>
</tr>
</table>


</form> 

</body>
</html>