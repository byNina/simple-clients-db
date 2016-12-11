<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Clients DB</title>
<link
	href="${pageContext.servletContext.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
	<div >
		<div class="header">
			<%@ include file="/WEB-INF/jsp/elements/_header.jsp"%>
		</div>
		<div class="container">
			<h3>Welcome to "Simple Client Database".</h3>
			<span class="success">${successMessage}</p>
			<span class="error">${errorMessage}</p>
			<p>To begin your work please:</p>
			 <p> - to create a new customer press button "Create a new customer"</p>
			 <p> - to find an existing customer fill form with first name and last name (or only one of them) and press "Find"</p>
			 <p> - to find last 10 modified customers press "Find" without filling form </p>
			
		</div>
	</div>



</body>
</html>