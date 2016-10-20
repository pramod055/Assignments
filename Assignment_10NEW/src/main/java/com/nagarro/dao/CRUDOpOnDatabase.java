package com.nagarro.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.nagarro.model.AirlineDetails;
import com.nagarro.model.FlightDetails;
import com.nagarro.model.UserInput;
import com.nagarro.service.SortFlightBasedOnUserPreference;
import com.nagarro.service.createObjectFromCSVFlightDetails;
import com.nagarro.util.HibernateUtil;
import com.nagarro.util.exception;

public class CRUDOpOnDatabase 
{

	Session session;
	public void insertData(File file) throws exception
	{
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		System.out.println("after session");
		Scanner sc = null;
		String sCurrentLine=null;;

		try {

			AirlineDetails airline = new AirlineDetails();
			airline.setAirlineName(file.getName());
		
			sc = new Scanner(new FileReader(file));
			sCurrentLine = sc.nextLine();
			Set<FlightDetails> resultantSet= new HashSet<FlightDetails>();
			
			while (sc.hasNext()) 
			{
				sCurrentLine = sc.nextLine();
				createObjectFromCSVFlightDetails ob = new createObjectFromCSVFlightDetails();
				FlightDetails flight_ob = ob.getFlightDetailsObjectFromCSVLine(sCurrentLine);
				/**
				 * check duplication of flight based on flightid dep and arr location
				 * for checking duplicate flight we override equals() and hashCode() method  
				 */
				if(!resultantSet.contains(flight_ob))
				{
					resultantSet.add(flight_ob);//
				}	
				
			}
			airline.setFlights(resultantSet);
			session.save(airline);
			session.getTransaction().commit();
			session.close();

		} 
		catch (IOException e) 
		{
			throw new exception(e.getMessage()); 
		} 
		finally
		{
			try {
				if (sc != null)
					sc.close();
			}
			catch (Exception ex)
			{
				throw new exception(ex.getMessage()); 
			}
		}

	}


	public void DeleteFromDatabase(File file)
	{
		/**
		 * this method use to delete airline and its corresponding flight 
		 */
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		/**
		 * Criteria  select  all the airline that have the Airline_NAME same as deleted file
		 * @Restrictions is same as where clause
		 */
		Criteria criteria = session.createCriteria(AirlineDetails.class).add(Restrictions.eq("Airline_NAME",file.getName()));;
		
		
		List<AirlineDetails> flightsList = criteria.list();
		/**
		 * load method return a object type entity corresponding filename'Airlineid then we call delete method.
		 */
		Object entity = session.load(AirlineDetails.class, flightsList.get(0).getAirlineId());
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}


	public List<FlightDetails> SearchFlightIntoDatabaseAnd_sort(UserInput userInputObject ) throws ParseException, exception
	{
		/**
		 * this method use for search flight based on user input and return a criteria object to controller class
		 */
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria =null;
		Transaction tx = null;
		List<FlightDetails> resultantflightsList = null;
		try
		{
			tx = session.beginTransaction();
			/**
			 * convert the date into sql date format
			 */
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			df.setLenient(false);
			Date utilDate = df.parse(userInputObject.getFlight_Date());
			java.sql.Date slqDate = new java.sql.Date(utilDate.getTime());
			/**
			 * select criteria based on user input
			 */
			criteria = session.createCriteria(FlightDetails.class);
			criteria.add(Restrictions.eq("dep_Loc", userInputObject.getDep_Loc()))
			.add(Restrictions.eq("arr_Loc", userInputObject.getArr_Loc()))
			.add(Restrictions.eq("seat_Availability","Y"))
			.add(Restrictions.ge("valid_Till", slqDate))
			.add(Restrictions.or(Restrictions.eq("flight_Class", userInputObject.getFlight_Class()),
					Restrictions.eq("flight_Class", "EB")));
			/**
			 * sortFlights()-sort flight according to user preference
			 * @return list of flightdetails class object
			 */
			resultantflightsList = SortFlightBasedOnUserPreference.sortFlights(criteria,userInputObject);
			tx.commit();
		}
		catch (HibernateException e)
		{
			System.out.println("crud");
			throw new exception(e.getMessage()); 
		}
		finally
		{
			session.close(); 
		}
		
		return resultantflightsList;
	}


}
