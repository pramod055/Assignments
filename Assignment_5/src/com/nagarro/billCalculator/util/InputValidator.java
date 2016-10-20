package com.nagarro.billCalculator.util;

import java.text.ParseException;
import java.util.Date;

import com.nagarro.billCalculator.constants.Constants;
import com.nagarro.billCalculator.exceptions.InputException;

public class InputValidator
{
	public static void billValidator(String bill)
	{
		int billInt = Integer.parseInt(bill);
		if ( billInt == 0 )
		{
			throw new InputException("Invalid Bill Amount: Bill can not be zero");
		}
		else if ( billInt < 0 )
		{
			throw new InputException("Invalid Bill Amount: Bill can not be negative");
		}
	}
	
	public static void dateOfJoiningValidator(String checkDate)
	{
		Date tempDt = null;
		Date currentDate= new Date();
		try
		{
			tempDt = Constants.DATE_FT.parse(checkDate);
		}
		catch (ParseException e)
		{
			throw new InputException("Invalid Date: Invalid format");
		}

		if ( tempDt.compareTo(currentDate) > 0 )
		{
			throw new InputException("Invalid Date: Enter date before "+ currentDate);
		}
	}
}