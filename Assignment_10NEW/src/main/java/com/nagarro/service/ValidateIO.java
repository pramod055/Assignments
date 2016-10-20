package com.nagarro.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nagarro.model.UserInput;
import com.nagarro.util.LocalizationForStoringConstantMessage;
import com.nagarro.util.exception;

/**
 * @author pramodyadav
 * class use for validate input based on some constraints 
 *
 */
public class ValidateIO {

	public static void validate(UserInput userinput) throws exception
	{
		/**
		 * validate dep_location and arr_location
		 */
		if(userinput.getArr_Loc().length()!=3 )
		{
			throw new exception(LocalizationForStoringConstantMessage.getConstantString("invalidDepLocation"));
		}
		if(userinput.getDep_Loc().length()!=3)
		{   
			throw new exception(LocalizationForStoringConstantMessage.getConstantString("invalidArrLocation"));

		}
		/**
		 * validate passenger travel date 
		 * ValidateFlightDate()-method check date format
		 */
		try {
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			Date currentDate = new Date();
			Date flightDate=df.parse(userinput.getFlight_Date());
			/*try {
				ValidateDate.ValidateFlightDate(userinput.getFlight_Date());
			} catch (exception e) 
			{
				throw new exception(e.getMessage());

			}*/
			if (currentDate.compareTo(flightDate)>0)
			{
				System.out.println("n\n\n.............................................................\n\n\n");
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
			int enterclass= Integer.parseInt(userinput.getFlight_Class());
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
			int outputpreference= Integer.parseInt(userinput.getOutput_Preference());
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

