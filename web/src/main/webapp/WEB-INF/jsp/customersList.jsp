<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	<div>
		<div class="header">
			<%@ include file="/WEB-INF/jsp/elements/_header.jsp"%>
		</div>
		<div class="container">

			<table>
				<tr>
					<th>Title</th>
					<th>First name</th>
					<th>Last name</th>
					<th>Customer type</th>
					<th>Last modification</th>
				</tr>
				<c:forEach items="${customers}" var="item">
					<tr>
						<td>${item.title}</td>
						<td><a href="customerInfo?customerId=${item.id}">${item.firstName}</a></td>
						<td><a href="customerInfo?customerId=${item.id}">${item.lastName}</a></td>
						<td>${item.customerType.customerTypeCaption}</td>
						<td><fmt:formatDate value="${item.modifiedWhen}"
								pattern="dd.MM.yy HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</table>
			<div class="pagination">
				<%@ include file="/WEB-INF/jsp/elements/_pagination.jsp"%>
			</div>
		</div>

	</div>
</body>
</html>