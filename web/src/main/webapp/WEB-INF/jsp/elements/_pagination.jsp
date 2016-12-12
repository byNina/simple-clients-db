 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 

<c:if test="${pagination.page>2}">
    <a href="findCustomer?page=${pagination.page-2}&firstName=${firstName}&lastName=${lastName}">${pagination.page-2}</a>
</c:if>
<c:if test="${pagination.page>1}">
    <a href="findCustomer?paginationPage=${pagination.page-1}&firstName=${firstName}&lastName=${lastName}">${pagination.page-1}</a>
</c:if>
<a class="active" href="findCustomer?paginationPage=${pagination.page}&firstName=${firstName}&lastName=${lastName}">${pagination.page}</a>
<c:if test="${pagination.page<(pagination.pages)}">
    <a href="findCustomer?paginationPage=${pagination.page+1}&firstName=${firstName}&lastName=${lastName}">${pagination.page+1}</a>
</c:if>
<c:if test="${(pagination.page+1)<(pagination.pages)}">
    <a href="findCustomer?paginationPage=${pagination.page+2}&firstName=${firstName}&lastName=${lastName}">${pagination.page+2}</a>
</c:if>
<c:if test="${(pagination.page+2)<(pagination.pages)}">
    <span>...${pagination.pages}</span>
</c:if>
