package com.nagarro.manager.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.nagarro.manager.data.Employee;
import com.nagarro.manager.service.HibernateDao;

import com.nagarro.manager.utilities.DataParser;
import com.nagarro.manager.utilities.EmployeeUpdator;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9050211643000033758L;
	private Employee employee = new Employee();

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	private String empcode;
	private String dateofbirth;
	private String id;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session=request.getSession();  
		  
		String s=(String)session.getAttribute("login");  
		if(s!=null && !s.equals("")){  
		try {
		employee.setEmployeeID(Integer.parseInt(getId()));
		employee.setDateofbirth(DataParser.parseDate(getDateofbirth()));
		employee.setEmpcode(Integer.parseInt(getEmpcode()));
		}catch(Exception ex) {
			return ERROR;
		}
		if(HibernateDao.getHibernateDao().editEmployee(employee)){
		EmployeeUpdator.update();
		return SUCCESS;
		}
		return ERROR;
		}
		return LOGIN;
	}
	
	

	public String getEmpcode() {
		return empcode;
	}

	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

}
