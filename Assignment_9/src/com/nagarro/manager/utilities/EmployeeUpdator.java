package com.nagarro.manager.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.nagarro.manager.data.Employee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class EmployeeUpdator {
	public static void update() {
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map<String, Object> context = new HashMap<>();
		List<Employee> employees = null;

		Session s = HibernateUtilities.getSessionFactory().openSession();
		s.beginTransaction();
		employees = s.createQuery("from Employee").list();
		s.getTransaction().commit();
		s.close();

		context.put("WPEmployees", employees);
		stack.push(context);
	}
}
