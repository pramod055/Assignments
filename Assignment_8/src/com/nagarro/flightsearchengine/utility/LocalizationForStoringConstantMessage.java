package com.nagarro.flightsearchengine.utility;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationForStoringConstantMessage {
	static ResourceBundle bundle =null;
	public static  String getConstantString(String key){ 
		if(bundle == null) {
			Locale currentLocale = Locale.getDefault();
			String language =currentLocale.getLanguage();
			String country =currentLocale.getCountry();
			/** 
			 * String str = System.getProperty("user.country");
			 * String str1 = System.getProperty("user.language");
			 *System.out.println(str + " " +str1);
			 */
			Locale.setDefault(new Locale(language, country));     
		}
		bundle = ResourceBundle.getBundle("MessageBundle"); 
		return bundle.getString(key);  
	}
}
