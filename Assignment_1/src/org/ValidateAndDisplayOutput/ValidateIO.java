package org.ValidateAndDisplayOutput;

/**
 * this class is used to validate input
 * and throws exception
 * @author pramodyadav
 */
public class ValidateIO {

	/**
	 * validate item name
	 * @param name
	 * @return true -if valid name
	 * @return true -if  not valid name
	 */
	static public boolean validateItemName(String name)
	{
		if(name == null)
		{
			System.out.println("Please Enter Value of Name!!!");
			return false;
		}
		return true;
	}

	/**
	 * validate item price
	 * @param price
	 * @return true -if valid price
	 * @return true -if  not valid price
	 */
	static public boolean validateItemPrice (String price) throws NumberFormatException
	{
		if(price == null)
		{
			System.out.println("Please Enter Value of Price!!!");
			return false;
		}
		try {

			Double.parseDouble(price);
		} catch (Exception NumberFormatException) {
			System.out.println("Invalid Value!!!...Please Enter Integer/float Type Of Value.");
			return false;
		}
		return true;
	}
	/**
	 * validate item quantity
	 * @param quantity
	 * @return true -if valid quantity
	 * @return true -if  not valid quantity
	 */
	static public boolean validateItemQuantity (String quantity) throws NumberFormatException
	{
		if(quantity == null)
		{
			System.out.println("Please Enter Value of Quantity!!!");
			return false;
		}
		try {

			int noOfItem = Integer.parseInt(quantity);
			if(noOfItem<1)
			{
				System.out.println("Please Enter Correct Quantity(atleast one) !!!");
				return false;
			}
		} catch (Exception NumberFormatException) {
			System.out.println("Please Enter Correct Quantity(Integer) !!!");
			return false;
		} 

		return true;
	}
	/**
	 * validate item type
	 * @param type
	 * @return true -if valid type
	 * @return true -if  not valid type
	 */
	static public boolean validateItemType (String type) throws NumberFormatException
	{
		if(type == null)
		{
			System.out.println("Please Enter Type of Item!!!");
			return false;
		}
		if(type.equalsIgnoreCase("Raw") | type.equalsIgnoreCase("Imported") | 
				type.equalsIgnoreCase("Manufactured"))
			return true;
		else
		{
			System.out.println("Item doesn't exits !!!....Please Enter Correct Item Type.");
			return false;
		}
	}

}

