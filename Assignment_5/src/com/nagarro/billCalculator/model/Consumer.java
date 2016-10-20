package com.nagarro.billCalculator.model;

import java.util.Date;

public abstract class Consumer
{
	Date	dateOFJoining;
	double	total;
	boolean	isGrocery;

	/**
	 * @return the dateOFJoining
	 */
	public Date getDateOFJoining()
	{
		return dateOFJoining;
	}

	/**
	 * @param dateOFJoining the dateOFJoining to set
	 */
	public void setDateOFJoining(Date dateOFJoining)
	{
		this.dateOFJoining = dateOFJoining;
	}

	/**
	 * @return the total
	 */
	public double getTotal()
	{
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total)
	{
		this.total = total;
	}

	/**
	 * @return the isGrocery
	 */
	public boolean isGrocery()
	{
		return isGrocery;
	}

	/**
	 * @param isGrocery the isGrocery to set
	 */
	public void setGrocery(boolean isGrocery)
	{
		this.isGrocery = isGrocery;
	}

	public int memberSince()
	{
		Date currentDate = new Date();
		int diffInDays = (int) ((currentDate.getTime() - dateOFJoining.getTime()) / (1000 * 60 * 60 * 24));
		return diffInDays;
	}

	public double getFinalPrice()
	{
		double userDiscount, billDiscount;
		userDiscount= calculateUserDiscount(total);
		billDiscount= calculateBillDiscount(total-userDiscount);
		double finalPrice= total - userDiscount - billDiscount;
		return finalPrice;
	}

	/**
	 * @param total
	 * @return
	 */
	abstract public double calculateUserDiscount(double total);

	public double calculateBillDiscount(double total)
	{
		int discount= ((int)total/100) * 5;
		return discount;
	}
}
