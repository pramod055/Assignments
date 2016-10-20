package org.nagarro.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.nagarro.exceptions.InputException;
import org.nagarro.model.GarmentModel;

public class CustomerInput 
{
	public GarmentModel enterInput()
	{
		GarmentModel ob = new GarmentModel();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please Enter the Details for selection of Garment\n\n");
			System.out.println("Enter the Name of Garment <Shirt,Trouser,Jean> :");
		    ob.setName(br.readLine());
			System.out.println("Enter the Color of Garment :");
		    ob.setColor(br.readLine());
			System.out.println("Enter the Size of Garment :");
			 ob.setSize(Double.parseDouble(br.readLine()));
		}catch(Exception e)
		{
			throw new InputException("Invalid Size: Size must be in double format");
		}
		return ob;
		
	}
}
