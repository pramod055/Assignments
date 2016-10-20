package com.nagarro.dao;

import java.io.File;
import java.util.List;

import com.nagarro.model.FlightModel;
import com.nagarro.model.UserInput;
import com.nagarro.util.exception;

public interface FlightDao {

	void insertData(File file) throws exception;

	List<FlightModel> searchFlight(UserInput userInputObj) throws InterruptedException;

}
