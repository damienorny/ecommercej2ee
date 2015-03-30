<%@include file="./header.jsp" %>
<div class="well col-md-8">
    <c:forEach items="${cart.cart}" var="article">
        <a href="index?action=detailArticle&articleId=${article.key.id}" class="list-group-item ">
            <h4 class="list-group-item-heading">${article.key.nom} <span class="badge">${article.key.prix} &euro;</span> <span class="badge">Qté ${article.value}</span></h4>
           
            
        </a>
            <form  method="POST" >
            <input class="form-control" type="number" id="quantite" name="quantite" required="required" min="1" value="1"/>
            <input type="hidden" name="page" value ="retirerArticle"/>
            <input type="hidden" name="idArticle" value="${article.key.id}"/>
            <input type="submit" value="Modifier" class="btn btn-default btn-primary"/>
            </form>
            <form method="POST" >  
            <input type="hidden" name="page" value ="retirerArticle"/>
            <input type="hidden" name="idArticle" value="${article.key.id}"/>
            <input type="hidden" name="quantite" value="0"/>
            <input type="submit" value="Retirer du panier" class="btn btn-default btn-primary"/>
            </form>
    </c:forEach>
</div>
<div class="well col-md-3 col-md-offset-1">
    <h2>${article.prix} &euro; <small>prix unitaire</small></h2>
    <a class="btn btn-primary" href="#">Finaliser ma commande</a>
</div>
<%@include file="./footer.jsp" %>