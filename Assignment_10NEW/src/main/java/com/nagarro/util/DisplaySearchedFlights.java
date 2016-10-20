package com.nagarro.util;
import java.text.ParseException;
import java.util.List;

import com.nagarro.model.FlightDetails;
import com.nagarro.model.FlightModel;
/**
 * @author pramodyadav
 *class used to display flight details
 */
public class DisplaySearchedFlights 
{	
	public static void printSearchedFlight(List<FlightDetails> resultantSortedflightsList) throws exception, ParseException 
	{
		System.out.printf("\n\n\t\t%-10s|%-13s|%-13s|%-13s|%-15s|%-9s|%-15s|%-9s|%-9s|\n", "Flight No","Airline","Dep Location","Arr Location",
				"DateOfTravel","Fare","Flight Duration","Flight_Time","Class");
		if(resultantSortedflightsList.size()>0)
			for(int i=0;i<resultantSortedflightsList.size(); i++)
			{
				/**
				 * find class name
				 */
				String airlineName=resultantSortedflightsList.get(i).getFlight_NO().substring(0, 2);
				if(airlineName.equals("AI"))
					airlineName="Air India";
				else if(airlineName.equals("6E"))
					airlineName="IndiGo   ";
				else if(airlineName.equals("9W"))
					airlineName="Jet Air  ";
				else
					airlineName="NULL";


				System.out.printf("\n\t\t| %-8s|%-13s|    %-9s|    %-9s|%-15s|%-9s|    %-11s|  %-9s|   %-6s|\n", resultantSortedflightsList.get(i).getFlight_NO(),airlineName, resultantSortedflightsList.get(i).getDep_Loc(),
						resultantSortedflightsList.get(i).getArr_Loc(),resultantSortedflightsList.get(i).getFlight_Time(), resultantSortedflightsList.get(i).getFare(), resultantSortedflightsList.get(i).getFlight_Dur(),
						resultantSortedflightsList.get(i).getFlight_Time(), resultantSortedflightsList.get(i).getFlight_Class()); 
			}
		else
			System.out.print("Flight Not Found !!!");
		
	}
	
}
