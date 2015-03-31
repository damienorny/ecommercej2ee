<%@include file="./header.jsp" %>
<div class="well col-md-8">
    <div class="list-group">
        <c:choose>
            <c:when test="${cart.taillePanier == 0}">
                <div class="list-group-item">
                    <h4 class="list-group-item-heading">Votre panier est vide pour le moment.</h4>
                </div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${cart.cart}" var="article">
                    <div class="list-group-item">
                        <h4 class="list-group-item-heading">${article.key.nom} <span class="badge">${article.key.prix} &euro;</span></h4>

                        <form class="form-inline" method="POST">
                            <input type="hidden" name="page" value ="retirerArticle"/>
                            <input type="hidden" name="idArticle" value="${article.key.id}"/>
                            <input type="hidden" name="quantite" value="0"/>
                            <input class="close btn" type="submit"   value="&times;"/>
                        </form>
                        <form class="form-inline" method="POST" >
                            <input type="hidden" name="page" value ="retirerArticle"/>
                            <input type="hidden" name="idArticle" value="${article.key.id}"/>
                            <div class="input-group">
                                <div class="input-group-addon">Quantité</div>
                                <input class="form-control" type="number" id="quantite" name="quantite" required="required" min="1" max="5000" value="${article.value}"/>
                                <span class="input-group-btn">
                                    <input type="submit" value="Modifier" class="btn btn-default btn-primary"/>
                                </span>
                            </div>
                        </form>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        
    </div>
</div>
<div class="well col-md-3 col-md-offset-1">
    <h2>${cart.valuePanier} &euro; <small>prix total</small></h2>
    <a class="btn btn-primary" href="index?action=confirmerCommande" <c:if test="${cart.taillePanier == 0}">disabled="disabled"</c:if>>Finaliser ma commande</a>
</div>
<%@include file="./footer.jsp" %>