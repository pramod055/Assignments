package org.nagarro.Runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.nagarro.model.GarmentModel;
import org.nagarro.service.Garment;
import org.nagarro.service.GarmentFactory;
import org.nagarro.util.CustomerInput;

public class GarmentFactoryApplication {

	public static void main(String[] args) throws IOException {
		try 
		{
			System.out.println("\n\t\t\tWelcome to GarmentIndustry");
			System.out.println("\n\n::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
			CustomerInput ob = new CustomerInput();
			GarmentModel garmentDetailsOb = ob.enterInput();
	        GarmentFactory garmentFactory=new GarmentFactory();
			//get an object of specified garment and call its methods.
			Garment garment1 = garmentFactory.getGarment(garmentDetailsOb);
			//calling showGarment method of garment
			System.out.println("\n..................................................................................................\n");
			garment1.showGarment(garmentDetailsOb.getSize(),garmentDetailsOb.getColor());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}

