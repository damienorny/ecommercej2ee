<%@include file="./header.jsp" %>
<c:forEach items="${listeArticles}" var="article">
   <c:out value="${article.nom}"/>
   <c:out value="${article.description}"/>
   <c:out value="${article.prix}"/>
   <br/>
</c:forEach>
<%@include file="./footer.jsp" %>