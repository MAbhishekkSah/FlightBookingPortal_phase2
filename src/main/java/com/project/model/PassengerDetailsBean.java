package com.project.model;

public class PassengerDetailsBean {

	private String bookingId;
	private String airlines;
	private Flight flight;
	private Passenger passenger;
	private TravelDetailsBean travelDetails;
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public TravelDetailsBean getTravelDetails() {
		return travelDetails;
	}
	public void setTravelDetails(TravelDetailsBean travelDetails) {
		this.travelDetails = travelDetails;
	}
	
	@Override
	public String toString() {
		return "PassengerDetailsBean [bookingId=" + bookingId + ", airlines=" + airlines + ", flight=" + flight
				+ ", passenger=" + passenger + ", travelDetails=" + travelDetails + "]";
	}
	public PassengerDetailsBean(String bookingId, String airlines, Flight flight, Passenger passenger,
			TravelDetailsBean travelDetails) {
		super();
		this.bookingId = bookingId;
		this.airlines = airlines;
		this.flight = flight;
		this.passenger = passenger;
		this.travelDetails = travelDetails;
	}
	public PassengerDetailsBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
