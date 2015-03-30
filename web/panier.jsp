<%@include file="./header.jsp" %>
<div class="well col-md-8">
    <c:forEach items="${cart.cart}" var="article">
        <a href="index?action=detailArticle&articleId=${article.key.id}" class="list-group-item ">
            <h4 class="list-group-item-heading">${article.key.nom} <span class="badge">${article.key.prix} &euro;</span> <span class="badge">Qté ${article.value}</span></h4>
            <p class="list-group-item-text">${article.key.description}</p>
        </a>
    </c:forEach>
</div>
<div class="well col-md-3 col-md-offset-1">
    <h2>${article.prix} &euro; <small>prix unitaire</small></h2>
    <a class="btn btn-primary" href="#">Finaliser ma commande</a>
</div>
<%@include file="./footer.jsp" %>