package com.nagarro.flightsearchengine.service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.nagarro.flightsearchengine.domain.FlightDetails;
import com.nagarro.flightsearchengine.utility.exception;
/**
 * @author pramodyadav
 * class use for searching  flight based on user input and return a resultset
 *
 */

public class SearchFlightBasedOnUserInput 
{
	static Set<FlightDetails> resultantSet  = new HashSet<FlightDetails>();
	public Set<FlightDetails> searchFlights(TreeMap<String,Set<FlightDetails>> filesMap ,String inputArray[])throws exception
	{
		/**
		 *@return HashSet of found flights
		 */
		for(Map.Entry m:filesMap.entrySet())
		{  
			 
			Set<FlightDetails> file =  (Set<FlightDetails>)(m.getValue());
	    	searching(file,inputArray);			
		}
		return resultantSet;
	}

	public void searching(Set<FlightDetails> file, String[] inputArray) throws exception 
	{
		Iterator<FlightDetails> itr=file.iterator(); 
		 while(itr.hasNext())
		 {
			 FlightDetails ob =itr.next(); 
			try 
			{
				String Dep_loc= inputArray[0];
				String Arr_loc= inputArray[1];
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				Date Flight_date= df.parse(inputArray[2]);
				String Flight_class= inputArray[3];
				int ClassType = Integer.parseInt(Flight_class);
				/**
				 * check class type
				 */
				if(ClassType==1)
					Flight_class = "E";
				else if(ClassType==2)
					Flight_class = "B";
				else
					Flight_class = "EB"; 
			   
				if(ob.getDep_Loc().equalsIgnoreCase(Dep_loc) && 
                     	ob.getArr_Loc().equalsIgnoreCase(Arr_loc) &&
						ob.getValid_Till().compareTo(Flight_date)>=0 && (
								ob.getFlight_Class().equalsIgnoreCase(Flight_class) ||
								ob.getFlight_Class().equalsIgnoreCase("EB"))
						&& ob.getSeat_Availability()=='Y')
				{
					if(ob.getFlight_Class().equalsIgnoreCase("B") | ob.getFlight_Class().equalsIgnoreCase("EB"))
						ob.setFare(ob.getFare() + ob.getFare()*(.4));
					resultantSet.add(ob);
				}


			}
			catch (Exception e) 
			{
				throw new exception(e.getMessage());
			}


		}
	}
}
