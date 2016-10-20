package org.nagarro.garmentindustry;

import org.nagarro.service.Garment;

public class JeanClass implements Garment {
	@Override
	public void showGarment(double Size,String Color) {
		System.out.println("Your garment details are :: \nName : Jean" + "\nColor : "+ Color + "\nSize : " +Size);
	}

}