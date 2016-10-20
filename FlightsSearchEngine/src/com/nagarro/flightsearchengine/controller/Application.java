package com.nagarro.flightsearchengine.controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import com.nagarro.flightsearchengine.domain.FlightDetails;
import com.nagarro.flightsearchengine.service.ReadCSVAndMakeSet;
import com.nagarro.flightsearchengine.service.SearchFlightBasedOnUserInput;
import com.nagarro.flightsearchengine.service.SortFlights;
import com.nagarro.flightsearchengine.utility.DisplaySearchedFlights;
import com.nagarro.flightsearchengine.utility.UserInputAndCallValidationIO;
import com.nagarro.flightsearchengine.utility.exception;
import com.nagarro.flightsearchengine.watcher.DirWatcherTest;
import com.nagarro.flightsearchengine.watcher.LocalizationForStoringConstantMessage;
/**
 * @author pramod yadav
 * this application is used to search flight based on user input 
 * and display flight according to user requirement
 *This is the main Runner class to flight search Application
 *runner method  control the flow of program
 */
public class Application {
/**
 * main method that call runner method
 * @param args
 */
	public static void main(String[] args)
	{
		Application object = new Application();
		object.runner();
	}

	public void runner()
	{
		/**
		 * this map use for store the data of csv files
		 * string-file name
		 * set<FlightDetails>-hash set that store the data of of one csv file
		 */
		TreeMap<String,Set<FlightDetails>> filesMap=new TreeMap<String,Set<FlightDetails>>();
		Set<FlightDetails> resultantSet = null;
		FlightDetails flightdetails_object = new FlightDetails();
		/**
		 * set map object for future use
		 */
		flightdetails_object.setFilesMap(filesMap);
		/**
		 * initially we read all file and make a map for all file
		 */
		File dir = new File(LocalizationForStoringConstantMessage.getConstantString("CSVPATH"));
		File[] files = dir.listFiles();
		for (File file : files) 
		{
			ReadCSVAndMakeSet readcsv1 = new ReadCSVAndMakeSet();
			resultantSet = readcsv1.readCSV(file);
			filesMap.put(file.getName(), resultantSet);
			flightdetails_object.setFilesMap(filesMap);
		}
			
		DirWatcherTest watcher1 = new DirWatcherTest();
		/**
		 * pollCSVFile()-this method use for polling csv file folder to modification ,deletion nd addition after a fixed time interval
		 */
		watcher1.pollCSVFile(flightdetails_object);
		String choice = null;
		/**
		 * this do-while loop for serve the multiple user
		 */
		do
		{	
			UserInputAndCallValidationIO object = new UserInputAndCallValidationIO();
			String inputArray[] = null;
			try 
			{
				System.out.println(LocalizationForStoringConstantMessage.getConstantString("Start"));
				/**
				 * enterInputCallValidation()-it is use for taking user input and return string array of input after validation of input
				 */
				inputArray = object.enterInputCallValidation();
				filesMap = flightdetails_object.getFilesMap();
			
				/**
				 * searchFlights()-this method use for search flight based on input and return a resultset
				 */
				SearchFlightBasedOnUserInput searchflight1 = new SearchFlightBasedOnUserInput ();
				resultantSet= searchflight1.searchFlights(filesMap, inputArray);
				/**
				 * sortFlights()-sort flight according to user preference
				 */
				SortFlights sortflight = new SortFlights();
				List<FlightDetails> resultantArraylist = sortflight.sortFlights(resultantSet,inputArray);
				/**
				 * clear set for next process
				 */
				resultantSet.clear();
				/**
				 * printSearchedFlight()-display output on console
				 */
				DisplaySearchedFlights display = new DisplaySearchedFlights();
				display.printSearchedFlight(resultantArraylist,inputArray);
				resultantArraylist.clear();
			}
			catch (exception | IOException e) 
			{
				/**
				 * print all type of exception that are occur in program
				 */
				System.out.println(e.getMessage());
			} 
			try 
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				/**
				 * enter your choice for making more transition
				 */
				System.out.println(LocalizationForStoringConstantMessage.getConstantString("userChoice"));
				choice = br.readLine();
			} 
			catch (IOException e) 
			{
				System.out.println(LocalizationForStoringConstantMessage.getConstantString("ErrorInChoice"));
			}
		}   while(choice.equalsIgnoreCase("y"));
		System.exit(0);
	}

}

