/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author damien
 */
public class User {
    private Long id;
    private String email;
    private String nom;
    private String prenom;
    private String adresse;

    public User(Long id, String email, String nom, String prenom, String adresse) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public User(String email, String nom, String prenom, String adresse) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
