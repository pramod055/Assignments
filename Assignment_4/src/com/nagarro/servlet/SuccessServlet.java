package com.nagarro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SuccessServlet extends HttpServlet
{
     protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServerException, IOException
     {
    	 PrintWriter writer =response.getWriter();
    	 writer.println("\nDetails added Successfully");
    	 response.sendRedirect("Login.jsp");
     }
      
             
}
