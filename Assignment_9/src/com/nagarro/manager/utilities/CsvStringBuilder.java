package com.nagarro.manager.utilities;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;

import com.nagarro.manager.data.Employee;

public class CsvStringBuilder {

	private static final Object CSV_SEPERATOR = ",";

	public static StringBuilder getAllEmployees() {

		List<Employee> employees = null;
		Session s = HibernateUtilities.getSessionFactory().openSession();
		s.beginTransaction();
		employees = s.createQuery("from Employee").list();
		s.getTransaction().commit();
		s.close();

		StringBuilder sb = new StringBuilder();
		for (Employee employee : employees) {
			sb.append(new SimpleDateFormat("dd-MM-yyyy").format(employee.getDateofbirth()));
			sb.append(CSV_SEPERATOR);
			sb.append(employee.getEmail());
			sb.append(CSV_SEPERATOR);
			sb.append(employee.getEmpcode());
			sb.append(CSV_SEPERATOR);
			sb.append(employee.getLocation());
			sb.append(CSV_SEPERATOR);
			sb.append(employee.getEmpname());
			sb.append("\r\n");
		}
		return sb;
	}
}
