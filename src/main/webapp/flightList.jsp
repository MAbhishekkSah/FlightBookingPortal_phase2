<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.List" %>   
 <%@page import="com.project.model.Flight" %>
 <%@page import="com.project.model.TravelDetailsBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<center>
	<%TravelDetailsBean obj = (TravelDetailsBean)request.getAttribute("Travel_Details");
	session.setAttribute("Travel_Details",obj);
	%>
	<br><br>
	<form action="personalDetails.jsp">
		<b>Enter Flight No.  </b><input type="text" name="flightNumber"/>
		<input type="submit" value="Book Now"/>
	</form>
</center>
	<br><br>
	<table border="1" width="500" align="center">
		<tr bgcolor="00FF7F">
			<th>Flight No</th>
			<th>Flight Name</th>
			<th>Seats available</th>
			<th>Source</th>
			<th>Destination</th>
		</tr>
		<% 
		List<Flight> flightList = (List<Flight>)request.getAttribute("FLIGHT_LIST");
		for(int i = 0; i<flightList.size(); i++)
		{%>
			<tr>
				<td><%=flightList.get(i).getFlightNo() %></td>
				<td><%=flightList.get(i).getFlightName() %></td>
				<td><%=flightList.get(i).getNoOfSeats() %></td>
				<td><%=flightList.get(i).getSourceCity() %></td>
				<td><%=flightList.get(i).getDestinationCity() %></td>
			</tr>
		<%}%>
	</table>
</body>
</html>