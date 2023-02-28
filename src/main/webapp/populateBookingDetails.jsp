<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.project.model.PassengerDetailsBean" %>
 <%@page import="com.project.model.Flight" %>
 <%@page import="com.project.model.Passenger" %>
 <%@page import="com.project.model.TravelDetailsBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<% 
	PassengerDetailsBean objBean = (PassengerDetailsBean)request.getAttribute("Passeneger_Details");
	session.setAttribute("Paasenger_Details",objBean);
	String cost = (String)request.getAttribute("COST");
	String airlines = objBean.getAirlines();
	Flight flight = objBean.getFlight();
	Passenger passenger = objBean.getPassenger();
	TravelDetailsBean travelDetails = objBean.getTravelDetails();
	String noOfPersons = travelDetails.getNoOfPerson();
	String name = passenger.getFirstName()+ " " +passenger.getLastName();
	%>
	<br>
	<center>
		<p>Welcome, <%=name %>.</p><br>
		<p>Number of Persons: - <%=noOfPersons %>.</p><br>
		<p><b><%=airlines %> is Happy To Serve You.</b></p>
		<p>Here is your Flight Details: -</p><br>
	</center>
	<table border="1" width="500" align="center">
		<tr bgcolor="00FF7F">
			<th>Flight No</th>
			<th>Flight Name</th>
			<th>Source</th>
			<th>Destination</th>
		</tr>
		<tr>
			<td><%=flight.getFlightNo() %></td>
			<td><%=flight.getFlightName() %></td>
			<td><%=flight.getSourceCity() %></td>
			<td><%=flight.getDestinationCity() %></td>
		</tr>
	</table>
	<center>
		<p>Amount to Pay: - &nbsp;<%=cost %></p><br>
		<form action="payment.jsp" method="post">
			<input type="checkbox"/>I accept the Terms and Conditions*.<br><br>
			<button name="payment">Confirm and Pay</button>
		</form>
	</center>
</body>
</html>