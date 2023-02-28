package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.model.Flight;
import com.project.model.TravelDetailsBean;

public class BookingServiceImpl {
	
	//@SuppressWarnings("unused")
	public List<Flight> getFlightDetails(TravelDetailsBean objTravelDetailsBean)
	{
		List<Flight> flightsList = new ArrayList();
		String sourceCity = objTravelDetailsBean.getSourceCity()!=null?objTravelDetailsBean.getSourceCity():null;
		String destinationCity = objTravelDetailsBean.getDestinationCity()!=null?objTravelDetailsBean.getDestinationCity():null;
		String noOfPerson = objTravelDetailsBean.getNoOfPerson();
	/*	Date date;
		try {
			date = GetDateFromString(objTravelDetailsBean.getDate());
		} catch (ParseException e) {
			date = null;
			System.out.println("Exception in fetching date" + e.toString());
		}	*/
		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;
		try
		{
			conn = BookingServiceImpl.getDBConnection();
			if(conn!=null)
			{
				stmnt = conn.createStatement();
				String query = "select f.* from phase2_project.flights as f where f.sourceCity = '" + sourceCity + 
						"' and f.destinationCity = '" + destinationCity + "'";//and bd.flight_no = f.flightNo";// and bd.travel_date = '" + date + "'";
				rs = stmnt.executeQuery(query);
				while(rs.next())
				{
					String flightNo = rs.getString(1);
					String flightName = rs.getString(3);
					int noOfSeats = rs.getInt(4);
					String source = rs.getString(5);
					String destination = rs.getString(2);
					Flight flight = new Flight(flightNo, flightName, noOfSeats, source, destination);
					flightsList.add(flight);
				}
			}
			for(Flight flight : flightsList)
			{
				System.out.println(flight);
			}

		}
		catch(Exception ex)
		{
			System.out.println("Exception inside getFlightDetails method" + ex.toString());
		}
		finally
		{
			try {
				if(rs!=null)
				{
					rs.close();
				}
				if(stmnt!=null)
				{
					stmnt.close();
				}
				if(conn!=null)
				{
					conn.close();
				}
			}
			catch(Exception e)
			{
				System.out.println("Connection close exception" + e.toString());
			}
		}
		
		return flightsList;
	}
	
	public Flight getFlightObject(String flightNumber)
	{
		Flight flight = new Flight();
		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;
		String flightNo="",destinationCity="",flightName="",sourceCity="";
		int noOfSeats=0;
		try
		{
			conn = BookingServiceImpl.getDBConnection();
			if(conn!=null)
			{
				stmnt = conn.createStatement();
				String query = "SELECT * FROM phase2_project.flights as f where f.flightNo = '"+ flightNumber + "'";
				rs = stmnt.executeQuery(query);
				while(rs.next())
				{
					flightNo = rs.getString(1);
					destinationCity = rs.getString(2);
					flightName = rs.getString(3);
					noOfSeats = rs.getInt(4);
					sourceCity = rs.getString(5);
				}
				flight.setFlightNo(flightNo);
				flight.setFlightName(flightName);
				flight.setDestinationCity(destinationCity);
				flight.setNoOfSeats(noOfSeats);
				flight.setSourceCity(sourceCity);
				
			}
		}catch(Exception e)
		{
			System.out.println("Exception inside getFlightObject method" + e.toString());
		}
		finally
		{
			try {
				if(rs!=null)
				{
					rs.close();
				}
				if(stmnt!=null)
				{
					stmnt.close();
				}
				if(conn!=null)
				{
					conn.close();
				}
			}
			catch(Exception e)
			{
				System.out.println("Connection close exception" + e.toString());
			}
		}
		return flight;
	}
	
	public Date GetDateFromString(String dateStr) throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date date = format.parse(dateStr);
		return date;
	}
	
	public static Connection getDBConnection()
	{
		Connection conn = null;
		try
		{
			if(conn == null)
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase2_project","root","Abhi@1234");
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in creating DataBase Connection");
		}
		return conn;
	}


}
