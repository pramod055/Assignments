package org.nagarro.garmentindustry;

import org.nagarro.service.Garment;

public class ShirtClass implements Garment {
	@Override
	public void showGarment(double Size,String Color) {
		System.out.println("Your garment details are :: \nName : SHIRT" + "\nColor : "+ Color + "\nSize : " +Size);
	}
}
