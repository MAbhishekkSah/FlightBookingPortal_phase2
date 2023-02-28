package com.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.BookingServiceImpl;
import com.project.model.Flight;
import com.project.model.TravelDetailsBean;

/**
 * Servlet implementation class BookingServlet
 */
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TravelDetailsBean objTravelDetailsBean = (TravelDetailsBean)request.getAttribute("travelDetailsBean");
		BookingServiceImpl objServiceImpl = new BookingServiceImpl();
		List<Flight> flightList = objServiceImpl.getFlightDetails(objTravelDetailsBean);
		request.setAttribute("FLIGHT_LIST",flightList);
		request.setAttribute("Travel_Details",objTravelDetailsBean);
		RequestDispatcher rd = request.getRequestDispatcher("/flightList.jsp");
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
