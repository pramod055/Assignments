package com.nagarro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.model.ImageModel;
import com.nagarro.model.LoginModel;
import com.nagarro.service.LoginService;
import com.nagarro.util.HibernateUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String loginId;
		String password;
		loginId=request.getParameter("loginId");
		Session session1 = HibernateUtil.getSessionFactory().openSession();

		HttpSession session = request.getSession();
		session.setAttribute("loginId", loginId);
		password=request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		LoginModel loginModel= new LoginModel();
		loginModel.setLoginId(loginId);
		loginModel.setPassword(password); 
		
		LoginService loginService =new LoginService();
		//System.out.println("" + loginService.userExists(loginModel));
		
		if(loginService.userExists(loginModel))
		{
			//System.out.println("he");
			out.println("login successfully");
			/*
			Query query = session1.createQuery("from ImageModel");
			List imageList = query.list();
			*/
			Criteria criteria = session1.createCriteria(ImageModel.class);
			criteria.add(Restrictions.eq("loginId", (String)session.getAttribute("loginId")));
			List <ImageModel> imageList = criteria.list();
			request.setAttribute("imageList", imageList);
			RequestDispatcher dispatcher= request.getRequestDispatcher("Imagemanagement.jsp");
			dispatcher.forward(request, response);

			//response.sendRedirect("Imagemanagement.jsp");
		}
		else
		{
			out.println("loginId or password is wrong");
			response.sendRedirect("Login.jsp");
		}
				
	}

}
