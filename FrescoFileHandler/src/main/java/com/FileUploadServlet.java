package com;
	
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	int maxFileSize = 5000 * 1024;
	int maxMemSize = 5000 * 1024;
	File file;

	/***** This Method Is Called By The Servlet Container To Process A 'POST' Request *****/
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*write your code here*/
		String contentType = request.getContentType();
		if ((contentType.indexOf("multipart/form-data") >= 0)) 
		{
		      DiskFileItemFactory factory = new DiskFileItemFactory();
		      // maximum size that will be stored in memory
		      factory.setSizeThreshold(maxMemSize);
		      
		      // Location to save data that is larger than maxMemSize.
		      factory.setRepository(new File("C:\\temp"));

		      // Create a new file upload handler
		      ServletFileUpload upload = new ServletFileUpload(factory);
		      
		      // maximum file size to be uploaded.
		      upload.setSizeMax( maxFileSize );
		      
		      try { 
		          // Parse the request to get file items.
		          List fileItems = upload.parseRequest(request);

		          // Process the uploaded file items
		          Iterator i = fileItems.iterator();
		          String filePath="C:\\Stream software\\Software - Backup\\apache-tomcat-9.0.7\\webapps\\data\\";
		          
		          while ( i.hasNext () )
		          {
		             FileItem fi = (FileItem)i.next();
		             if ( !fi.isFormField () ) 
		             {
		                // Get the uploaded file parameters
		                String fieldName = fi.getFieldName();
		                String fileName = fi.getName();
		                boolean isInMemory = fi.isInMemory();
		                long sizeInBytes = fi.getSize();
		             
		                // Write the file
		                if( fileName.lastIndexOf("\\") >= 0 ) 
		                {
		                   file = new File( filePath + 
		                   fileName.substring( fileName.lastIndexOf("\\"))) ;
		                } else {
		                   file = new File( filePath + 
		                   fileName.substring(fileName.lastIndexOf("\\")+1)) ;
		                }
		                fi.write( file ) ;
		             }
		          }
		       } catch(Exception ex) {
		          System.out.println(ex);
		       }
		      
		      response.sendRedirect(request.getContextPath()+"/fileuploadResponse.jsp");
		}
	}

	
}