/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
        if(session.getAttribute("ecommerce") == null)
        {
            ecommerceBean = new EcommerceBean();
            session.setAttribute("ecommerce", ecommerceBean);
        }
        else
        {
            ecommerceBean = (EcommerceBean) session.getAttribute("ecommerce");
        }
        ArrayList<Article> listeArticles = ecommerceBean.getAllArticles();
        request.setAttribute("listeArticles", listeArticles);
        RequestDispatcher view = request.getRequestDispatcher("/accueil.jsp");
        view.forward(request, response);
    }
    
    protected void processGetRequestDetailArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        EcommerceBean ecommerceBean = (EcommerceBean) session.getAttribute("ecommerce");
       
        Long id = Long.parseLong(request.getParameter("articleId"));
        Article article = ecommerceBean.getArticleById(id);
        
        request.setAttribute("article", article);
        RequestDispatcher view = request.getRequestDispatcher("/detailArticle.jsp");
        view.forward(request, response);
    }
    
    protected void processGetRequestConnexion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        RequestDispatcher view = request.getRequestDispatcher("/connexion.jsp");
        view.forward(request, response);
    }
    
    protected void processGetRequestInscription(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        RequestDispatcher view = request.getRequestDispatcher("/register.jsp");
        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
    }

    protected void processPostRequestConnexion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        processGetRequestIndex(request, response);
    }
    
    protected void processPostRequestInscription(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        EcommerceBean ecommerceBean = (EcommerceBean) session.getAttribute("ecommerce");
        
        String mdp = request.getParameter("mdp");
        String mdpV = request.getParameter("mdpV");
        if(mdp.equals(mdpV))
        {
            String email = request.getParameter("email");
            if(ecommerceBean.isUserRegistered(email))
            {
                RequestDispatcher view = request.getRequestDispatcher("/register.jsp");//Déjà enregistré
                view.forward(request, response);
            }
            else
            {
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String adresse = request.getParameter("adresse");
                ecommerceBean.addUser(nom, prenom, email, mdp, adresse);
            }
            
            processGetRequestIndex(request, response);
        }
        else
        {
            RequestDispatcher view = request.getRequestDispatcher("/register.jsp");//Mot de passe différents
            view.forward(request, response);
        }
    }
    
    protected void processPostRequestDetailArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        processGetRequestIndex(request, response);
    }
    
    /**
     * Handles the HTTP <code>POST</code> method.
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
        if(page.equals("1"))
        {
            processPostRequestDetailArticle(request, response);
        }
        else if(page.equals("2"))
        {
            processPostRequestInscription(request, response);
        }
        else if(page.equals("3"))
        {
            processPostRequestConnexion(request, response);
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
