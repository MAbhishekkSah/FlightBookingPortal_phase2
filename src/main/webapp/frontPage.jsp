<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Your Flight</title>
</head>
<body>
<center>
	<h1><b>Welcome To Flight Booking Portal</b></h1>
	<h3><b>Search Flights</b></h3><br>
</center>
	<form action="" method="post">
	<center>
	Source Location :  <input type="text" name="sourceCity"/><br><br>
	Destination Location :  <input type="text" name ="destinationCity"/><br><br>
	Date of Travel :  <input type="text" name="date"/><br><br>
	Number of Persons :  <input type="text" name="noOfPerson"/><br><br><br>
	<input type="submit" name="travelDetails" value="Search"/>
	</center>
	</form>
	
	<% if(request.getParameter("travelDetails")!=null)
	{%>
		<jsp:useBean id="travelDetailsBean" class="com.project.model.TravelDetailsBean" scope="request"></jsp:useBean>
		<jsp:setProperty property="*" name="travelDetailsBean"/>
		<jsp:forward page="/BookingServlet"></jsp:forward>
	<%}%>
</body>
</html>