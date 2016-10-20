package com.nagarro.manager.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.nagarro.manager.utilities.CsvStringBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InputStream fileInputStream;

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && !s.equals("")) {
			StringBuilder buf = CsvStringBuilder.getAllEmployees();
			fileInputStream = new ByteArrayInputStream(buf.toString().getBytes(StandardCharsets.UTF_8));
			return SUCCESS;
		}
		return LOGIN;
	}
}