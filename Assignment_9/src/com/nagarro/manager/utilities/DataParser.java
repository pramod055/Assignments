package com.nagarro.manager.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.validator.ValidationException;

public class DataParser {
	public static Date parseDate(String dateString) throws ValidationException {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			throw new ValidationException("Date Parsing Error: " + date);
		}
		return date;
	}

	public static String parseEmail(String email) {
		return email;
	}

	public static int parseEmpCode(String empCodeString) {
		int empCode = Integer.parseInt(empCodeString);
		return empCode;
	}

	public static String parseLocation(String location) {
		return location;
	}

	public static String parseName(String name) {
		return name;
	}
}
