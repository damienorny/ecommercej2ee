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
    <form action="#" method="POST" class="fos_user_registration_register form-horizontal">
        <div class="form-group">
            <label class="col-sm-3 control-label" for="qu">Quantité</label>
            <div class="col-sm-4">
                <input class="form-control" type="number" id="quantite" name="quantite" required="required" min="1" value="1"/>
            </div>
        </div>
        <div>
            <input type="hidden" name="page" value ="1"/>
            <input type="hidden" name="idArticle" value="${article.id}"/>
            <input type="submit" value="Mettre au panier" class="btn btn-default btn-primary"/>
        </div>
    </form>
</div>
<%@include file="./footer.jsp" %>