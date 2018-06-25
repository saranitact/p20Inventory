<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
<table height="700"> <tr><td background="" bgcolor="yellowgreen" width="400">
<a href="Inventory.jsp" name="AddInventory" value="AddInventory">
<h3 fontcolor="black">Add Inventory</h3>
</a>
<br><br>
<a href="DisplayInventory.jsp" name="DisplayInventory" value="DisplayInventory">
<h3 fontcolor="black">Display Inventory</h3>
</a>
<br><br>
<a href="ResetPassword.jsp" name="ResetPassword">
<h3 fontcolor="black">Reset Password</h3>
</a> 
<br><br>
<a href="index.jsp" name="Logout">
<h3 fontcolor="black">Logout</h3>
</a>
</td>
<td width="3000" align="center">
<font size=6 color=orange>
WELCOME TO DEVOPS TOOLS INVENTORY
</font></td>

</tr>

</table>

<font size=3 color=<%out.println(request.getAttribute("dfontcolor")); %>></font>
<%if (request.getAttribute("dmessage")!=null) {
out.println(request.getAttribute("dmessage"));
}%>


</body>
</html>