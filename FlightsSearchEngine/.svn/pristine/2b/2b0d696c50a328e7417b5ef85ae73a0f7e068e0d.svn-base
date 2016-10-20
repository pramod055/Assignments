package com.nagarro.flightsearchengine.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.nagarro.flightsearchengine.service.ValidateIO;
import com.nagarro.flightsearchengine.watcher.LocalizationForStoringConstantMessage;
/**
 * @author pramodyadav
 * this class is used for taking user input and call validation method
 *return string array of input
 */

public class UserInputAndCallValidationIO {
	public String[] enterInputCallValidation() throws exception, IOException
	{
		System.out.println(LocalizationForStoringConstantMessage.getConstantString("enterDetails"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String inputArray[]= new String[80];
		System.out.println(LocalizationForStoringConstantMessage.getConstantString("dep_loc"));
		inputArray[0]= br.readLine();
		System.out.println(LocalizationForStoringConstantMessage.getConstantString("arr_loc"));
		inputArray[1]= br.readLine();
		System.out.println(LocalizationForStoringConstantMessage.getConstantString("date"));
		inputArray[2]= br.readLine();
		System.out.println(LocalizationForStoringConstantMessage.getConstantString("flightclass"));
		inputArray[3]=br.readLine();
		System.out.println(LocalizationForStoringConstantMessage.getConstantString("outputperfence"));
		inputArray[4]=br.readLine();
		try {
			ValidateIO.validate(inputArray);
		} catch (exception e) {
			throw new exception(e.getMessage());

		}
		return inputArray;
	}
}
