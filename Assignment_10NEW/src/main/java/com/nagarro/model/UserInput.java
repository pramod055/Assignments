package com.nagarro.model;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class UserInput {
	private String Dep_Loc;
	private String Arr_Loc;
	private String Flight_Class;
	
	
	//@Future(message = "Date Passed !!! Please Enter Correct Date")
	//@NotNull
	//@DateTimeFormat(pattern= "dd-MM-yyyy")
	//@Future(message = "The value \"${formatter.format('%1$tY-%1$tm-%1$td', validatedValue)}\" is not in future!")
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
