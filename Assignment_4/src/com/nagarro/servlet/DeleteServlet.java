package com.nagarro.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.model.ImageModel;
import com.nagarro.util.HibernateUtil;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	//doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
	    Criteria criteria = session.createCriteria(ImageModel.class);
		criteria.add(Restrictions.eq("id", id));
	
        System.out.println("delete id isssssss");
     	System.out.println(id);
		List<ImageModel> deleteList=criteria.list();
		
        Object entity =session.load(ImageModel.class, deleteList.get(0).getId());
	    session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		RequestDispatcher dispatcher= request.getRequestDispatcher("/ImageManagementServlet");
		dispatcher.forward(request, response);
		session.close();
	}

}
