package org.MainApplicationAndIO;

import java.util.ArrayList;

import org.CalculateTax.ApplyTaxRule;
import org.Item.ItemDetails;
import org.ValidateAndDisplayOutput.DisplayBill;

/**
 * <h1>Runner class!</h1>
 * User give the details of item as input
 * It is used to calculate total price of item , after calculating 
 * sales tax and print the output on screen
 */


public class Application {

	/**
	 * this method is used only for run the application
	 *
	 */
	public static void main(String[] args)
	{
		Application app = new Application();
		app.run();

	}

	/**
	 * This method is used for calling the fn in a procedure Like: runner method
	 * @inputArrayList is used for taking multiple item details
	 */

	public void run()
	{
		System.out.println("................WelCome To Nagarro................");
		ArrayList<ItemDetails> inputArrayList = null;
		UserInput inputob=new UserInput();
		try {
			inputArrayList=inputob.enterInput();
			ApplyTaxRule object = new ApplyTaxRule();
			ArrayList<ItemDetails> outputItemList = object.calculateTotalCost(inputArrayList);
			DisplayBill ob = new DisplayBill();
			ob.printBill(outputItemList);
		} catch (Exception e) {

			e.printStackTrace();
		} 
	}


}
