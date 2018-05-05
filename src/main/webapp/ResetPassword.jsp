<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Devops Bookstore ResetPassword</title>
</head>
<body>
<h1>Welcome to Devops BookStore</h1>
<br><br>
<form action="ResetPassword" method="post"> 
<table>
<tr>
<td>
Enter Registered Email:
</td>
<td>
<input type="email" name="email" required>
</td>
</tr>

<tr>
<td>
Enter New Password:
</td>
<td>
<input type="password" name="newpassword">
</td>
</tr>

<tr>
<td>
Re-enter New Password:
</td>
<td>
<input type="password" name="re-newpassword">
</td>
</tr>

<tr>
<td>
<input type="submit" value="Submit"> <br>
</td>

</tr>
</table>

<!-- Enter Registered Email : <input type="email" name="email" required><br> <br>
Enter New Password : <input type="password" name="newpassword"><br> <br>
Re-enter New Password     : <input type="password" name="re-newpassword"><br> <br>

<input type="submit" value="Submit"> <br>-->
</form> 

</body>
</html>