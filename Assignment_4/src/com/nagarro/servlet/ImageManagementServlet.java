package com.nagarro.servlet;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.tomcat.util.http.fileupload.FileItemFactory;
//import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.model.ImageModel;
import com.nagarro.model.LoginModel;
import com.nagarro.model.RegisterModel;
import com.nagarro.util.HibernateUtil;

//import javassist.bytecode.Descriptor.Iterator;

@WebServlet("/ImageManagementServlet")
public class ImageManagementServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("hello");
		Session session = HibernateUtil.getSessionFactory().openSession();
		// RequestDispatcher requestDispatcher;
		final String UPLOAD_DIRECTORY = "C:\\Users";
		HttpSession httpSession = request.getSession();
		if (ServletFileUpload.isMultipartContent(request)) 
		{
			// Create a factory for disk-based file items
			FileItemFactory factory = new DiskFileItemFactory();
			//HttpSession httpSession = request.getSession();

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// set the maximum upload size to 1000 kB
			upload.setSizeMax(1000 * 1024);

			try {
				List<FileItem> multiparts = upload.parseRequest(request);

				if(!multiparts.isEmpty())
				{
					System.out.println("in image upload");
				for (FileItem item : multiparts) {
					String name;
					if (!item.isFormField()) {
						name = new File(item.getName()).getName();
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));

						ImageModel imageModel = new ImageModel();
						LoginModel loginModel = new LoginModel();
						imageModel.setFileName(name);
						imageModel.setFilePath(UPLOAD_DIRECTORY + File.separator + name);
						imageModel.setFileSize(new File(UPLOAD_DIRECTORY + File.separator + name).length());
						imageModel.setLoginId((String) httpSession.getAttribute("loginId"));

						session.beginTransaction();
						session.save(imageModel);
						session.getTransaction().commit();
					}
				}
			}
				else
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("Imagemanagement.jsp");
					dispatcher.forward(request, response);
				}
				// File uploaded successfully
				request.setAttribute("message", "File Uploaded Successfully");

			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			request.setAttribute("message", "Sorry this Servlet only handles file upload request");
		}
	
		/*
		 * Criteria criteria = session.createCriteria(RegisterModel.class);
		 * criteria.add(Restrictions.isNotEmpty("loginId")); List<ImageModel>
		 * lis=criteria.list();
		 */
		/*Query query = session.createQuery("from ImageModel");
		List imageList = query.list();
		*/
		Criteria criteria = session.createCriteria(ImageModel.class);
		criteria.add(Restrictions.eq("loginId", (String) httpSession.getAttribute("loginId")));
		
		List <ImageModel> imageList = criteria.list();
		System.out.println("size of list is"+imageList.size());
		
		request.setAttribute("imageList", imageList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Imagemanagement.jsp");
		dispatcher.forward(request, response);
		session.close();
        
		/*
		 * query = session.createQuery("from imageModel"); listOfimageModel =
		 * query.list();
		 * 
		 * request.setAttribute("list", listOfimageModel);
		 * request.getRequestDispatcher("ImageManagement.jsp").forward(request,
		 * response); session.close();
		 */

	}
}

