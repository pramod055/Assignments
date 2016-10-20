package com.nagarro.billCalculator.model;

public class UserCustomer extends Consumer
{
	private static final float USER_DISCOUNT = 5;
	private static final long threshholdTimeInDays = 2*365;  //2 Years

	@Override
	public double calculateUserDiscount(double total)
	{
		double discount;
		System.out.println(memberSince());
		if(isGrocery == false)
		{
			if(memberSince() > threshholdTimeInDays)
			{
				discount = total * USER_DISCOUNT / 100;
			}
			else
			{
				discount=0;
			}
		}
		else
		{
			discount = 0;
		}
		return discount;
	}
}
