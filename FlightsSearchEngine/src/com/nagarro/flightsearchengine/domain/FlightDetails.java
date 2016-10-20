package com.nagarro.flightsearchengine.domain;

import java.util.Date;
import java.util.Set;
import java.util.TreeMap;
/**
 * @author pramodyadav
 *class contain all type of flight attribute
 *also contain Getter and Setter method
 *and override equals() and hashCode() methods for checking duplication of object
 */
public class FlightDetails {
	
	private String Flight_NO;
	private String Dep_Loc;
	private String Arr_Loc;
	private Date Valid_Till;
	private String Flight_Time;
	private Double Flight_Dur;
	private Double Fare;
	private char Seat_Availability;
	private String Flight_Class;
	private TreeMap<String,Set<FlightDetails>> filesMap ;

	
	public TreeMap<String, Set<FlightDetails>> getFilesMap() {
		return filesMap;
	}
	public void setFilesMap(TreeMap<String, Set<FlightDetails>> filesMap) {
		this.filesMap = filesMap;
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
	public char getSeat_Availability() {
		return Seat_Availability;
	}
	public void setSeat_Availability(char seat_Availability) {
		Seat_Availability = seat_Availability;
	}
	public String getFlight_Class() {
		return Flight_Class;
	}
	public void setFlight_Class(String flight_Class) {
		Flight_Class = flight_Class;
	}
	

	public boolean equals(Object o)
	{
		FlightDetails ob = (FlightDetails)o;
		return ob.getFlight_NO().equals(this.getFlight_NO()) ;
		
	}
	
	@Override
	/**
	 * @return it return a hexadecimal value for a object
	 */
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
		result = prime * result + Seat_Availability;
		result = prime * result + ((Valid_Till == null) ? 0 : Valid_Till.hashCode());
		result = prime * result + ((filesMap == null) ? 0 : filesMap.hashCode());
				return result;
	}
}
