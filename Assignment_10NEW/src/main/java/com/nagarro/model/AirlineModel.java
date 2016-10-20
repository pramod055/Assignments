package com.nagarro.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class AirlineModel 
{
	@Id
	@GeneratedValue
	@Column(name="airline_id")
	private Long airlineId;
	
	@Column(name="Airline_NAME")
	private String Airline_NAME;
	
	
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="airline_id")
	private Set<FlightModel> flights;
	
	
	public Long getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(Long airlineId) {
		this.airlineId = airlineId;
	}



	public String getAirlineName() {
		return Airline_NAME;
	}
	public void setAirlineName(String airlineName) {
		this.Airline_NAME = airlineName;
	}



	public Set<FlightModel> getFlights() {
		return flights;
	}
	public void setFlights(Set<FlightModel> flights) {
		this.flights = flights;
	}

}
