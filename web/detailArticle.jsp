<%@include file="./header.jsp" %>
<div class="well col-md-8">
    <h1>${article.nom}</h1>
    <img width="100%" src="${article.srcImage}">
    ${article.description}
</div>
<div class="well col-md-3 col-md-offset-1">
    <h2>${article.prix} &euro; <small>prix unitaire</small></h2>
    <form action="#" method="POST" class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-3 control-label" for="qu">Quantit�</label>
            <div class="col-sm-4">
                <input class="form-control" type="number" id="quantite" name="quantite" required="required" min="1" max="5000" value="1"/>
            </div>
        </div>
        <div>
            <input type="hidden" name="page" value ="detail"/>
            <input type="hidden" name="idArticle" value="${article.id}"/>
            <input type="submit" value="Mettre au panier" class="btn btn-default btn-primary"/>
            
            
        </div>
       
    </form>
</div>
<%@include file="./footer.jsp" %>