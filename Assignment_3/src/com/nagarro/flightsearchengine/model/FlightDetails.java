package com.nagarro.flightsearchengine.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * @author pramodyadav
 *class contain all type of flight attribute
 *also contain Getter and Setter method
 *and override equals() and hashCode() methods for checking duplication of object
 */


@Entity
@Table(name="FlightsTable")

public class FlightDetails 
{
	@Id
	@GeneratedValue
	@Column(name= "id")
	private long id;

	@Column(name= "Flight_NO")
	private String Flight_NO;
	
	@Column(name= "Dep_Loc") 
	private String Dep_Loc;
	
	@Column(name= "Arr_Loc")
	private String Arr_Loc;
	
	@Column(name= "Valid_Till")
	private Date Valid_Till;
	
	@Column(name= "Flight_Time")
	private String Flight_Time;
	
	@Column(name= "Flight_Dur")
	private Double Flight_Dur;
	
	@Column(name= "Fare")
	private Double Fare;
	
	@Column(name= "Seat_Availability")
	private String Seat_Availability;
	
	@Column(name= "Flight_Class")
	private String Flight_Class;
	
	@ManyToOne
	@JoinColumn(name="airline_id")
	private AirlineDetails airline;
   
	
	
	
	public AirlineDetails getAirline() {
		return airline;
	}
	public void setAirline(AirlineDetails airline) {
		this.airline = airline;
	}
	public String getFlight_NO() {
		return Flight_NO;
	}
	public void setFlight_NO(String flight_NO) {
		Flight_NO = flight_NO;
	}
	public String getDep_Loc() {
		return Dep_Loc;
	}
	public void setDep_Loc(String dep_Loc) {
		Dep_Loc = dep_Loc;
	}
	public String getArr_Loc() {
		return Arr_Loc;
	}
	public void setArr_Loc(String arr_Loc) {
		Arr_Loc = arr_Loc;
	}
	public Date getValid_Till() {
		return Valid_Till;
	}
	public void setValid_Till(Date valid_Till) {
		Valid_Till = valid_Till;
	}
	public String getFlight_Time() {
		return Flight_Time;
	}
	public void setFlight_Time(String flight_Time) {
		Flight_Time = flight_Time;
	}
	public Double getFlight_Dur() {
		return Flight_Dur;
	}
	public void setFlight_Dur(Double flight_Dur) {
		Flight_Dur = flight_Dur;
	}
	public Double getFare() {
		return Fare;
	}
	public void setFare(Double fare) {
		Fare = fare;
	}
	public String getSeat_Availability() {
		return Seat_Availability;
	}
	public void setSeat_Availability(String seat_Availability) {
		Seat_Availability = seat_Availability;
	}
	public String getFlight_Class() {
		return Flight_Class;
	}
	public void setFlight_Class(String flight_Class) {
		Flight_Class = flight_Class;
	}
     
/* public FlightDetails() {
	
}*/


	public boolean equals(Object o)
	{
		FlightDetails ob = (FlightDetails)o;
		return ob.getFlight_NO().equals(this.getFlight_NO()) ;

	}

	@Override
	
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Arr_Loc == null) ? 0 : Arr_Loc.hashCode());
		result = prime * result + ((Dep_Loc == null) ? 0 : Dep_Loc.hashCode());
		result = prime * result + ((Fare == null) ? 0 : Fare.hashCode());
		result = prime * result + ((Flight_Class == null) ? 0 : Flight_Class.hashCode());
		result = prime * result + ((Flight_Dur == null) ? 0 : Flight_Dur.hashCode());
		result = prime * result + ((Flight_NO == null) ? 0 : Flight_NO.hashCode());
		result = prime * result + ((Flight_Time == null) ? 0 : Flight_Time.hashCode());
		result = prime * result + ((Valid_Till == null) ? 0 : Valid_Till.hashCode());
		return result;
	}
}
