package com.nagarro.billCalculator.view;

import java.util.HashMap;

import com.nagarro.billCalculator.constants.Constants;
import com.nagarro.billCalculator.exceptions.InputException;
import com.nagarro.billCalculator.util.InputValidator;

public class BillConsoleInput
{
	public static HashMap<String, String> cmdInput()
	{
		HashMap<String, String> resultMap = new HashMap<>();
		String choice;
		String billAmount=null, userType=null, dateOfJoining=null, isGrocery=null;

		boolean flag;

		do
		{
			flag = false;
			try
			{
				System.out.print("Enter Bill Amount: ");
				billAmount = Constants.INPUT.nextLine();
				InputValidator.billValidator(billAmount);
			}
			catch (Exception e)
			{
				flag = true;
				System.err.print("ERROR: " + e.getMessage() + "\n");
			}

		} while (flag);

		do
		{
			flag = false;
			try
			{
				System.out.print("Enter User Type:-\n\t1.Employee\n\t2.Affiliate\n\t3.Customer\n\tEnter your choice(1/2/3): ");
				choice = Constants.INPUT.nextLine();

				if ( choice.equals("1") )
					userType = "employee";
				else if ( choice.equals("2") )
					userType = "affiliate";
				else if ( choice.equals("3") )
					userType = "customer";
				else
					throw new InputException("Invalid Output Preference: Input is other than 1/2/3");
			}
			catch (Exception e)
			{
				flag = true;
				System.err.print("ERROR: " + e.getMessage() + "\n");
			}

		} while (flag);

		do
		{
			flag = false;
			try
			{
				System.out.print("Enter Joining Date(format: '" + Constants.DATE_FT.toPattern().toUpperCase() + "'): ");
				dateOfJoining = Constants.INPUT.nextLine();
				InputValidator.dateOfJoiningValidator(dateOfJoining);
			}
			catch (Exception e)
			{
				flag = true;
				System.err.print("ERROR: " + e.getMessage() + "\n");
			}

		} while (flag);

		do
		{
			flag = false;
			try
			{
				System.out.print("IS Grocery (Y/N): ");
				isGrocery = Constants.INPUT.nextLine();
				if ( !(isGrocery.equalsIgnoreCase("Y") || isGrocery.equalsIgnoreCase("N")) )
				{
					throw new InputException("Error: Enter only Y/N... ");
				}
			}
			catch (Exception e)
			{
				flag = true;
				System.err.print("ERROR: " + e.getMessage() + "\n");
			}

		} while (flag);

		resultMap.put("billAmount", billAmount);
		resultMap.put("userType", userType);
		resultMap.put("dateOfJoining", dateOfJoining);
		resultMap.put("isGrocery", isGrocery.toUpperCase());

		return resultMap;
	}
}
