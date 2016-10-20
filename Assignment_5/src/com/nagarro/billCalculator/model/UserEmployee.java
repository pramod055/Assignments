package com.nagarro.billCalculator.model;

public class UserEmployee extends Consumer
{
	private static final float USER_DISCOUNT = 30;
	
	@Override
	public double calculateUserDiscount(double total)
	{
		double discount;

		if ( isGrocery == false )
		{
			discount = total * USER_DISCOUNT / 100;
		}
		else
		{
			discount = 0;
		}
		return discount;
	}
}