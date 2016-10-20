package com.nagarro.manager.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.manager.data.Employee;
import com.nagarro.manager.data.Manager;

import com.nagarro.manager.utilities.HibernateUtilities;

public class HibernateDao {
	
	private static HibernateDao hibernateDao=new HibernateDao();

	public  List<Manager> loginValidation(String user, String password) {

		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Manager.class);

		cr.add(Restrictions.eq("uname", user));
		cr.add(Restrictions.eq("password", password));
		List<Manager> mlist = cr.list();
		session.getTransaction().commit();
		session.close();
		return mlist;
	}

	public void fileUpload(Set<Employee> employees) {

		Session s = HibernateUtilities.getSessionFactory().openSession();
		s.beginTransaction();
		removeAlreadyExistingRecord(employees);
		for (Employee employee : employees) {
			s.save(employee);
		}
		s.getTransaction().commit();
		s.close();
	}

	public void removeAlreadyExistingRecord(Set<Employee> employees) {
		Session s = HibernateUtilities.getSessionFactory().openSession();
		s.beginTransaction();
		List<Integer> empCodeListString = s.createQuery("select empcode from Employee").list();
		Iterator<Employee> iterator = (new HashSet<>(employees)).iterator();
		while (iterator.hasNext()) {
			Employee emp = iterator.next();
			for (int empCode : empCodeListString) {
				if (emp.getEmpcode() == empCode) {
					employees.remove(emp);
				}
			}
		}
		s.getTransaction().commit();
		s.close();
	}
	
	public boolean editEmployee(Employee employee) {
		Session s = null;
    try {
		s = HibernateUtilities.getSessionFactory().openSession();
		s.beginTransaction();

		s.update(employee);
		s.getTransaction().commit();
		s.close();
    }catch(Exception ex) {
    	s.getTransaction().commit();
    	s.close();
		return false;
    }
    return true;

	}

	public static HibernateDao getHibernateDao() {
		return hibernateDao;
	}

	public static void setHibernateDao(HibernateDao hibernateDao) {
		HibernateDao.hibernateDao = hibernateDao;
	}
}
