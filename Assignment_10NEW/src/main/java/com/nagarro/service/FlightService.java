package com.nagarro.service;

import java.text.ParseException;
import java.util.List;

import com.nagarro.model.FlightModel;
import com.nagarro.model.UserInput;
import com.nagarro.util.exception;

public interface FlightService {

	void saveCSVFileIntoDB() throws exception;
	List<FlightModel> searchFlightFromDB(UserInput userInputObj) throws exception, ParseException, InterruptedException;
}
