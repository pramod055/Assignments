package com.nagarro.manager.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.hibernate.metamodel.ValidationException;

import com.nagarro.manager.data.Employee;

public class CsvDataFetcher {

	public static Set<Employee> getEmployees(File file) {
		Set<Employee> employeeSet = new HashSet<>();
		try {
			for (String line : FileUtils.readLines(file)) {
				Employee employee = parseEmployeeDetail(line);
				if (employee != null)
					employeeSet.add(employee);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeeSet;
	}

	private static Employee parseEmployeeDetail(String record) {

		Employee employee = new Employee();
		String cvsSplitBy = ",";

		String[] employeeDetail = record.split(cvsSplitBy);

		try {
			Date dob = DataParser.parseDate(employeeDetail[0]);
			String email = DataParser.parseEmail(employeeDetail[1]);
			int empCode = DataParser.parseEmpCode(employeeDetail[2]);
			String location = DataParser.parseLocation(employeeDetail[3]);
			String name = DataParser.parseName(employeeDetail[4]);

			employee.setDateofbirth(dob);
			employee.setEmail(email);
			employee.setEmpcode(empCode);
			employee.setLocation(location);
			employee.setEmpname(name);

		} catch (ValidationException e) {
			e.printStackTrace();
			return null;
		} catch (com.opensymphony.xwork2.validator.ValidationException e) {
			e.printStackTrace();
		}

		return employee;
	}
}
