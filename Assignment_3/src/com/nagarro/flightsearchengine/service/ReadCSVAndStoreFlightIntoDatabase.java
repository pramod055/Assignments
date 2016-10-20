package com.nagarro.flightsearchengine.service;

import java.io.File;

import org.hibernate.HibernateException;

import com.nagarro.flightsearchengine.dao.CRUDOpOnDatabase;
import com.nagarro.flightsearchengine.utility.LocalizationForStoringConstantMessage;
import com.nagarro.flightsearchengine.utility.exception;
public class ReadCSVAndStoreFlightIntoDatabase {

	public void storeCsvFileIntoDB() throws exception
	{
		try
		{


			File dir = new File(LocalizationForStoringConstantMessage.getConstantString("CSVPATH"));
			File[] files = dir.listFiles();
			for (File file : files) 
			{
				CRUDOpOnDatabase insert = new CRUDOpOnDatabase();
				insert.insertData(file);
			}
		}

			catch(HibernateException e)
			{
				throw new exception(e.getMessage()); 
			}
	}
}


