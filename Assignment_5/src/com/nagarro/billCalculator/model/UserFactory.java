package com.nagarro.billCalculator.model;

public class UserFactory
{
	public static Consumer getUser(String userType)
	{
		if(userType == null)
			return null;
		else if(userType.equalsIgnoreCase("employee"))
		{
			return new UserEmployee();
		}
		else if(userType.equalsIgnoreCase("affiliate"))
		{
			return new UserAffiliate();
		}
		else if(userType.equalsIgnoreCase("customer"))
		{
			return new UserCustomer();
		}
		return null;
	}
}
