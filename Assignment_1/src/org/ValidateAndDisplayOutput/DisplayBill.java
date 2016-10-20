package org.ValidateAndDisplayOutput;

import java.util.ArrayList;

import org.Item.ItemDetails;
/**
 * Display the final total cost ,sales tax per item ,name ,price,quantity,cumulative cost on screen
 * 
 */
public class DisplayBill {
	/**
	 * display output
	 * @param outputItemList
	 */
	public void printBill(ArrayList<ItemDetails>outputItemList)
	{
		//display bill details
		System.out.println("\t\t..........................BIll.........................");
		System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s","Item Name","Item Price","Sales Tax Per Item","Final Price","Quantity" ,"TotalPrice");
		for(int i=0;i<outputItemList.size();i++)
		{
			System.out.printf("\n%-20s %-20s %-20s %-23s%-23s%-20s " ,outputItemList.get(i).getItemName(), outputItemList.get(i).getItemPrice() 
					,outputItemList.get(i).getTax() ,outputItemList.get(i).getTotalCost(),outputItemList.get(i).getItemQuantity(),
					outputItemList.get(i).getTotalCost() *outputItemList.get(i).getItemQuantity());
		}
	}

}
