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
    public void connectBDD()
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
    public void disconnectBDD()
    {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> getArticles()
    {
        ArrayList<String> liste = new ArrayList();
        connectBDD();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM article");
            while(rs.next())
            {
                liste.add(rs.getString("nom_article"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EcommerceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectBDD();
        return liste;
    }
}