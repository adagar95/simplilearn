<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="com.utility.*" %>
   <%@ page import="com.entity.*" %>
   <%@ page import="java.util.*" %>
   <%@ page import="org.hibernate.*" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Details</title>
<style>
table,td,th,h1{
align-content:center;
border:2px solid gray;
padding: 5px;
margin-left: auto;
margin-right: auto;
}
th{
background-color: #4287f5;
color:white;
}
</style>
</head>
<body style="align-content: center;">
<h1  Style="color:blue; text-align: center">List of Flight Details</h1>
 <table>
<%
Session ses=HiberanteUtlity.getSession();
List<Flights> fdetails=ses.createQuery("from Flights").list();
List<Airlines> bdetails=ses.createQuery("from Airlines").list();
out.print("<tr>");
out.print(" <th>Source</th>");
out.print(" <th>Destination</th>");
out.print("<th>Airline</th>");
out.print("<th>Ticket Price</th>");
out.print(" </tr>");
for(Airlines b:bdetails){

	
	for(Flights f:fdetails){

		out.print("<tr>");
		out.print("<td>"+f.getSource()+"</td>");
		out.print("<td>"+f.getDestination()+"</td>");
		out.print("<td>"+b.getAirline()+"</td>");
		out.print("<td>"+b.getPrice()+"</td>");
		out.print("</tr>");
	}
	

}



%>
</table>
</body>
</html>