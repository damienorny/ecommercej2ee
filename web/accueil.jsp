<%@include file="./header.jsp" %>
<div class="list-group">
<c:forEach items="${listeArticles}" var="article">
    <a href="index?action=detailArticle&articleId=${article.id}" class="list-group-item ">
        <h4 class="list-group-item-heading">${article.nom} <span class="badge">${article.prix} &euro;</span></h4>
        <p class="list-group-item-text">${article.description}</p>
    </a>
</c:forEach>
</div>
<%@include file="./footer.jsp" %>