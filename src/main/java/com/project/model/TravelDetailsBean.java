package com.project.model;

public class TravelDetailsBean {
	public String sourceCity;
	public String destinationCity;
	public String date;
	public String noOfPerson;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNoOfPerson() {
		return noOfPerson;
	}
	public void setNoOfPerson(String noOfPerson) {
		this.noOfPerson = noOfPerson;
	}
	public TravelDetailsBean(String sourceCity, String destinationCity, String date, String noOfPerson) {
		super();
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.date = date;
		this.noOfPerson = noOfPerson;
	}
	
	public TravelDetailsBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TravelDetailsBean [sourceCity=" + sourceCity + ", destinationCity=" + destinationCity + ", date=" + date
				+ ", noOfPerson=" + noOfPerson + "]";
	}

}
