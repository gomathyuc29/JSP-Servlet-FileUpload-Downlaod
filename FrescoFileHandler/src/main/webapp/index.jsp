<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!--Write your code here-->
<body>
	<h1 style="text-align: center;">File Upload</h1>
	<div style="text-align: center;">
	<form action="fileUploadServlet" method="post"
		enctype="multipart/form-data">
		Upload File  : <input type="file" id="fileAttachment" name="fileAttachment" size="50" /> Please Upload A File <br /> 
		<input type="submit" id="uploadBtn" value="Upload" />
	</form>
	</div>
</body>
</html>
