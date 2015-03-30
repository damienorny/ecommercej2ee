<%@include file="./header.jsp" %>
<div class="list-group">
<c:forEach items="${listeArticles}" var="article">
    <a  href="index?action=detailArticle&articleId=${article.id}" class="list-group-item ">
        <img  src="${article.srcImage}"  style="width:200px;height:128px">
        <h4 class="list-group-item-heading">${article.nom} <span class="badge">${article.prix} &euro;</span></h4>
      
    </a>
</c:forEach>
</div>
<%@include file="./footer.jsp" %>