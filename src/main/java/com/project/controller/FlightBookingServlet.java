package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.BookingServiceImpl;
import com.project.model.Flight;
import com.project.model.Passenger;
import com.project.model.PassengerDetailsBean;
import com.project.model.TravelDetailsBean;

/**
 * Servlet implementation class FlightBookingServlet
 */
public class FlightBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightBookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String flightNo = (String)request.getAttribute("Flight_Number_Booked");
		String airlines = "";
		if("ARI".equals(flightNo.substring(0,3)))
		{
			airlines = "Air-Asia";
		}
		else if("SPC".equals(flightNo.substring(0,3)))
		{
			airlines = "Spice-Jet";
		}
		else if("IND".equals(flightNo.substring(0,3)))
		{
			airlines = "Indigo";
		}
		BookingServiceImpl objBookingServiceImpl = new BookingServiceImpl();
		Flight flight = objBookingServiceImpl.getFlightObject(flightNo);
		
		HttpSession session = request.getSession(false);
		TravelDetailsBean objTravelDetailsBean = (TravelDetailsBean)session.getAttribute("Travel_Details");
		//System.out.println("No of persons:- "+objTravelDetailsBean.getNoOfPerson());
		int personsCount = Integer.parseInt(objTravelDetailsBean.getNoOfPerson());
		int costs = 5000*personsCount;
		String cost = String.valueOf(costs);
		request.setAttribute("COST",cost);
		Passenger passenger = (Passenger)request.getAttribute("passengerDetailsBean");
		
		PassengerDetailsBean objPassengerDetail = new PassengerDetailsBean();
		//objPassengerDetail.setBookingId(bookingId);
		objPassengerDetail.setFlight(flight);
		objPassengerDetail.setPassenger(passenger);
		objPassengerDetail.setTravelDetails(objTravelDetailsBean);
		objPassengerDetail.setAirlines(airlines);
		
		request.setAttribute("Passeneger_Details",objPassengerDetail);
		
		RequestDispatcher rd = request.getRequestDispatcher("/populateBookingDetails.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
