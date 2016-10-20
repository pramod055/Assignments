package com.nagarro.flightsearchengine.utility;
import java.util.List;

import com.nagarro.flightsearchengine.domain.FlightDetails;
import com.nagarro.flightsearchengine.watcher.LocalizationForStoringConstantMessage;
/**
 * @author pramodyadav
 *class used to display flight details
 */
public class DisplaySearchedFlights 
{	
	public void printSearchedFlight(List<FlightDetails> resultantArraylist,String inputArray[]) throws exception 
	{
		    	 
		    	 System.out.printf("\n\n\t\t%-10s|%-13s|%-13s|%-13s|%-15s|%-9s|%-15s|%-9s|%-9s|\n", "Flight No","Airline","Dep Location","Arr Location",
						 "DateOfTravel","Fare","Flight Duration","Flight_Time","Class");
		    	  if(resultantArraylist.size()>0)
				 for(int i=0;i<resultantArraylist.size(); i++)
				 {
					 /**
					  * find class name
					  */
					 String airlineName=resultantArraylist.get(i).getFlight_NO().substring(0, 2);
					 if(airlineName.equals("AI"))
						 airlineName="Air India";
					 else if(airlineName.equals("6E"))
						 airlineName="IndiGo   ";
					 else if(airlineName.equals("9W"))
						 airlineName="Jet Air  ";
					 else
					     airlineName="NULL";
					 System.out.printf("\n\t\t| %-8s|%-13s|    %-9s|    %-9s|%-15s|%-9s|    %-11s|  %-9s|   %-6s|\n", resultantArraylist.get(i).getFlight_NO(),airlineName, resultantArraylist.get(i).getDep_Loc(),
							  resultantArraylist.get(i).getArr_Loc(),inputArray[2], resultantArraylist.get(i).getFare(), resultantArraylist.get(i).getFlight_Dur(),
							  resultantArraylist.get(i).getFlight_Time(), resultantArraylist.get(i).getFlight_Class()); 
				 }
			else
				System.out.print(LocalizationForStoringConstantMessage.getConstantString("negativeMsg"));
		}
	}
