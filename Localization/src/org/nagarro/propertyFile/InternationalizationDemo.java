package org.nagarro.propertyFile;

import java.util.Locale;
import java.util.ResourceBundle;

public class InternationalizationDemo {  
	 
	static ResourceBundle bundle =null;
	public static void main(String[] args)
	{
		
		
		ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle", Locale.US);  
		  System.out.println("Message in "+Locale.US +":"+bundle.getString("Start"));

		
		Locale currentLocale = Locale.getDefault();
		String str =currentLocale.getLanguage();
		String str1 =currentLocale.getCountry();
		//String str = System.getProperty("user.country");
		//String str1 = System.getProperty("user.language");
	
		System.out.println(str + " " +str1);
		Locale.setDefault(new Locale(str, str1));  

		 //bundle = ResourceBundle.getBundle("MessageBundle",); 
	/*  
	  //ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle", Locale.US);  
	  //System.out.println("Message in "+Locale.US +":"+bundle.getString("Start"));  
		
	  Locale currentLocale = Locale.getDefault();
	String str =currentLocale.getLanguage();
		String str1 =currentLocale.getCountry();
		//String str = System.getProperty("user.country");
		//String str1 = System.getProperty("user.language");
		System.out.println(str + " " +str1);
		Locale.setDefault(new Locale(str, str1));   
	  bundle = ResourceBundle.getBundle("MessageBundle");  
	  System.out.println("Message in "+Locale.getDefault()+":"+bundle.getString("Start"));  
	  */
	 }  
	}  
