package com.nagarro.flightsearchengine.service;
import java.text.ParseException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

import com.nagarro.flightsearchengine.model.FlightDetails;
import com.nagarro.flightsearchengine.model.UserInputDetails;
import com.nagarro.flightsearchengine.utility.exception;
/**
 * @author pramodyadav
 * class use for searching  flight based on user input and return a resultset
 *
 */

public class SortFlightBasedOnUserPreference 
{
	@SuppressWarnings("unchecked")
	public static List<FlightDetails> sortFlights(Criteria criteria, UserInputDetails userInputObject) throws ParseException, exception 
	{
		if(userInputObject.getOutputPreference().equals("1"))
		{
			criteria.addOrder(Order.asc("Fare"));
		}
		else
		{
			criteria.addOrder(Order.asc("Fare")).addOrder(Order.asc("Flight_Dur"));
		}
		List<FlightDetails> flightsList = criteria.list();
		System.out.println("sizze :" + flightsList.size() );
		return flightsList; 


	}
}

