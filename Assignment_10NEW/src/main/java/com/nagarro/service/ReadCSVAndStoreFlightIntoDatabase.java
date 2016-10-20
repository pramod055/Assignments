package com.nagarro.service;

import java.io.File;

import org.hibernate.HibernateException;

import com.nagarro.dao.CRUDOpOnDatabase;
import com.nagarro.util.LocalizationForStoringConstantMessage;
import com.nagarro.util.exception;


public class ReadCSVAndStoreFlightIntoDatabase {

	public void storeCsvFileIntoDB() throws exception
	{
		try
		{
			System.out.println("in loop1s");

			File dir = new File("D:/CSVFile/");
			System.out.println("in loop1s");
			File[] files = dir.listFiles();
			for (File file : files) 
			{
				System.out.println("in loop");
				CRUDOpOnDatabase insert = new CRUDOpOnDatabase();
				insert.insertData(file);
				System.out.println("in loop");
			}
		}

			catch(HibernateException e)
			{
				throw new exception(e.getMessage()); 
			}
	}
}


