package com.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Airlines")
public class Airlines {
	
	@Id
	private int id;
	private String airlinesName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="Airlines_Flight_joinId")
	private List<Flight> flight;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAirlinesName() {
		return airlinesName;
	}
	public void setAirlinesName(String airlinesName) {
		this.airlinesName = airlinesName;
	}
	public List<Flight> getFlight() {
		return flight;
	}
	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}
	public Airlines(int id, String airlinesName, List<Flight> flight) {
		super();
		this.id = id;
		this.airlinesName = airlinesName;
		this.flight = flight;
	}
	public Airlines() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Airlines [id=" + id + ", airlinesName=" + airlinesName + ", flight=" + flight + "]";
	}
	
	
	

}
