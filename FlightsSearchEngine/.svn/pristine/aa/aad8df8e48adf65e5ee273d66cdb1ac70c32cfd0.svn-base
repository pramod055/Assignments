package com.nagarro.flightsearchengine.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nagarro.flightsearchengine.utility.exception;
import com.nagarro.flightsearchengine.watcher.LocalizationForStoringConstantMessage;
/**
 * @author pramodyadav
 * class use for validate input based on some constraints 
 *
 */
public class ValidateIO {

	public static void validate(String input[]) throws exception
	{
		/**
		 * validate dep_location and arr_location
		 */
		if(input[0].length()!=3 )
		{
			throw new exception(LocalizationForStoringConstantMessage.getConstantString("invalidDepLocation"));
		}
		if(input[1].length()!=3)
		{   
			throw new exception(LocalizationForStoringConstantMessage.getConstantString("invalidArrLocation"));

		}
		/**
		 * validate passenger travel date 
		 * ValidateFlightDate()-method check date format
		 */
		try {
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date currentDate = new Date();
			Date flightDate=df.parse(input[2]);
			try {
				ValidateDate.ValidateFlightDate(input[2]);
			} catch (exception e) 
			{
				throw new exception(e.getMessage());

			}
			if (currentDate.compareTo(flightDate)>0)
			{
				throw new exception(LocalizationForStoringConstantMessage.getConstantString("invalidDate"));
			}
		}
		catch(ParseException e)
		{
			throw new exception(LocalizationForStoringConstantMessage.getConstantString("invalidDateFormat"));
		}
		/**
		 * validate flight Class
		 */
		try 
		{
			int enterclass= Integer.parseInt(input[3]);
			if(enterclass>2  | enterclass<1)
			{
				throw new exception(LocalizationForStoringConstantMessage.getConstantString("invalidClass"));
			}
		} 
		catch (Exception e)
		{
			throw new exception(LocalizationForStoringConstantMessage.getConstantString("invalidClass"));
		}
		/**
		 * validate OutputPerference(which type of sorting you want)
		 */
		try 
		{
			int outputpreference= Integer.parseInt(input[4]);
			if(outputpreference>2 | outputpreference<1)
			{
				throw new exception(LocalizationForStoringConstantMessage.getConstantString("invalidOutputpreference"));
			}
		} 
		catch (Exception e)
		{
			throw new exception(LocalizationForStoringConstantMessage.getConstantString("invalidOutputpreference"));
		}

	}

}

