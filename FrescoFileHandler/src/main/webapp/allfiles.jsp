<%@page import="java.util.List"%>
<%@page import="com.UploadDetail"%>
<%@page import="java.io.File"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--Write your code here-->
    <body>
    <%
   List<File> files=(List<File>)request.getAttribute("files");
    %>
    <div style="text-align:center">
	<h1>Uploaded Files</h1>
	<table style="margin-left:auto;margin-right:auto;"">
	<tr>
		<th>File Name</th>
		<th>File Size</th>
		<th>Action</th>
	</tr>
	<%for(File x:files){ %>
	<tr>
		<td><%=x.getName() %></td>
		<th><%=x.length() %></th>
		<th><a href="<%=request.getContextPath() %>/downloadServlet?fileName=<%=x.getName()%>">Download</a></th>
	</tr>
	<%} %>	
	</table><br/>
	<a href="<%=request.getContextPath() %>/index.jsp">Home</a>

	</div>
	</body>
</html>