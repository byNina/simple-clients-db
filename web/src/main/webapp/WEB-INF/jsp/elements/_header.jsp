
Header
<form action="${pageContext.servletContext.contextPath}/toCreateNewCustomer" method="get">
<input type="submit" value="Create a new customer">
</form>
<p>
<form action="${pageContext.servletContext.contextPath}/findCustomer" method="get">
<input type="text" name="firstName" value=""/>
<input type="text" name="lastlName" value=""/>
<input type="submit" value="Find customer">
</form>