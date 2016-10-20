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
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
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

		Session session = HibernateUtil.getSessionFactory().openSession();
        int id = Integer.parseInt(request.getParameter("id"));
        
        System.out.println("id is....");
        System.out.println(id);
        Criteria criteria =session.createCriteria(ImageModel.class);
        criteria.add(Restrictions.eq("id", id));
        
        
     //   System.out.println("criteria size");
       // System.out.println(criteria.list().size());
        List <ImageModel> editList=criteria.list();
        
        System.out.println("size........");
        System.out.println(editList.size());
        
        /*
        ImageModel imageModel = new ImageModel();
        imageModel.setFileName(editList.get(0).getFileName());
        imageModel.setFilePath(editList.get(0).getFilePath());
        imageModel.setFileSize(editList.get(0).getFileSize());
        imageModel.setId(Integer.parseInt(request.getParameter("id")));
        imageModel.setLoginId(editList.get(0).getLoginId());*/
        /*
        String fileName=editList.get(0).getFileName();
        String filePath=editList.get(0).getFilePath();
        Long fileSize=editList.get(0).getFileSize();
        String loginId= editList.get(0).getLoginId();*/
        
        
        request.setAttribute("imageModel", editList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Edit.jsp");
		dispatcher.forward(request, response);
		session.close();
		

	}

}
