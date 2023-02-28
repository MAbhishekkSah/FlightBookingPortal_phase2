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

import com.project.model.PassengerDetailsBean;

/**
 * Servlet implementation class PaymentServlet
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AtomicLong seqNo = new AtomicLong(2023000001L);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = seqNo.getAndIncrement();
		String bookingId = String.valueOf(id);
		HttpSession session = request.getSession(false);
		PassengerDetailsBean objPassengerDetailsBean = (PassengerDetailsBean)session.getAttribute("Paasenger_Details");
		objPassengerDetailsBean.setBookingId(bookingId);
		request.setAttribute("PassengerDetails",objPassengerDetailsBean);
		RequestDispatcher rd = request.getRequestDispatcher("showBookingDetails.jsp");
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
