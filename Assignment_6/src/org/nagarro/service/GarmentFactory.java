package org.nagarro.service;

import org.nagarro.exceptions.InputException;
import org.nagarro.garmentindustry.JeanClass;
import org.nagarro.garmentindustry.ShirtClass;
import org.nagarro.garmentindustry.TrouserClass;
import org.nagarro.model.GarmentModel;

public class GarmentFactory 
{
	public Garment getGarment(GarmentModel garmentDetailsOb) {
		if (garmentDetailsOb.getName() == null)
		{
			System.out.println("Error ::Please Enter a valid Garment Name:");
			return null;
		}
		if (garmentDetailsOb.getName().equalsIgnoreCase("Shirt")) 
		{
			return new ShirtClass();
		} 
		else if (garmentDetailsOb.getName().equalsIgnoreCase("Trouser"))
		{
			return new TrouserClass();
		}
		else if (garmentDetailsOb.getName().equalsIgnoreCase("Jean"))
		{
			return new JeanClass();
		}
		else
		{
			throw new InputException("Invalid GarmentName: Name must be  in given option");
		}
		
	}

}
