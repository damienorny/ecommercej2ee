/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommercej2ee?zeroDateTimeBehavior=convertToNull", "root", "Paradise");
        } catch (SQLException ex) {
            System.out.println("" + ex);
        }
    }
    
    /**
     *
     */
    private void disconnectBDD()
    {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Article> getAllArticles()
    {
        ArrayList<Article> liste = new ArrayList();
        connectBDD();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM article");
            while(rs.next())
            {
                liste.add(new Article(rs.getLong("id_article"), rs.getString("nom_article"), rs.getString("nom_article"), rs.getFloat("prix_article")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
        return liste;
    }
    
    public Article getArticleById(Long id)
    {
        Article article = null;
        connectBDD();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM article WHERE id_article = " + id.toString());
            if(rs.next())
            {
                article = new Article(id, rs.getString("nom_article"), rs.getString("nom_article"), rs.getFloat("prix_article"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
        return article;
    }
    
    public ArrayList<Article> getAllArticlesByCategory(Category category)
    {
        ArrayList<Article> liste = new ArrayList<>();
        connectBDD();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `category_article` LEFT JOIN article ON category_article.id_article = article.id_article WHERE `id_category` = " + category.getId().toString());
            while(rs.next())
            {
                liste.add(new Article(rs.getLong("id_article"), rs.getString("nom_article"), rs.getString("description_article"), rs.getFloat("prix_article")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
        return liste;
    }
    
    public Category getArticleCategory(Article article)
    {
        Category category = null;
        connectBDD();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM `category_article` LEFT JOIN category ON category_article.id_category = category.id_category WHERE `id_article` = " + article.getId().toString());
            if(rs.next())
            {
                category = new Category(rs.getLong("id_category"), rs.getString("nom_category"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
        return category;
    }
    
    
}