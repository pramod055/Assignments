package com.nagarro.flightsearchengine.controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.nagarro.flightsearchengine.dao.CRUDOpOnDatabase;
import com.nagarro.flightsearchengine.model.FlightDetails;
import com.nagarro.flightsearchengine.model.UserInputDetails;
import com.nagarro.flightsearchengine.service.ReadCSVAndStoreFlightIntoDatabase;
import com.nagarro.flightsearchengine.thread.DirWatcherTest;
import com.nagarro.flightsearchengine.utility.LocalizationForStoringConstantMessage;
import com.nagarro.flightsearchengine.view.DisplaySearchedFlights;
import com.nagarro.flightsearchengine.view.UserInputAndCallValidationIO;
/**
 * @author pramod yadav
 * this application is used to search flight into database based on user input 
 * and display flight according to user requirement
 *This is the main Runner class to flight search Application
 *runner method  control the flow of program
 */
public class Application{
	/**
	 * main method that call runner method
	 * @param args
	 */
	public static void main(String[] args){
		Application object = new Application();
		object.runner();
	}

	public void runner(){

		try{
			/**
			 * here initially we store all directory file into database then we call thread for poll the directory
			 */
			String choice =null;
			ReadCSVAndStoreFlightIntoDatabase ob = new ReadCSVAndStoreFlightIntoDatabase();
			ob.storeCsvFileIntoDB();
			DirWatcherTest.thread();
			do
			{	
				try{
					UserInputAndCallValidationIO enterinput = new UserInputAndCallValidationIO();
					String inputArray[] = null;
					System.out.println(LocalizationForStoringConstantMessage.getConstantString("Start"));
					/**
					 * enterInputCallValidation()-it is use for taking user input and return  
					 * UserInputDetails class object after validation of input
					 */
					UserInputDetails inputobject  = new UserInputDetails();
					inputobject = enterinput.enterInputCallValidation();
					/**
					 * SearchFlightIntoDatabase()-this method use for search flight based on input and return a FlightDetails class object
					 */
					CRUDOpOnDatabase obj = new CRUDOpOnDatabase();
					List<FlightDetails> resultantSortedflightsList = obj.SearchFlightIntoDatabaseAnd_sort(inputobject);
					/**
					 * printSearchedFlight()-display output on console
					 */
					DisplaySearchedFlights.printSearchedFlight(resultantSortedflightsList,inputobject);
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
				/**
				 * entering user choice for more query
				 */
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
				System.out.println(LocalizationForStoringConstantMessage.getConstantString("userChoice"));
				choice = br.readLine();

			}while(choice.equalsIgnoreCase("Y"));
		}
		catch (Exception e){
			/**
			 *  print all type of exception that are occur in program
			 */
			System.out.println(e.getMessage());
		}
	}
}


