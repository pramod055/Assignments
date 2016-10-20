package org.MainApplicationAndIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.Item.ItemDetails;
import org.ValidateAndDisplayOutput.ValidateIO;

/**
 * this is used to taking input from user
 * @author pramodyadav
 *
 */
public  class UserInput  {

	ItemDetails itemDetailsObj;
	ArrayList<ItemDetails> items=new ArrayList<ItemDetails>();
	/**
	 *    //......this method is used for taking one or more item details .......
	 * @return array list of item details object
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public  ArrayList<ItemDetails> enterInput() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input[] = new String[100];
		String iterator = null;

		do
		{	
			System.out.print("\n......Please Enter Item Name/Price/Type/Quantity in Correct Format(ex. name:xyz)......");
			input[0]= br.readLine();
			input[1]= br.readLine();
			input[2]= br.readLine();
			input[3]= br.readLine();
			if(!findinputtype(input))
			{
				iterator = "y";
			}
			else
			{
				System.out.println("Do you want to enter details of any other item !!Please Enter (y)");
				iterator = br.readLine();
			}

		}while(iterator.equalsIgnoreCase("y"));
		return items;
	}

	/**
	 * this method is used to find the input like;which input is name etc. 
	 * and it also call  validation method for valid input
	 * @param input it is a string array entered by user
	 * @return valid -true 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public boolean findinputtype(String input[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		String Name = null;
		String Type = null;
		String Quantity = null;
		String Price = null;

		for(int i=0;i<4;i++)
		{
			StringTokenizer s =new StringTokenizer(input[i],":");
			if(!(s.countTokens() == 2))
			{
				System.out.println("please enter value in correct foramt:");
				return false;
			}
			String a=s.nextToken();
			String b=s.nextToken();
			if(a.equalsIgnoreCase("Name"))
			{
				Name = b;
			}
			else if(a.equalsIgnoreCase("type"))
			{
				Type = b;
				Type=Type.substring(0, 1).toUpperCase() + Type.substring(1).toLowerCase();
			}
			else if(  a.equalsIgnoreCase("quantity")) 
			{
				Quantity =b;
			}
			else if(a.equalsIgnoreCase("price"))
			{
				Price = b;
			}
			else
			{
				System.out.println("Please enter input in correct format:");
				//System.out.println("Please Enter Item Name/Price/Type/Quantity in Correct Format(ex. name:xyz)");
			}
		}
		/**
		 * check for validation
		 */
		if(ValidateIO.validateItemName(Name) && ValidateIO.validateItemPrice(Price) && ValidateIO.validateItemType(Type) && 
				ValidateIO.validateItemQuantity(Quantity))
		{
			itemDetailsObj=(ItemDetails)Class.forName("org.Item."+Type+"Item").newInstance();
			itemDetailsObj.setItemName(Name); 
			itemDetailsObj.setItemPrice(Double.parseDouble(Price));
			itemDetailsObj.setItemQuantity(Integer.parseInt(Quantity));
			itemDetailsObj.setItemType(Type);	
			items.add(itemDetailsObj);
			return true;
		}
		return false;


	}
}






















