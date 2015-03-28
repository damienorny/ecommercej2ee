<%@include file="./header.jsp" %>
<div class="container">
    <div class="well col-md-8">
        <h1>${article.nom}</h1>
            
        ${article.description}
    </div>
    <div class="well col-md-3 col-md-offset-1">
        Prix: ${article.prix} &euro;
        <form action="#" method="POST" class="fos_user_registration_register form-horizontal">
            <div class="form-group">
                <label class="col-sm-3 control-label" for="qu">Quantité</label>
                <div class="col-sm-4">
                    <input class="form-control" type="number" id="qu" name="qu" required="required" min="1" value="1"/>
                </div>
            </div>
            <div>
                <input type="hidden" name="page" value ="1"/>
                <input type="submit" value="Mettre au panier" class="btn btn-default btn-primary"/>
            </div>
        </form>
    </div>
</div>
<%@include file="./footer.jsp" %>