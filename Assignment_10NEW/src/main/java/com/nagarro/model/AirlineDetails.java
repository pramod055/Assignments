package com.nagarro.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AirlineTable")

public class AirlineDetails 
{
	@Id
	@GeneratedValue
	@Column(name="airline_id")
	private Long airlineId;
	
	@Column(name="Airline_NAME")
	private String Airline_NAME;
	
	
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="airline_id")
	private Set<FlightDetails> flights;
	
	
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



	public Set<FlightDetails> getFlights() {
		return flights;
	}
	public void setFlights(Set<FlightDetails> flights) {
		this.flights = flights;
	}

}
