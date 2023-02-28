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
<%
PassengerDetailsBean objPassengerDetailsBean = (PassengerDetailsBean)request.getAttribute("PassengerDetails");
String airlines = objPassengerDetailsBean.getAirlines();
Flight flight = objPassengerDetailsBean.getFlight();
Passenger passenger = objPassengerDetailsBean.getPassenger();
String name = passenger.getFirstName()+" "+passenger.getLastName();
TravelDetailsBean objTravelDetails = objPassengerDetailsBean.getTravelDetails();
String noOfPerson = objTravelDetails.getNoOfPerson();
String bookingId = objPassengerDetailsBean.getBookingId();
%>
<center>
<br>
	<p><b>Your Booking is Confirmed! Your Booking Id is <%=bookingId %></b></p><br>
</center>
<table border="1" width="500" align="center">
		<tr bgcolor="FFFFE0">
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
	<br><br>
	<table border="1" width="500" align="center">
		<tr bgcolor="FFFFE0">
			<th>Passenger Name</th>
			<th>Age</th>
			<th>Email</th>
			<th>Gender</th>
			<th>No of Persons</th>
			<th>Date of Travel</th>
		</tr>
		<tr>
			<td><%=name %></td>
			<td><%=passenger.getAge() %></td>
			<td><%=passenger.getEmail() %></td>
			<td><%=passenger.getGender() %></td>
			<td><%=noOfPerson %></td>
			<td><%=objTravelDetails.getDate() %>
		</tr>
	</table>
	<br>
	<center>
	<p><b>ThankYou for choosing <%=airlines %>! We wish you a very happy Journey.</b></p><br>
	<form action="frontPage.jsp">
		<button name="search">Search flights</button>
	</form>
	</center>
</body>
</html>