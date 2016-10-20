package org.CalculateTax;

import java.util.ArrayList;

import org.Item.ItemDetails;

/**
 * this class is used for calculating tax by using reflection method
 * @class.forName() is used to create instance variable
 * @author pramodyadav
 *
 */
public class ApplyTaxRule {

	/**
	 * ...this method use for calling the calculateTax() fn based on item type
	 * @param inputArrayList
	 * @return outputItemList
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<ItemDetails> calculateTotalCost (ArrayList<ItemDetails> inputArrayList) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{

		ItemDetails itemDetailsObj = null;

		ArrayList<ItemDetails> outputItemList = new ArrayList<ItemDetails>();
		for(int i=0;i<inputArrayList.size();i++)
		{
			itemDetailsObj=(ItemDetails)Class.forName("org.Item."+inputArrayList.get(i).getItemType()+"Item").newInstance();
			outputItemList.add(itemDetailsObj.calculateTax(inputArrayList.get(i)));	
		}

		return outputItemList;	
	}
}
