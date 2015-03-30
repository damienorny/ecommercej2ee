<%@include file="./header.jsp" %>
<div class="well">
    <h2>Confirmez votre adresse</h2>
        <form action="index" method="POST" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-3 control-label" for="adresse">Adresse</label>
                <div class="col-sm-4">
                    <textarea class="form-control" id="adresse" name="adresse" required="required"/>${user.adresse}</textarea>
                </div>
            </div>
            <div class="col-sm-offset-3">
                <input type="hidden" name="page" value ="commandeValidee"/>
                <input class="btn btn-primary" type="submit" value="Valider et confirmer ma commande" />
            </div>
        </form>
    </div>
<%@include file="./footer.jsp" %>