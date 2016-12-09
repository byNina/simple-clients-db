<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Clients DB</title>
<link href="${pageContext.servletContext.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"
          media="screen"/>
</head>
<body>
	<div class="header">
		<%@ include file="/WEB-INF/jsp/elements/_header.jsp"%>
	</div>
	<div class="container">
		Main page 
		<p>${successMessage}</p>
		<p>${errorMessage}</p>
		<p></p>
		<a href="test"> Test</a>
	</div>



</body>
</html>