<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<center>
<br>
	<p><b>Enter your card details: - </b></p><br><br>
	<form action="PaymentServlet" method="post">
		CARD NO:- <input type="text" name="cardNo"/><br><br>
		CARD HOLDER NAME:- <input type="text" name="cardHolder"/><br><br>
		EXPIRY DATE:- <input type="text" name="expiryDate"/><br><br>
		CVV :- <input type="password" name ="cvv"/><br><br>
		<input type="submit" value="Pay">
	</form>
</center>
</body>
</html>