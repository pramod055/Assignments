package com.nagarro.service;
import java.text.ParseException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
/*
 * @author pramodyadav
 * class use for searching  flight based on user input and return a resultset
 *
 */

import com.nagarro.model.FlightDetails;
import com.nagarro.model.UserInput;
import com.nagarro.util.exception;

public class SortFlightBasedOnUserPreference 
{
	@SuppressWarnings("unchecked")
	public static List<FlightDetails> sortFlights(Criteria criteria, UserInput userInputObject) throws ParseException, exception 
	{
		if(userInputObject.getOutput_Preference().equals("1"))
		{
			criteria.addOrder(Order.asc("fare"));
		}
		else
		{
			criteria.addOrder(Order.asc("fare")).addOrder(Order.asc("flight_Dur"));
		}
		List<FlightDetails> flightsList = criteria.list();
		return flightsList; 


	}
}

