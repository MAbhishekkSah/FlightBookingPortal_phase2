package com.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id; 
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Flights")
public class Flight {
	
	@Id
	private String flightNo;
	private String flightName;
	@OneToOne(cascade = CascadeType.ALL)
	private Airlines nameOfAirline;
	private int noOfSeats;
	private String sourceCity;
	private String destinationCity;
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public Airlines getNameOfAirline() {
		return nameOfAirline;
	}
	public void setNameOfAirline(Airlines nameOfAirline) {
		this.nameOfAirline = nameOfAirline;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getSourceCity() {
		return sourceCity;
	}
	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flight(String flightNo, String flightName, Airlines nameOfAirline, int noOfSeats, String sourceCity,
			String destinationCity) {
		super();
		this.flightNo = flightNo;
		this.flightName = flightName;
		this.nameOfAirline = nameOfAirline;
		this.noOfSeats = noOfSeats;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
	}
	public Flight(String flightNo,String flightName,int noOfSeats,String sourceCity,String destinationCity)
	{
		this.flightNo = flightNo;
		this.flightName = flightName;
		this.noOfSeats = noOfSeats;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
	}
	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", flightName=" + flightName + ", nameOfAirline=" + nameOfAirline
				+ ", noOfSeats=" + noOfSeats + ", sourceCity=" + sourceCity + ", destinationCity=" + destinationCity
				+ "]";
	}
	
	

}
