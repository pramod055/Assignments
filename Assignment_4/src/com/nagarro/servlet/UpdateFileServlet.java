package com.nagarro.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.model.ImageModel;
import com.nagarro.model.LoginModel;
import com.nagarro.util.HibernateUtil;

/**
 * Servlet implementation class UpdateFileServlet
 */
@WebServlet("/UpdateFileServlet")
public class UpdateFileServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateFileServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		// doGet(request, response);
		Session session = HibernateUtil.getSessionFactory().openSession();
		ImageModel imageModel = new ImageModel();
		LoginModel loginModel = new LoginModel();
		// RequestDispatcher requestDispatcher;
		final String UPLOAD_DIRECTORY = "C:\\Users\\navneetbansal\\workspace\\LoginApplication\\images";
		HttpSession httpSession = request.getSession();

		String id= null;
		if (ServletFileUpload.isMultipartContent(request)) 
		{
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(1000 * 1024);

			try {
				List<FileItem> multiparts = upload.parseRequest(request);
				if (!multiparts.isEmpty()) 
				{
					System.out.println("size of multipart    "+multiparts.toString());
					for (FileItem item : multiparts) 
					{
						String name;	
						System.out.println(item.isFormField());
						if (!item.isFormField()) 
						{
							System.out.println("in update file");
							name = new File(item.getName()).getName();
							item.write(new File(UPLOAD_DIRECTORY + File.separator + name));

							imageModel.setFileName(name);
							imageModel.setFilePath(UPLOAD_DIRECTORY + File.separator + name);
							imageModel.setFileSize(new File(UPLOAD_DIRECTORY + File.separator + name).length());
							imageModel.setLoginId((String) httpSession.getAttribute("loginId"));
							/*
							 * session.beginTransaction();
							 * session.save(imageModel);
							 * session.getTransaction().commit();
							 */
							/*
							 * Criteria
							 * criteria=session.createCriteria(ImageModel.class)
							 * ; criteria.add(Restrictions.eq("loginId",(String)
							 * httpSession.getAttribute("loginId")));
							 */
							System.out.println("................new file details..............");
							System.out.println(imageModel.getFileName());
							System.out.println(imageModel.getFilePath());
							System.out.println(imageModel.getFileSize());
							System.out.println(imageModel.getLoginId());

						} else {
							if (item.getFieldName().equals("imageid")) 
							{
							    id = item.getString();
								System.out.println("image id is");
								System.out.println(id);
							}
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else 
		{
			request.setAttribute("message", "Sorry this Servlet only handles file upload request");
		}
		
		int id1;
		id1=Integer.parseInt(id);
		System.out.println("integer id is"+ id1);
		
		 Criteria criteria = session.createCriteria(ImageModel.class);
		 criteria.add(Restrictions.eq("id", id1));
	
	     List<ImageModel> editList=criteria.list();
	     
	     System.out.println("list size is "+editList.get(0).getFileName());
	     	
	   // Object entity =session.load(ImageModel.class, editList.get(0).getId());
	    session.beginTransaction();
		//session.update(entity);
	    Query query = session.createQuery("UPDATE ImageModel SET fileName=:fileName,filePath=:filePath,fileSize=:fileSize,loginId=:loginId  where id= " + id1);
		query.setParameter("fileName", imageModel.getFileName());
		query.setParameter("filePath", imageModel.getFilePath());
		query.setParameter("fileSize", imageModel.getFileSize());
		query.setParameter("loginId", imageModel.getLoginId());
		query.executeUpdate();
		session.getTransaction().commit();
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("/temp.jsp");
		dispatcher.forward(request, response);
		session.close();
	}

}
