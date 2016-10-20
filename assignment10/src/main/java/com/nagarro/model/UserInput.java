package com.nagarro.model;

import javax.persistence.Column;

public class UserInput {
	private String Dep_Loc;
	private String Arr_Loc;
	private String Flight_Class;
	private String Flight_Date;
	private String Output_Preference;
	
	public String getArr_Loc() {
		return Arr_Loc;
	}
	public String getDep_Loc() {
		return Dep_Loc;
	}
	public String getFlight_Class() {
		return Flight_Class;
	}
	public String getFlight_Date() {
		return Flight_Date;
	}
	public String getOutput_Preference() {
		return Output_Preference;
	}
	public void setArr_Loc(String arr_Loc) {
		Arr_Loc = arr_Loc;
	}
	public void setDep_Loc(String dep_Loc) {
		Dep_Loc = dep_Loc;
	}
	public void setFlight_Class(String flight_Class) {
		Flight_Class = flight_Class;
	}
	public void setFlight_Date(String flight_Date) {
		Flight_Date = flight_Date;
	}
	public void setOutput_Preference(String output_Preference) {
		Output_Preference = output_Preference;
	}
	
	

}
