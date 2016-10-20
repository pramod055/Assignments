package com.nagarro.billCalculator.service;

import java.util.HashMap;

import com.nagarro.billCalculator.constants.BillCalculatorResources;
import com.nagarro.billCalculator.constants.Constants;
import com.nagarro.billCalculator.exceptions.InputException;
import com.nagarro.billCalculator.model.BillCalculator;
import com.nagarro.billCalculator.view.BillConsoleInput;
import com.nagarro.billCalculator.view.BillConsoleOut;

public class Runner
{
	public static void start()
	{
		String continueChoice;
		HashMap<String, String> userInputs;
		int continueFlag = -1;
		double resultantAmount;
		
		do
		{
			System.out.println("\n\n\t------------------------------------------------------------Billing System------------------------------------------------------------"
					+ "\n\tEnter 'Y' to continue Or 'N' to exit... ");

			do
			{
				try
				{
					continueChoice = Constants.INPUT.nextLine();

					if ( continueChoice.equalsIgnoreCase("Y") )
					{
						continueFlag = 1;
					}
					else if ( continueChoice.equalsIgnoreCase("N") )
					{
						continueFlag = 0;
					}
					else
					{
						continueFlag = -1;
						throw new InputException("Error: Enter only Y/N... ");
					}
				}
				catch (Exception e)
				{
					throw e;
				}
			} while (continueFlag == -1);

			if ( continueFlag == 1 )
			{
				userInputs = BillConsoleInput.cmdInput();

				resultantAmount = BillCalculator.calculate(userInputs);
				
				BillConsoleOut.printResult(resultantAmount);
			}

		} while (continueFlag == 1);
	}

	public static void main(String[] args)
	{
		try
		{
			start();
		}
		catch (Exception e)
		{
			System.err.println("Error Occured: "+e.getMessage());
		}
		finally
		{
			BillCalculatorResources.close();
		}
	}
}
