<%@include file="./header.jsp" %>
    <div class="well">
        <form action="index" method="POST" class="fos_user_registration_register form-horizontal">
            <div class="form-group">
                <label class="col-sm-3 control-label" for="nom">Nom</label>
                <div class="col-sm-4">
                    <input class="form-control" type="text" id="nom" name="nom" required="required" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="prenom">Prenom</label>
                <div class="col-sm-4">
                    <input class="form-control" type="text" id="prenom" name="prenom" required="required" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="adresse">Adresse</label>
                <div class="col-sm-4">
                    <textarea class="form-control" id="adresse" name="adresse" required="required"/></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="email">Email</label>
                <div class="col-sm-4">
                    <input class="form-control" type="text" id="email" name="email" required="required" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="mdp">Mot de passe</label>
                <div class="col-sm-4">
                    <input class="form-control" type="password" id="mdp" name="mdp" required="required" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="mdpV">Vérification du mot de passe</label>
                <div class="col-sm-4">
                    <input class="form-control" type="password" id="mdpV" name="mdpV" required="required" />
                </div>
            </div>
            <div class="col-sm-offset-3">
                <input type="hidden" name="page" value ="2"/>
                <input class="btn btn-primary" type="submit" value="S'enregistrer" />
            </div>
        </form>
    </div>
<%@include file="./footer.jsp" %>