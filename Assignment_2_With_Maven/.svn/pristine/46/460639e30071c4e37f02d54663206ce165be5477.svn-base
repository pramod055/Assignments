package com.nagarro.flightsearchengine.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nagarro.flightsearchengine.utility.exception;
import com.nagarro.flightsearchengine.watcher.LocalizationForStoringConstantMessage;
/**
 * @author pramodyadav
 *class use for check date format
 */
public class ValidateDate {

	public static void ValidateFlightDate(String flightDate) throws exception 
	{
		
		/**
		 * 0? means 0 is optional 0[1-9] means consider all 01 02 03 4 05 06 07
		 * 08 09 [12][0-9] means 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
		 * 26 27 28 29 3[01] means 30 31 \\d means any digit
		 * match with pattern
		 */
		Pattern d = Pattern.compile(LocalizationForStoringConstantMessage.getConstantString("DATE_PATTERN"));
		String[] dateMonthYear = flightDate.split(LocalizationForStoringConstantMessage.getConstantString("STRING_SPLIT"));
		/**
		 * match with defined pattern
		 * if match then go for next checking
		 */
		Matcher m1 = d.matcher(flightDate);
		if (!m1.matches())
			throw new exception(LocalizationForStoringConstantMessage.getConstantString("WrongDateFormat"));
		/**
		 * validation for leap year
		 */
		if (Integer.parseInt(dateMonthYear[2]) % 4 == 0 || (Integer.parseInt(dateMonthYear[2]) % 100 == 0)
				&& (Integer.parseInt(dateMonthYear[2]) % 400 == 0)) 
		{
			if (Integer.parseInt(dateMonthYear[1]) == 2)
				if (Integer.parseInt(dateMonthYear[0]) > 29) 
					throw new exception(LocalizationForStoringConstantMessage.getConstantString("WRONG_DATE_FOR_LEAP_YEAR_FEB"));
			if (Integer.parseInt(dateMonthYear[1]) == 02 || Integer.parseInt(dateMonthYear[1]) == 04
					|| Integer.parseInt(dateMonthYear[1]) == 06 || Integer.parseInt(dateMonthYear[1]) == 9
					|| Integer.parseInt(dateMonthYear[1]) == 11) 
			{
				if (Integer.parseInt(dateMonthYear[0]) > 30) 
					throw new exception(LocalizationForStoringConstantMessage.getConstantString("WRONG_MONTH_DATE"));
			}
		}
		else
		{
			/**
			 * validation for non leap year
			 */
			if (Integer.parseInt(dateMonthYear[1]) == 2)
			{
				if (Integer.parseInt(dateMonthYear[0]) > 28)
				{
					throw new exception(LocalizationForStoringConstantMessage.getConstantString("WRONG_DATE_FOR_NON_LEAP_YEAR_FEB"));
				}
			}
			if (Integer.parseInt(dateMonthYear[1]) == 2 || Integer.parseInt(dateMonthYear[1]) == 4
					|| Integer.parseInt(dateMonthYear[1]) == 6 || Integer.parseInt(dateMonthYear[1]) == 9
					|| Integer.parseInt(dateMonthYear[1]) == 11)
			{
				if (Integer.parseInt(dateMonthYear[0]) > 30)
				{
					throw new exception(LocalizationForStoringConstantMessage.getConstantString("WRONG_MONTH_DATE"));
				}
			}
		}

	}

}







