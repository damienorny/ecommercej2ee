<%@include file="./header.jsp" %>
    <div class="well">
        <form action="MainServlet.java" method="POST" class="fos_user_registration_register form-horizontal">
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
                <label class="col-sm-3 control-label" for="email">Email</label>
                <div class="col-sm-4">
                    <input class="form-control" type="text" id="email" name="email" required="required" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="mdp">Mot de passe</label>
                <div class="col-sm-4">
                    <input class="form-control" type="text" id="mdp" name="mdp" required="required" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="mdpV">V�rification du mot de passe</label>
                <div class="col-sm-4">
                    <input class="form-control" type="text" id="mdpV" name="mdpV" required="required" />
                </div>
            </div>
            <div>
                <input type="submit" value="S'enregistrer" />
            </div>
        </form>
    </div>
<%@include file="./footer.jsp" %>