package com.nagarro.service;

import java.io.File;
import java.text.ParseException;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.dao.FlightDao;
import com.nagarro.model.FlightModel;
import com.nagarro.model.UserInput;
import com.nagarro.util.DisplaySearchedFlights;
import com.nagarro.util.exception;
@Service
public class FlightServiceImp implements FlightService {


	@Autowired
	public FlightDao flightDao ;
	@Transactional
	public void saveCSVFileIntoDB() throws exception {
		try{
			File dir = new File("D:/CSVFile/");
			File[] files = dir.listFiles();
			for (File file : files) {
				flightDao.insertData(file);
			}
		}
		catch(Exception e){	
			throw new exception(e.getMessage()); 
		}
	}
	@SuppressWarnings("static-access")
	public List<FlightModel> searchFlightFromDB(UserInput userInputObj) throws exception, ParseException, InterruptedException {
		List<FlightModel> resultantFlights = flightDao.searchFlight(userInputObj);
		
		/*DisplaySearchedFlights ob;
		try {
			ob = new DisplaySearchedFlights();
			System.out.println("\n\n\nsizze:" + resultantFlights.size() +"\n\n\n");
			ob.printSearchedFlight(resultantFlights);
			System.out.println("\n\n\nsizze:" + resultantFlights.size() +"\n\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		return resultantFlights;
	}
}


