package com.nagarro.flightsearchengine.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.nagarro.flightsearchengine.model.UserInputDetails;
import com.nagarro.flightsearchengine.service.ValidateIO;
import com.nagarro.flightsearchengine.utility.LocalizationForStoringConstantMessage;
import com.nagarro.flightsearchengine.utility.exception;
/**
 * @author pramodyadav
 * this class is used for taking user input and call validation method
 *return string array of input
 */

public class UserInputAndCallValidationIO {
	public UserInputDetails enterInputCallValidation() throws exception, IOException{
		String inputArray[]= new String[80];
		UserInputDetails userinputdetails = new UserInputDetails();
		System.out.println(LocalizationForStoringConstantMessage.getConstantString("enterDetails"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println(LocalizationForStoringConstantMessage.getConstantString("dep_loc"));
		inputArray[0]=br.readLine();
		System.out.println(LocalizationForStoringConstantMessage.getConstantString("arr_loc"));
		inputArray[1]= br.readLine();
		System.out.println(LocalizationForStoringConstantMessage.getConstantString("date"));
		inputArray[2]= br.readLine();
		System.out.println(LocalizationForStoringConstantMessage.getConstantString("flightclass"));
		inputArray[3]=br.readLine();
		System.out.println(LocalizationForStoringConstantMessage.getConstantString("outputperfence"));
		inputArray[4]= br.readLine();
		try {
			ValidateIO.validate(inputArray);
			userinputdetails.setDepartureLocation(inputArray[0]);
			userinputdetails.setArrivalLocation(inputArray[1]);
			userinputdetails.setFlightDate(inputArray[2]);
			if(inputArray[3].equalsIgnoreCase("1")){
				userinputdetails.setFlightClass("E");
			}else{
				userinputdetails.setFlightClass("B");	
			}
			userinputdetails.setOutputPreference(inputArray[4]);
		} catch (exception e) {
			throw new exception(e.getMessage());
		}
		return userinputdetails;
	}
}
