package org.nagarro.garmentindustry;

import org.nagarro.service.Garment;

public class TrouserClass implements Garment
{
	@Override
	public void showGarment(double Size,String Color) {
		System.out.println("Your garment details are :: \nName : TROUSER" + "\nColor : "+ Color + "\nSize : " +Size);
	}
}
