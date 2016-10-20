package com.nagarro.billCalculator.model;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

import com.nagarro.billCalculator.constants.Constants;
import com.nagarro.billCalculator.exceptions.InputException;

public class BillCalculator
{
	public static double calculate(HashMap<String, String> inputMap)
	{
		double billAmount = 0;
		Date dateOfJoining = null;
		boolean isGrocery = false;
		
		Consumer consumer=UserFactory.getUser(inputMap.get("userType"));
		
		billAmount =  Double.parseDouble( inputMap.get("billAmount") );
		try
		{
			dateOfJoining = Constants.DATE_FT.parse(inputMap.get("dateOfJoining"));
		}
		catch (ParseException e)
		{
			throw new InputException("Error : Cannot parse date of joining");
		}
		
		if(inputMap.get("isGrocery").equalsIgnoreCase("Y"))
		{
			isGrocery = true;
		}
		else if(inputMap.get("isGrocery").equalsIgnoreCase("N"))
		{
			isGrocery = false;
		}
		
		consumer.setTotal(billAmount);
		consumer.setGrocery(isGrocery);
		consumer.setDateOFJoining(dateOfJoining);
		
		return consumer.getFinalPrice();
	}
}
