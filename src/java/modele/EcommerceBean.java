/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damien
 */
public class EcommerceBean {
    private Connection connection;
    
    /**
     *Permet de se connecter à la BDD
     */
    private void connectBDD()
    {
        try {
        // This loads an instance of the MySQL Driver.
        // The driver has to be in the classpath.
        Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException cnfe){
            System.out.println("" + cnfe);
        }
        try 
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercej2ee?zeroDateTimeBehavior=convertToNull", "root", "Paradise");
        } 
        catch (SQLException ex) 
        {
            System.out.println("" + ex);
        }
    }
    
    /**
     *Permet de se déconnecter de la BDD
     */
    private void disconnectBDD()
    {
        try 
        {
            connection.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Fonction qui renvoie une liste d'articles
     * @return 
     */
    public ArrayList<Article> getAllArticles()
    {
        ArrayList<Article> liste = new ArrayList();
        connectBDD();
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM article");
            while(rs.next())
            {
                liste.add(new Article(rs.getLong("id_article"), rs.getString("nom_article"), rs.getString("desc_article"), rs.getFloat("prix_article"), rs.getString("src_article")));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
        return liste;
    }
    
    /**
     * Fonction qui renvoie un article selon son id
     * @param id
     * @return 
     */
    public Article getArticleById(Long id)
    {
        Article article = null;
        connectBDD();
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM article WHERE id_article = " + id.toString());
            if(rs.next())
            {
                article = new Article(id, rs.getString("nom_article"), rs.getString("desc_article"), rs.getFloat("prix_article"),rs.getString("src_article"));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
        return article;
    }
    
    /**
     * Fonction qui renvoie tout les articles contenant nomSearch
     * @param nomSearch
     * @return 
     */
    public ArrayList<Article> getAllArticlesByName(String nomSearch)
    {
        ArrayList<Article> liste = new ArrayList<>();
        
        connectBDD();
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `article`");
            while(rs.next())
            {   
                //Permet de chercher une correspondance dans la description et le nom d'un article
                if(rs.getString("nom_article").toLowerCase().contains(nomSearch.toLowerCase()) || rs.getString("desc_article").toLowerCase().contains(nomSearch.toLowerCase()) )
                liste.add(new Article(rs.getLong("id_article"), rs.getString("nom_article"), rs.getString("desc_article"), rs.getFloat("prix_article"), rs.getString("src_article")));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
        return liste;
    }
    
    /**
     * Fonction qui dit si une catégorie existe
     * @param categorie
     * @return 
     */
    public Category getResearchCategory(String categorie)
    {
        Category category = null;
        connectBDD();
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `category`  WHERE `nom_category` = '" + categorie +"'" );
            if(rs.next())
            {
                category = new Category(rs.getLong("id_category"), rs.getString("nom_category"));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
        return category;
    }
    
    /**
     * Fonction qui renvoie les article d'une catégorie
     * @param category
     * @return 
     */
    public ArrayList<Article> getAllArticlesByCategory(Category category)
    {
        ArrayList<Article> liste = new ArrayList<>();
        connectBDD();
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `category_article` LEFT JOIN article ON category_article.id_article = article.id_article WHERE `id_category` = " + category.getId().toString());
            while(rs.next())
            {
                liste.add(new Article(rs.getLong("id_article"), rs.getString("nom_article"), rs.getString("desc_article"), rs.getFloat("prix_article"), rs.getString("src_article")));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
        return liste;
    }
    
    /**
     * Fonction qui permet d'obtenir la catégorie d'un article
     * @param article
     * @return 
     */
    public Category getArticleCategory(Article article)
    {
        Category category = null;
        connectBDD();
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `category_article` LEFT JOIN category ON category_article.id_category = category.id_category WHERE `id_article` = " + article.getId().toString());
            if(rs.next())
            {
                category = new Category(rs.getLong("id_category"), rs.getString("nom_category"));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
        return category;
    }
    
    /**
     * Fonction qui permet de vérifier si un utilisateur est dans la base
     * @param email
     * @return 
     */
    public boolean isUserRegistered(String email)
    {
        boolean reponse;
        connectBDD();
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `client` WHERE `email_client` = '" + email + "'");
            if(rs.next())
            {
                reponse = true;
            }
            else
            {
                reponse = false;                
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
            reponse = false; 
        }
        disconnectBDD();
        return reponse;
    }
    
    /**
     * Fonction qui ajoute un utilisateur
     * @param nom
     * @param prenom
     * @param email
     * @param mdp
     * @param adresse
     * @return 
     */
    public User addUser(String nom, String prenom, String email, String mdp, String adresse)
    {
        User user = null;
        Long key = -1L;
        connectBDD();
        try 
        {
            PreparedStatement maRequette;
            //Demande un retour des champs auto-générés, ici l'id
            maRequette = connection.prepareStatement("INSERT INTO `client`(`nom_client`, `prenom_client`, `email_client`, `mdp_client`, `adresse_client`) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            maRequette.setString(1, nom);
            maRequette.setString(2, prenom);
            maRequette.setString(3, email);
            maRequette.setString(4, mdp);
            maRequette.setString(5, adresse);
            maRequette.execute();
            ResultSet rs = maRequette.getGeneratedKeys();
            rs.next();
            key = rs.getLong(1);//Récupère l'id et le place dans key
            user = new User(key, email, nom, prenom, adresse);
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex); 
        }
        disconnectBDD();
        return user;
    }
    
    /**
     * Fonction qui permet de vérifier la correspondance d'un email et d'un mot de passe
     * @param email
     * @param mdp
     * @return 
     */
    public User authenticateUser(String email, String mdp)
    {
        User user = null;
        connectBDD();
        try 
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `client` WHERE `email_client` = '" + email + "'");
            if(rs.next())
            {
                String mdpClient = rs.getString("mdp_client");
                if(mdpClient.equals(mdp))
                {
                    user = new User(rs.getLong("id_client"), email, rs.getString("nom_client"), rs.getString("prenom_client"), rs.getString("adresse_client"));
                }
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
        return user;
    }
    
    /**
     * Fonction qui permet de mettre à jour l'adresse d'un utilisateur
     * @param client
     * @param adresse 
     */
    public void updateAdresseClient(User client, String adresse)
    {
        connectBDD();
        try 
        {
            PreparedStatement maRequette;
            maRequette = connection.prepareStatement("UPDATE `client` SET `adresse_client` = ? WHERE `client`.`id_client` = ?;");
            maRequette.setString(1, adresse);
            maRequette.setString(2, client.getId().toString());
            maRequette.execute();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
    }
    
    /**
     * Fonction qui ajoute une commande
     * @param user
     * @param cart 
     */
    public void enregistreCommande(User user, Cart cart)
    {
        connectBDD();
        try 
        {
            Long key = -1L;
            
            PreparedStatement maRequette;
            //Demande un retour des champs auto-générés, ici l'id
            maRequette = connection.prepareStatement("INSERT INTO commande (date_commande,prix_commande,id_client) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            maRequette.setString(1, new Date().toString());
            maRequette.setFloat(2, cart.getValuePanier());
            maRequette.setInt(3,user.getId().intValue());
            maRequette.execute();
            ResultSet rs = maRequette.getGeneratedKeys();
            rs.next();
            key = rs.getLong(1);//Récupère l'id et le place dans key
            for(Article article: cart.getCart().keySet())
            {
                PreparedStatement maRequette2;
                maRequette2 = connection.prepareStatement("INSERT INTO commande_article (id_commande, id_article, quantite) VALUES(?,?,?)");
                maRequette2.setInt(1, key.intValue());
                maRequette2.setInt(2, article.getId().intValue());
                maRequette2.setInt(3, cart.getCart().get(article));
                maRequette2.execute();
            }
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
    }
}