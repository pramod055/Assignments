package com.nagarro.flightsearchengine.dao;

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

import com.nagarro.flightsearchengine.model.AirlineDetails;
import com.nagarro.flightsearchengine.model.FlightDetails;
import com.nagarro.flightsearchengine.model.UserInputDetails;
import com.nagarro.flightsearchengine.service.SortFlightBasedOnUserPreference;
import com.nagarro.flightsearchengine.service.createObjectFromCSVFlightDetails;
import com.nagarro.flightsearchengine.utility.HibernateUtil;
import com.nagarro.flightsearchengine.utility.exception;

public class CRUDOpOnDatabase {
	Session session;
	public void insertData(File file) throws exception{
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Scanner sc = null;
		String sCurrentLine=null;;

		try {
			AirlineDetails airline = new AirlineDetails();
			airline.setAirlineName(file.getName());
			sc = new Scanner(new FileReader(file));
			sCurrentLine = sc.nextLine();
			Set<FlightDetails> resultantSet= new HashSet<FlightDetails>();
			while (sc.hasNext()) {
				sCurrentLine = sc.nextLine();
				createObjectFromCSVFlightDetails ob = new createObjectFromCSVFlightDetails();
				FlightDetails flight_ob = ob.getFlightDetailsObjectFromCSVLine(sCurrentLine);
				/**
				 * check duplication of flight based on flightid dep and arr location
				 * for checking duplicate flight we override equals() and hashCode() method  
				 */
				if(!resultantSet.contains(flight_ob)){
					resultantSet.add(flight_ob);//
				}		
			}
			airline.setFlights(resultantSet);
			session.save(airline);
			session.getTransaction().commit();
			session.close();
		} 
		catch (IOException e) {
			throw new exception(e.getMessage()); 
		} finally{
			try {
				if (sc != null)
					sc.close();
			}catch (Exception ex){
				throw new exception(ex.getMessage()); 
			}
		}

	}

	public void DeleteFromDatabase(File file){
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

	public List<FlightDetails> SearchFlightIntoDatabaseAnd_sort(UserInputDetails userInputObject )
			throws ParseException, exception{
		/**
		 * this method use for search flight based on user input and return a criteria object to controller class
		 */
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria =null;
		Transaction tx = null;
		List<FlightDetails> resultantflightsList = null;
		try{
			tx = session.beginTransaction();
			/**
			 * convert the date into sql date format
			 */
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			df.setLenient(false);
			Date utilDate = df.parse(userInputObject.getFlightDate());
			java.sql.Date slqDate = new java.sql.Date(utilDate.getTime());
			/**
			 * select criteria based on user input
			 */
			criteria = session.createCriteria(FlightDetails.class);
			criteria.add(Restrictions.eq("Dep_Loc", userInputObject.getDepartureLocation()))
			.add(Restrictions.eq("Arr_Loc", userInputObject.getArrivalLocation()))
			.add(Restrictions.eq("Seat_Availability","Y"))
			.add(Restrictions.ge("Valid_Till", slqDate))
			.add(Restrictions.or(Restrictions.eq("Flight_Class", userInputObject.getFlightClass()),
					Restrictions.eq("Flight_Class", "EB")));
			/**
			 * sortFlights()-sort flight according to user preference
			 * @return list of flightdetails class object
			 */
			resultantflightsList = SortFlightBasedOnUserPreference.sortFlights(criteria,userInputObject);
			tx.commit();
		}catch (HibernateException e){
			throw new exception(e.getMessage()); 
		}finally{
			session.close(); 
		}
		return resultantflightsList;
	}
}
