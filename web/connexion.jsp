<%@include file="./header.jsp" %>
    <div class="well">
        <form action="index" method="POST" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-3 control-label" for="email">Email</label>
                <div class="col-sm-4">
                    <input class="form-control" type="email" id="email" name="email" required="required" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="mdp">Mot de passe</label>
                <div class="col-sm-4">
                    <input class="form-control" type="password" id="mdp" name="mdp" required="required" />
                </div>
            </div>
            <div class="col-md-offset-3">
                <input type="hidden" name="page" value ="connexion"/>
                <input class="btn btn-primary" type="submit" value="Se connecter" />
            </div>
        </form>
    </div>
<%@include file="./footer.jsp" %>