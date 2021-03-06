/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.*;
import javax.mail.internet.*;

/**
* Simple demonstration of using the javax.mail API.
*
* Run from the command line. Please edit the implementation
* to use correct email addresses and host name.
*/
public final class Email 
{

    private final static String MAILER_VERSION = "Java";
    
    /**
     * Permet d'envoyer un mail à l'utilisateur
     * @param user
     * @param cart
     * @return 
     */
    public static boolean envoyerMailSMTP(User user, Cart cart) 
    {
        //Remplacez email et mot de passe par des identifiants gmail valide.
        final String username="Email";
        final String password="MotDePasse";
        //
        Properties prop=new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(prop,new javax.mail.Authenticator() 
        {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            String htmlBody = "<strong>This is an HTML Message</strong>";
            String textBody = "Bonjour " + user.getPrenom() + ",<br/>Nous vous confirmons par ce mail votre commande:<br/>";
            HashMap<Article,Integer> commande = cart.getCart();
            for(Article art : commande.keySet())
            {
                textBody += commande.get(art) + " " + art.getNom() + "<br/>";
            }
            textBody += "Pour un total de: "+ cart.getValuePanier() + " &euro;<br/>Cette commande vous sera envoyé à l'adresse<br/>" + user.getAdresse() + "<br/>Nous vous prions de bien vouloir nous signaler tout problème et nous espérons que vous recevrez votre commande dans les plus bref délais.";
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("zozo@zozo.com"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(user.getEmail()));
            message.setSubject("Confirmation de votre achat!");
            MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
            mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
            mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
            mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
            mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
            mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
            CommandMap.setDefaultCommandMap(mc);
            message.setText(htmlBody);
            message.setContent(textBody, "text/html");
            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }
}

