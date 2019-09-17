<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DevOps Inventory</title>
</head>
<body>
<table background="" bgcolor="yellowgreen" height="50" width="1200"> <tr><td>
<h1>Display Tools Inventory</h1>
</td></tr></table>

<br><br>


<form action="DisplayInventory" method="post"> 

<font size=3 color=<%out.println(request.getAttribute("dfontcolor")); %>></font>
<%if (request.getAttribute("dmessage")!=null) {
out.println(request.getAttribute("dmessage"));
}%>
<br><br>
<table>
<tr>
<td>
Tool Name:
<br><br>
</td>
<td>
 <input type="text" name="name" required> <br>
 <br><br>
</td>
</tr>
<tr>
<td>
<input type="submit" name="btnDisplayInventory" value="Display Inventory">
</td>
&nbsp;&nbsp;&nbsp;&nbsp;
<td>
<a href="Home.jsp">
   <input type="button" name="btnHome" value="Home" />
</a> 
</td>
</tr>
</table>
<br><br>

<table border="true" bordercolor="black" align="center" value="result">
<tr><td colspan="4"> <h2 align="center">Search Results</h2></td></tr>
<tr><td><b>Tool Name</b></td><td><b>License Type</b></td><td><b>Purpose</b></td><td><b>License Count</b></td></tr>
<%if (request.getAttribute("dsearchresults")!=null) {
	//out.println("Search results is not null");
out.println("<tr><td value='tdname'>");
out.println(request.getAttribute("dname"));
out.println("</td><td>");
out.println(request.getAttribute("dlicensetype"));
out.println("</td><td>");
out.println(request.getAttribute("dpurpose"));
out.println("</td><td>");
out.println(request.getAttribute("dlicensecount"));
out.println("</td></tr>");
}
else
{
	out.println("<tr><td value='tdname'>");
	out.println("</td><td>");
	out.println("</td><td>");
	out.println("</td><td>");
	out.println("</td></tr>");
}
%>

</table>

</form>
</body>
</html>