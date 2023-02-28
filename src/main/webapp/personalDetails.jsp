<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.project.model.TravelDetailsBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
	<% String flightNumber = request.getParameter("flightNumber");
	request.setAttribute("Flight_Number_Booked", flightNumber);
	%>
<center>
	<br><br>
	<form action="" method="post">
		Aadhar No: <input type="text" name="uid"/><br><br>
		First Name: <input type="text" name="firstName"/>&nbsp;&nbsp;
		Last Name: <input type="text" name = "lastName"/><br><br>
		Age: <input type="text" name ="age"/><br><br>
		Gender: <input type="radio" name="gender" value="male"/>Male
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="gender" value="female"/>Female<br><br>
		Contact Number: <input type="text" name ="contactNo"/><br><br>
		Country: <select name="country">
					<option value="select"> Select Country </option>
					<option value="INDIA"> INDIA </option>
					<option value="USA"> USA </option>
					<option value="UK"> UK </option>
					<option value="FRANCE"> FRANCE </option>
					<option value="RUSSIA"> RUSSIA </option>
					<option VALUE="Others"> Others </option>
				</select><br><br>
		Address: <input type="text" name="address"/><br><br>
		Email Id: <input type="text" name= "email"/><br><br>
		<input type="submit" name="passengerDetails" value="SUBMIT"/>                                                                                                                                                         
	</form>
</center>
	<% if(request.getParameter("passengerDetails")!=null)
	{%>
		<jsp:useBean id="passengerDetailsBean" class="com.project.model.Passenger" scope="request"></jsp:useBean>
		<jsp:setProperty property="*" name="passengerDetailsBean"/>
		<jsp:forward page="/FlightBookingServlet"></jsp:forward>
	<%}%>
</body>
</html>