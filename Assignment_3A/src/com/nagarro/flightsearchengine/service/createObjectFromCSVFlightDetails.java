package com.nagarro.flightsearchengine.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nagarro.flightsearchengine.model.FlightDetails;
/**
 * @author pramodyadav
 *this class is use to create a FlightDetails Class object after setting attribute
 */
public class createObjectFromCSVFlightDetails {
	
	public FlightDetails getFlightDetailsObjectFromCSVLine(String CSVCurrentLine)
	{
		/**
		 * @return a FlightDetails class object
		 */
        FlightDetails ob=null;
		try
		{
			String str[]=CSVCurrentLine.split("\\|");//str.split("[|]");
			
			ob=new FlightDetails();
			ob.setFlight_NO(str[0]);
			ob.setDep_Loc(str[1]);
			ob.setArr_Loc(str[2]);
			/**
			 * change date into string format to Actual Date Format
			 */
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date_ValidTill = df.parse(str[3]);
			ob.setValid_Till(date_ValidTill);
			ob.setFlight_Time(str[4]);
			ob.setFlight_Dur(Double.parseDouble(str[5]));
			ob.setFare(Double.parseDouble(str[6]));
			ob.setSeat_Availability(str[7]);
			ob.setFlight_Class(str[8]);
			return ob;
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		return ob;
	}
}

