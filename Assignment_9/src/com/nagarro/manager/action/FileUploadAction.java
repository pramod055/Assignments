package com.nagarro.manager.action;

import java.io.File;

import java.util.Arrays;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.nagarro.manager.data.Employee;
import com.nagarro.manager.service.HibernateDao;
import com.nagarro.manager.utilities.CsvDataFetcher;
import com.nagarro.manager.utilities.EmployeeUpdator;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;

	public String execute() {
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session=request.getSession();  
		  
		String s=(String)session.getAttribute("login");  
		if(s!=null && !s.equals("")){  
			if (Arrays.asList("application/vnd.ms-excel,text/plain,text/csv,text/tsv".split(","))
					.contains(myFileContentType)) {
				Set<Employee> employees = CsvDataFetcher.getEmployees(myFile);
				HibernateDao.getHibernateDao().fileUpload(employees);
				EmployeeUpdator.update();
				return SUCCESS;
			} 
			return ERROR;
		}  
		return LOGIN;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;

	}

}
