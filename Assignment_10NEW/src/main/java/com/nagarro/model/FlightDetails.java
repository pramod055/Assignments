package com.nagarro.model;

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
	private String flight_NO;

	@Column(name= "Dep_Loc") 
	private String dep_Loc;

	@Column(name= "Arr_Loc")
	private String arr_Loc;

	@Column(name= "Valid_Till")
	private Date valid_Till;

	@Column(name= "Flight_Time")
	private String flight_Time;

	@Column(name= "Flight_Dur")
	private Double flight_Dur;

	@Column(name= "Fare")
	private Double fare;

	@Column(name= "Seat_Availability")
	private String seat_Availability;

	@Column(name= "Flight_Class")
	private String flight_Class;

	@ManyToOne
	@JoinColumn(name="airline_id")
	private AirlineDetails airline;

	

	public AirlineDetails getAirline() {
		return airline;
	}

	public String getDep_Loc() {
		return dep_Loc;
	}

	public String getArr_Loc() {
		return arr_Loc;
	}

	public Double getFare() {
		return fare;
	}

	public String getFlight_Class() {
		return flight_Class;
	}

	public Double getFlight_Dur() {
		return flight_Dur;
	}

	public String getFlight_NO() {
		return flight_NO;
	}

	public String getFlight_Time() {
		return flight_Time;
	}

	public long getId() {
		return id;
	}

	public String getSeat_Availability() {
		return seat_Availability;
	}

	public Date getValid_Till() {
		return valid_Till;
	}
	
	
	
	public void setAirline(AirlineDetails airline) {
		this.airline = airline;
	}
	
	public void setDep_Loc(String dep_Loc) {
		this.dep_Loc = dep_Loc;
	}
	
	public void setArr_Loc(String arr_Loc) {
		this.arr_Loc = arr_Loc;
	}
	
	public void setFare(Double fare) {
		this.fare = fare;
	}
	
	public void setFlight_Class(String flight_Class) {
		this.flight_Class = flight_Class;
	}
	
	public void setFlight_Dur(Double flight_Dur) {
		this.flight_Dur = flight_Dur;
	}
	
	public void setFlight_NO(String flight_NO) {
		this.flight_NO = flight_NO;
	}
	
	public void setFlight_Time(String flight_Time) {
		this.flight_Time = flight_Time;
	}
	
	public void setId(long id) {
		this.id = id;
	}
   
	public void setSeat_Availability(String seat_Availability) {
		this.seat_Availability = seat_Availability;
	}

	public void setValid_Till(Date valid_Till) {
		this.valid_Till = valid_Till;
	}

	@Override
	
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arr_Loc == null) ? 0 : arr_Loc.hashCode());
		result = prime * result + ((dep_Loc == null) ? 0 : dep_Loc.hashCode());
		result = prime * result + ((fare == null) ? 0 : fare.hashCode());
		result = prime * result + ((flight_Class == null) ? 0 : flight_Class.hashCode());
		result = prime * result + ((flight_Dur == null) ? 0 : flight_Dur.hashCode());
		result = prime * result + ((flight_NO == null) ? 0 : flight_NO.hashCode());
		result = prime * result + ((flight_Time == null) ? 0 : flight_Time.hashCode());
		result = prime * result + ((valid_Till == null) ? 0 : valid_Till.hashCode());
		return result;
	}
	public boolean equals(Object o)
	{
		FlightDetails ob = (FlightDetails)o;
		return ob.getFlight_NO().equals(this.getFlight_NO()) ;

	}
	
}
