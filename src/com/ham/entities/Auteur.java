package com.ham.entities;

import java.io.Serializable;
import java.util.Set;

public class Auteur implements Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -5225447506723336877L;
	private int idAuteur;
	private String nom;
    private String prenom;
    private Pays pays;
    private Set<Livre> set_a_livres;
    
    public Auteur() {}

    public Auteur(int id, String nom, String prenom, Pays pays) {
        this.idAuteur = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
    }


    public Auteur(String nom, String prenom, Pays pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
    }

   
    public Auteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getId() {
        return idAuteur;
    }

    public void setId(int id) {
        this.idAuteur = id;
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
   
    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
 
    public String toString() {
        return "Auteur{" + "id=" + idAuteur + ", nom=" + nom + ", prenom=" + prenom ;
    }

	public Set<Livre> getSet_livres() {
		return set_a_livres;
	}

	public void setSet_livres(Set<Livre> set_livres) {
		this.set_a_livres = set_livres;
	}
        
}
