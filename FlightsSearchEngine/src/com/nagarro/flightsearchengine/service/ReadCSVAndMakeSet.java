package com.nagarro.flightsearchengine.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.nagarro.flightsearchengine.domain.FlightDetails;
/**
 * @author pramodyadav
 *class use for reading csv file and make a HashSet for file
 */
public class ReadCSVAndMakeSet {

	
	public Set<FlightDetails> readCSV(File file)
	{
		/**
		
		 * read csv file and make a FlightDetails class object and add it to Hashset
		 *  * @return HashSet
		 */
		Scanner sc = null;
		Set<FlightDetails> resultantSet= new HashSet<FlightDetails>();
		try {

			String sCurrentLine=null;;
			sc = new Scanner(new FileReader(file));
			sCurrentLine = sc.nextLine();
			while (sc.hasNext()) 
			{
				sCurrentLine = sc.nextLine();
				createObjectFromCSVFlightDetails ob = new createObjectFromCSVFlightDetails();
				FlightDetails flight_ob = ob.getFlightDetailsObjectFromCSVLine(sCurrentLine);
				/**
				 * check duplication of flight based on flightid dep and arr location
				 * for cecking duplicate flight we override equals() and hashCode() method  
				 */
				if(!resultantSet.contains(flight_ob))
				{
					resultantSet.add(flight_ob);
				}	
			}
			sc.close();

		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally
		{
			try {
				if (sc != null)
					sc.close();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return resultantSet;

	}
}
