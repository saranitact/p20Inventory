<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Inventory</title>
</head>
<body>
<table background="" bgcolor="yellowgreen" height="50" width="1200"> <tr><td>
<h1>Add Inventory</h1>
</td></tr></table>
<form action="AddInventory" method="post"> 
<font size=3 color=<%out.println(request.getAttribute("dfontcolor")); %>></font>
<%if (request.getAttribute("dmessage")!=null) {
out.println(request.getAttribute("dmessage"));
}%>
<br><br>
<table>
<tr>
<td><b>
Tool Name:</b>
</td>
<td>
 <input type="text" name="name" required> <br>
</td>

<td>
&nbsp; &nbsp; <b>
License Type:</b>
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
<td><b>
Purpose:</b>
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
&nbsp; &nbsp; <b>
License Count:</b>
</td>
<td>
 <input type="text" name="licensecount"> <br>
</td>
</tr>
<tr><td><br><br></td></tr>
<tr>
<td>
<input type="submit" name="btnAddInventory" value="Add Inventory">
</td>
<td>

<a href="Home.jsp">
   <input type="button" name="btnHome" value="Home">
</a> 
</td>
</tr>
</table>

 <br><br> 

</form> 



</body>
</html>