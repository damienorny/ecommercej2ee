/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.*;

/**
 *
 * @author damien
 */
public class MainServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processGetRequestIndex(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        EcommerceBean ecommerceBean;
        HttpSession session = request.getSession();
        //Lors de la première connexion au site, on instancie un objet EcommerceBean
        if(session.getAttribute("ecommerce") == null)
        {
            ecommerceBean = new EcommerceBean();
            session.setAttribute("ecommerce", ecommerceBean);
        }
        else
        {
            ecommerceBean = (EcommerceBean) session.getAttribute("ecommerce");
        }
        //Accueil.jsp attend un paramètre de type ArrayList ayant pour nom listeArticles
        ArrayList<Article> listeArticles = ecommerceBean.getAllArticles();
        request.setAttribute("listeArticles", listeArticles);
        //On affiche la vue correspondante
        RequestDispatcher view = request.getRequestDispatcher("/accueil.jsp");
        view.forward(request, response);
    }
    
    protected void processGetRequestDetailArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //On récupère l'objet session
        HttpSession session = request.getSession();
        EcommerceBean ecommerceBean = (EcommerceBean) session.getAttribute("ecommerce");
        
        Long id = Long.parseLong(request.getParameter("articleId"));
        //On demande au EcommerceBean de retourner un objet Article en fonction de son ID
        Article article = ecommerceBean.getArticleById(id);
        
        //detailarticle.jsp attend un paramètre de type Article nommé article
        request.setAttribute("article", article);
        RequestDispatcher view = request.getRequestDispatcher("/detailArticle.jsp");
        view.forward(request, response);
    }
    
    protected void processGetRequestConnexion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //En tant que contrôleur, MainServlet s'occupe parfois de simplement renvoyer une vue
        RequestDispatcher view = request.getRequestDispatcher("/connexion.jsp");
        view.forward(request, response);
    }
    
    protected void processGetRequestInscription(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        RequestDispatcher view = request.getRequestDispatcher("/register.jsp");
        view.forward(request, response);
    }
    
    protected void processGetRequestDeconnexion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        //On retire les paramètres de session pour déconnecter l'utilisateur
        session.removeAttribute("isUserRegistered");
        session.removeAttribute("user");
        session.removeAttribute("nextPage");
        //La ligne ci dessous permet d'afficher un message vert avec le texte déconnexion réussie sur la prochaine vue
        request.setAttribute("msgSuccess", "Déconnexion réussie");
        processGetRequestIndex(request, response);
    }
    
    protected void processGetRequestPanier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        RequestDispatcher view = request.getRequestDispatcher("/panier.jsp");
        view.forward(request, response);
    }
    
    protected void processGetRequestCommande(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Boolean isUserRegistered = (Boolean) session.getAttribute("isUserRegistered");
        //Si l'utilisateur est enregistré, on passe à la confirmation d'adresse, sinon il doit se connecté
        if(isUserRegistered != null && isUserRegistered == true)
        {
            RequestDispatcher view = request.getRequestDispatcher("/confirmer.jsp");
            view.forward(request, response);
        }
        else
        {
            session.setAttribute("nextPage", "validation");
            processGetRequestConnexion(request, response);
        }
    }
    
    
    
    /**
     * Récupère les requêtes de type GET et exécute la bonne méthode en fonction du paramètre nommé action
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null)
        {
            processGetRequestIndex(request, response);
        }
        else if(action.equals("detailArticle"))
        {
            processGetRequestDetailArticle(request, response);
        }
        else if(action.equals("connexion"))
        {
            processGetRequestConnexion(request, response);
        }
        else if(action.equals("inscription"))
        {
            processGetRequestInscription(request, response);
        }
        else if(action.equals("accueil"))
        {
            processGetRequestIndex(request, response);
        }
        else if(action.equals("deconnexion"))
        {
            processGetRequestDeconnexion(request, response);
        }
        else if(action.equals("panier"))
        {
            processGetRequestPanier(request, response);
        }
        else if(action.equals("confirmerCommande"))
        {
            processGetRequestCommande(request, response);
        }
    }

    protected void processPostRequestConnexion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        EcommerceBean ecommerceBean = (EcommerceBean) session.getAttribute("ecommerce");
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");
        //Cette fonction renvoie une instance de la classe User si l'authentification a réussi, null sinon
        User user = ecommerceBean.authenticateUser(email, mdp);
        if(user == null)
        {
            request.setAttribute("msgError", "Identifiants invalides");
            RequestDispatcher view = request.getRequestDispatcher("/connexion.jsp");
            view.forward(request, response);
        }
        else
        {
            request.setAttribute("msgSuccess", "Connexion réussie");
            session.setAttribute("isUserRegistered", true);
            session.setAttribute("user", user);
            //Permet de savoir si l'on renvoie sur l'accueil ou sur la page de validation de commande
            if(session.getAttribute("nextPage") != null && session.getAttribute("nextPage").equals("validation"))
            {
                session.removeAttribute("nextPage");
                processGetRequestCommande(request, response);
            }
            else
            {
                processGetRequestIndex(request, response);
            }
            
        }
    }
    

    protected void processPostRequestInscription(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        EcommerceBean ecommerceBean = (EcommerceBean) session.getAttribute("ecommerce");
        
        String mdp = request.getParameter("mdp");
        String mdpV = request.getParameter("mdpV");
        //Vérifie si les deux mots de passe sont identiques
        if(mdp.equals(mdpV))
        {
            String email = request.getParameter("email");
            //Si l'adresse mail existe deja, on propose à l'utilisateur de se connecter
            if(ecommerceBean.isUserRegistered(email))
            {
                //Affiche un message rouge d'erreur en haut de la page
                request.setAttribute("msgError", "Un compte existe déjà pour l'adresse email " + email + ". Connectez-vous !");
                RequestDispatcher view = request.getRequestDispatcher("/connexion.jsp");//Déjà enregistré
                view.forward(request, response);
            }
            else
            {
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String adresse = request.getParameter("adresse");
                User user = ecommerceBean.addUser(nom, prenom, email, mdp, adresse);
                session.setAttribute("isUserRegistered", true);
                session.setAttribute("user", user);
                if(session.getAttribute("nextPage") != null && session.getAttribute("nextPage").equals("validation"))
                {
                    session.removeAttribute("nextPage");
                    processGetRequestCommande(request, response);
                }
                else
                {
                    processGetRequestIndex(request, response);
                }
            }
            request.setAttribute("msgSuccess", "Votre compte a bien été enregistré");
            processGetRequestIndex(request, response);
        }
        else
        {
            request.setAttribute("msgError", "Les mots de passe ne correspondent pas");
            RequestDispatcher view = request.getRequestDispatcher("/register.jsp");
            view.forward(request, response);
        }
    }
     protected void processPostRechercherArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String nomSearch = request.getParameter("nomSearch");
        EcommerceBean ecommerceBean = (EcommerceBean) session.getAttribute("ecommerce");
        Category category=ecommerceBean.getResearchCategory(nomSearch);
        ArrayList<Article> listeArticles;
        if(category!=null)
        {   
           listeArticles = ecommerceBean.getAllArticlesByCategory(category);  
        }        
        else
        { 
            listeArticles = ecommerceBean.getAllArticlesByName(nomSearch);   
        }
        request.setAttribute("listeArticles", listeArticles);
        RequestDispatcher view = request.getRequestDispatcher("/accueil.jsp");
        view.forward(request, response);
     }
     
    protected void processPostRequestDetailArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        EcommerceBean ecommerceBean = (EcommerceBean) session.getAttribute("ecommerce");
        Cart cart = (Cart) session.getAttribute("cart");
        Long idArticle = Long.parseLong(request.getParameter("idArticle"));
        Integer quantite = Integer.parseInt(request.getParameter("quantite"));
        Article article = ecommerceBean.getArticleById(idArticle);
        //Ajout de l'article au panier
        cart.addItem(article, quantite);
        processGetRequestIndex(request, response);
    }
    
    protected void processPostRequestRetirerArticlePanier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        EcommerceBean ecommerceBean = (EcommerceBean) session.getAttribute("ecommerce");
        Cart cart = (Cart) session.getAttribute("cart");
        Long idArticle = Long.parseLong(request.getParameter("idArticle"));
        Integer quantite = Integer.parseInt(request.getParameter("quantite"));
        Article article = ecommerceBean.getArticleById(idArticle);
        //Utilisation de la même méthode pour supprimer du panier et modifier la quantité
        if(quantite==0)
        {
            cart.removeItem(article);
        }
         else
        {
            cart.updateItem(article, quantite);
        }
        processGetRequestPanier(request, response);
      
    }
    
    protected void processPostRequestValider(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        EcommerceBean ecommerceBean = (EcommerceBean) session.getAttribute("ecommerce");
        Cart cart = (Cart) session.getAttribute("cart");
        String adresse = request.getParameter("adresse");
        User user = (User) session.getAttribute("user");
        ecommerceBean.updateAdresseClient(user, adresse);
        user.setAdresse(adresse);
        //On enregistre la commande en Base
        ecommerceBean.enregistreCommande(user, cart);
        //On envoie un mail de confirmation
        Email.envoyerMailSMTP(user, cart);
        //Puis on vide le panier
        cart.clearPanier();
        request.setAttribute("msgSuccess", "Votre commande a été enregistrée, vous recevrez prochainement un mail vous confirmant votre commande!");
        session.removeAttribute("nextPage");
        processGetRequestIndex(request, response);
    }
    
    /**
     * Récupère les requêtes de type POST et execute la bonne méthode en fonction de la valeur du paramètre page
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page.equals("detail"))
        {
            processPostRequestDetailArticle(request, response);
        }
        else if(page.equals("register"))
        {
            processPostRequestInscription(request, response);
        }
        else if(page.equals("connexion"))
        {
            processPostRequestConnexion(request, response);
        }
        else if(page.equals("retirerArticle"))
        {
            processPostRequestRetirerArticlePanier(request, response);
        }
        else if(page.equals("rechercherArticle"))
        {
            processPostRechercherArticle(request, response);
        }
        else if(page.equals("commandeValidee"))
        {
            processPostRequestValider(request, response);
        }
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
