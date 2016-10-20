package com.nagarro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.dao.UserDAO;
import com.nagarro.model.RegisterModel;
import com.nagarro.service.ValidateService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String loginId, firstName, lastName, password, confirmPassword, emailAddress;
		UserDAO userDAO = new UserDAO();

		loginId = request.getParameter("loginId");
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		password = request.getParameter("password");
		confirmPassword = request.getParameter("confirmPassword");
		emailAddress = request.getParameter("emailAddress");

		// Connection connection= JavaConnectDb.coonectDb();
		/*
		 * Session session; session =
		 * HibernateUtil.getSessionFactory().openSession();
		 */
		HttpSession session = request.getSession(true);
		RegisterModel model = new RegisterModel();
		ValidateService validateService = new ValidateService();

		model.setConfirmPassword(confirmPassword);
		model.setEmailAddress(emailAddress);
		model.setFirstName(firstName);
		model.setLastName(lastName);
		model.setLoginId(loginId);
		model.setPassword(password);

		if (validateService.isValidateUser(model)) 
		{
			try 
			{
				userDAO.addUserDetails(model);
				response.sendRedirect("Login.jsp");
			} catch (Exception e) 
			{
				out.print(e);
			}
		} 
		else 
		{
            out.print("\nuser already exist");
            response.sendRedirect("Register.jsp");
		}
	}
}
