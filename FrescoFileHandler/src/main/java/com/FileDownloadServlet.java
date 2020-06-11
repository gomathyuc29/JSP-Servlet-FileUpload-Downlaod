package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownloadServlet
 */
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static int BUFFER_SIZE = 1024 * 100;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		handleRequest(request, response);
	}
	
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*WRITE YOUR CODE HERE*/
		PrintWriter pw=response.getWriter();
		String filename = request.getParameter("fileName");  
		  String filepath = "C:\\Stream software\\Software - Backup\\apache-tomcat-9.0.7\\webapps\\data\\";   
		  response.setContentType("APPLICATION/OCTET-STREAM");   
		  response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
		  
		  java.io.FileInputStream fileInputStream=new java.io.FileInputStream(filepath + filename);  
		            
		  int i;   
		  while ((i=fileInputStream.read()) != -1) {  
		    pw.write(i);   
		  }   
		  fileInputStream.close();   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
