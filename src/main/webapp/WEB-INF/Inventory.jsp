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

<form action="AddInventory" method="post"> 
<font size=3 color=<%out.println(request.getAttribute("dfontcolor")); %>></font>
<%if (request.getAttribute("dmessage")!=null) {
out.println(request.getAttribute("dmessage"));
}%>
<br><br>
<table>
<tr>
<td>
Tool Name:
</td>
<td>
 <input type="text" name="name" required> <br>
</td>

<td>
License Type:
</td>
<td>
<input list="licensetype" name="licensetype" required>
<datalist id="licensetype">
<option value="Open source">
<option value="Freeware">
<option value="Shareware">
<option value="Public domain">
<option value="Commercial">
</datalist>
</td>
</tr>
<tr>
<td>
Purpose:
</td>
<td>
<input list="purpose" name="purpose" required>
<datalist id="purpose">
<option value="Requirements">
<option value="Project Management">
<option value="Static Analyzer">
<option value="Unit Testing">
<option value="Functional Testing">
<option value="Development">
<option value="Deployment">
<option value="Orchestration">
<option value="Web Server">
<option value="Version Control">
<option value="Other">
</datalist>
</td>
<td>
License Count:
</td>
<td>
 <input type="text" name="licensecount"> <br>
</td>
</tr>
<tr>
<td>
<input type="submit" name="btnAddInventory" value="Add Inventory">
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


<a href="DisplayInventory.jsp">
   <input type="button" value="Display Inventory" />
</a> <br><br> 
-->
If you have not already registered:

<a href="Register.jsp?username=${username}" >
   <input type="button" value="Register" />
</a>
</form> 
<form action="DisplayInventory" method="post"> 
<input type="submit" name="btnAddInventory" value="Display Inventory">
</form>
<%if (request.getAttribute("dsearchresults")!=null) {
	out.println("Search results is not null");
out.println("<table><tr><td>Tool Name</td><td>License Type</td><td>Purpose</td><td>License Count</td></tr>");
	
out.println("<tr><td>" + request.getAttribute("dname") + "</td><td>" + request.getAttribute("dlicensetype") +
		"</td><td>" + request.getAttribute("dpurpose") + "</td><td>" + request.getAttribute("dlicensecount") +
		"</td><td></tr></table>");

}%>


</body>
</html>