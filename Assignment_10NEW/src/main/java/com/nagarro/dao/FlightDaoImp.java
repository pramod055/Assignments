package com.nagarro.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;

import com.nagarro.model.AirlineModel;
import com.nagarro.model.FlightModel;
import com.nagarro.model.RegisterModel;
import com.nagarro.model.UserInput;
import com.nagarro.service.createObjectFromCSVFlightModel1;
import com.nagarro.util.exception;

@Repository("CSVFileStoreRepository")

public class FlightDaoImp implements FlightDao {

	@PersistenceContext
	private EntityManager em;


	public void insertData(File file) throws exception {
		Scanner sc = null;
		String sCurrentLine=null;;
		try {
			AirlineModel airline = new AirlineModel();
			Query query = em.createQuery("Select rg from AirlineModel rg where rg.Airline_NAME ='" +file.getName()+"'");

			@SuppressWarnings("unchecked")
			List<RegisterModel> isAirlineExists = query.getResultList();
			if(isAirlineExists.size()!=0)
				return ;
			airline.setAirlineName(file.getName());
			sc = new Scanner(new FileReader(file));
			sCurrentLine = sc.nextLine();
			Set<FlightModel> resultantSet= new HashSet<FlightModel>();

			while (sc.hasNext()) 
			{
				sCurrentLine = sc.nextLine();
				createObjectFromCSVFlightModel1 ob = new createObjectFromCSVFlightModel1();
				FlightModel flight_ob = ob.getFlightModelObjectFromCSVLine(sCurrentLine);
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
			em.persist(airline);
		} 
		catch (IOException e){
			throw new exception(e.getMessage()); 
		} 
		finally{
			if (sc != null){
				sc.close();
				
			}
		}
	}


	public List<FlightModel> searchFlight(UserInput userInputObj) throws InterruptedException {
       System.out.println("start1");
		Query query = em.createQuery("Select fm from FlightModel fm where fm.Arr_Loc ='"+userInputObj.getArr_Loc()+"' AND " +
				"fm.Dep_Loc='"+userInputObj.getDep_Loc()+"' AND " +
				"fm.Flight_Class='"+userInputObj.getFlight_Class()+"'"
				);
		@SuppressWarnings("unchecked")
		List<FlightModel> resultantSearchedFlight = query.getResultList();
		 System.out.println("start2" +resultantSearchedFlight.size());
		query = em.createQuery("Select rg from AirlineModel rg where rg.Airline_NAME ='AirIndia.csv'");
		
		@SuppressWarnings("unchecked")
		List<AirlineModel> file =query.getResultList();
		
		AirlineModel temp =file.get(0);
		 System.out.println("star3");
		AirlineModel department = em.getReference(AirlineModel.class, temp.getAirlineId());
		
		System.out.println("$$$ Airline size= "+file.size()+" Airline id= "+temp.getAirlineId());

		 System.out.println("start123");
		em.remove(department);
		em.wait(1000);
		 System.out.println("start4");
		return resultantSearchedFlight;
	}
}


