/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Objects;

/**
 *
 * @author damien
 */
public class Article {
    private Long id;
    private String nom;
    private String description;
    private Float prix;
    private String srcImage;

    public void setSrcImage(String srcImage) {
        this.srcImage = srcImage;
    }

    public String getSrcImage() {
        return srcImage;
    }

    

    public Article(Long id, String nom, String description, Float prix, String srcImage) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.srcImage = srcImage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }
    
    public String getShortDescription()
    {
        Integer nbCaracteres = 100;
        if(this.description.length() < nbCaracteres)
        {
            nbCaracteres = this.description.length();
        }
        return this.description.subSequence(0, nbCaracteres).toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.nom);
        hash = 71 * hash + Objects.hashCode(this.description);
        hash = 71 * hash + Objects.hashCode(this.prix);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.prix, other.prix)) {
            return false;
        }
        return true;
    }
    
    
}