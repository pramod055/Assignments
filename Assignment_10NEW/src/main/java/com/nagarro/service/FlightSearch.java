package com.nagarro.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.nagarro.dao.CRUDOpOnDatabase;
import com.nagarro.model.FlightDetails;
import com.nagarro.model.UserInput;
import com.nagarro.thread.DirWatcherTest;
import com.nagarro.util.DisplaySearchedFlights;
import com.nagarro.util.LocalizationForStoringConstantMessage;
import com.nagarro.util.UserInputAndCallValidationIO;

public class FlightSearch {
	/**
	 * main method that call runner method
	 * @param args
	 * @return 
	 */
	

	public List<FlightDetails> runner(UserInput inputobject)
	{
		
		List<FlightDetails> resultantSortedflightsList = null;
		try
		{
			/**
			 * here initially we store all directory file into database then we call thread for poll the directory
			 */
			ReadCSVAndStoreFlightIntoDatabase ob = new ReadCSVAndStoreFlightIntoDatabase();
			ob.storeCsvFileIntoDB();
			DirWatcherTest.thread();
			String choice =null;
		
				try 
				{
					UserInputAndCallValidationIO enterinput = new UserInputAndCallValidationIO();
					System.out.println(LocalizationForStoringConstantMessage.getConstantString("Start"));
					/**
					 * enterInputCallValidation()-it is use for taking user input and return  
					 * UserInputDetails class object after validation of input
					 */
					
				//	ValidateIO.validate(inputobject);

					//inputobject = enterinput.enterInputCallValidation();

					/**
					 * SearchFlightIntoDatabase()-this method use for search flight based on input and return a FlightDetails class object
					 */
					CRUDOpOnDatabase obj = new CRUDOpOnDatabase();
					resultantSortedflightsList = obj.SearchFlightIntoDatabaseAnd_sort(inputobject);
					/**
					 * printSearchedFlight()-display output on console
					 */
					DisplaySearchedFlights.printSearchedFlight(resultantSortedflightsList);
				} catch (Exception e) 
				{
					System.out.println(e.getMessage());
				}
				
				
				
				/**
				 * entering user choice for more query
				 */
				

		}
		catch (Exception e) 
		{
			/**
			 *  print all type of exception that are occur in program
			 */
			
			
		}
      return resultantSortedflightsList;
	}

}
