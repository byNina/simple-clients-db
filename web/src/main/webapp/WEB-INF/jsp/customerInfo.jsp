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
	<div class="header">
		<%@ include file="/WEB-INF/jsp/elements/_header.jsp"%>
	</div>
	<div class="container">
		<h3>Customer info:</h3>
		<p>${customer.title}${customer.firstName}${customer.lastName}
			${customer.customerType.customerTypeCaption}</p>
		<form
			action="${pageContext.servletContext.contextPath}/toModifyCustomer"
			method="get">
			<input type="hidden" name="customerId" value="${customer.id}" /> <input
				type="submit" value="Modify" />
		</form>
		<form
			action="${pageContext.servletContext.contextPath}/deleteCustomer"
			method="get">
			<input type="hidden" name="customerId" value="${customer.id}" /> <input
				type="submit" value="Delete" />
		</form>

	</div>

</body>
</html>