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
     *
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercej2ee?zeroDateTimeBehavior=convertToNull", "root", "Nico2893!!!");
        } 
        catch (SQLException ex) 
        {
            System.out.println("" + ex);
        }
    }
    
    /**
     *
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
                article = new Article(id, rs.getString("nom_article"), rs.getString("nom_article"), rs.getFloat("prix_article"),rs.getString("src_article"));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
        return article;
    }
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
                if(rs.getString("nom_article").contains(nomSearch) || rs.getString("desc_article").contains(nomSearch) )
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
    
    public boolean addUser(String nom, String prenom, String email, String mdp, String adresse)
    {
        boolean reponse;
        connectBDD();
        try 
        {
            PreparedStatement maRequette;
            maRequette = connection.prepareStatement("INSERT INTO `client`(`nom_client`, `prenom_client`, `email_client`, `mdp_client`, `adresse_client`) VALUES (?,?,?,?,?)");
            maRequette.setString(1, nom);
            maRequette.setString(2, prenom);
            maRequette.setString(3, email);
            maRequette.setString(4, mdp);
            maRequette.setString(5, adresse);
            maRequette.execute();
            reponse = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
            reponse = false; 
        }
        disconnectBDD();
        return reponse;
    }
    
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
    
    public void enregistreCommande(User user, Cart cart)
    {
        connectBDD();
        try 
        {
            Long key = -1L;
            
            PreparedStatement maRequette;
            maRequette = connection.prepareStatement("INSERT INTO commande (date_commande,prix_commande,id_client) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            maRequette.setString(1, new Date().toString());
            maRequette.setFloat(2, cart.getValuePanier());
            maRequette.setInt(3,user.getId().intValue());
            maRequette.execute();
            ResultSet rs = maRequette.getGeneratedKeys();
            rs.next();
            key = rs.getLong(1);
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