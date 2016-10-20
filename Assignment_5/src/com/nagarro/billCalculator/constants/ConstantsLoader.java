package com.nagarro.billCalculator.constants;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ConstantsLoader
{
	public static SimpleDateFormat getDateFormat()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		return dateFormat;
	}
	
	public static Scanner getInputScanner()
	{
		Scanner scanner = new Scanner(System.in);
		return scanner;
	}
}
