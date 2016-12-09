<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		Modify customer

		<form
			action="${pageContext.servletContext.contextPath}/modifyCustomer"
			method="get">
			<table>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title" pattern="[a-zA-Z]{1,3}"
						value="${customer.title}" /></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName"
						pattern="^[a-zA-Z]{3,50}" value="${customer.firstName}" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName"
						pattern="^[a-zA-Z]{4,50}" value="${customer.lastName}" /></td>
				</tr>
				<tr>
					<td>Type</td>
					<td><select name="typeId">
							<c:forEach items="${customerTypes}" var="item">
								<c:choose>
									<c:when test="${customer.customerType.id == item.id}">
										<option selected value="${item.id}">${item.customerTypeCaption}</option>
									</c:when>
									<c:otherwise>
										<option value="${item.id}">${item.customerTypeCaption}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select></td>
				</tr>

			</table>
			<input type="hidden" name="customerId" value="${customer.id}"/>
			<input type="submit" value="Save modification"/>
		</form>
</body>
</html>