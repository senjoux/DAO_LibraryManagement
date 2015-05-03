package com.ham.entities;

import java.io.Serializable;
import java.util.Date;

public class Lecteur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8796357336532631759L;
	
	int idLecteur;
	String nom;
	String prenom;
	String mail;
	String adresse;
	String telephone;
	Date date_inscription;
	boolean sanction;
	
	
	public Lecteur() {	}

	public Lecteur(int id, String nom, String prenom, String mail,
					String adresse, String telephone, Date date_inscription,boolean sanction) {
		this.idLecteur = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adresse = adresse;
		this.telephone = telephone;
		this.date_inscription = date_inscription;
		this.sanction = sanction;
	}
	
	public Lecteur(String nom, String prenom, String mail, String adresse,
			String telephone, Date date_inscription, boolean sanction) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adresse = adresse;
		this.telephone = telephone;
		this.date_inscription = date_inscription;
		this.sanction = sanction;
	}

	

	public Lecteur(String nom, String prenom, String mail, String adresse,
			String telephone, Date date_inscription) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.adresse = adresse;
		this.telephone = telephone;
		this.date_inscription = date_inscription;	}

	public int getIdLecteur() {
		return idLecteur;
	}

	public void setIdLecteur(int idLecteur) {
		this.idLecteur = idLecteur;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDate_inscription() {
		return date_inscription;
	}

	public void setDate_inscription(Date date_inscription) {
		this.date_inscription = date_inscription;
	}

	public boolean isSanction() {
		return sanction;
	}

	public void setSanction(boolean sanction) {
		this.sanction = sanction;
	}

	@Override
	public String toString() {
		return "Lecteur [idLecteur=" + idLecteur + ", nom=" + nom + ", prenom="
				+ prenom + ", mail=" + mail + ", adresse=" + adresse
				+ ", telephone=" + telephone + ", date_inscription="
				+ date_inscription + ", sanction=" + sanction + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLecteur;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result
				+ ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lecteur other = (Lecteur) obj;
		if (idLecteur != other.idLecteur)
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}
		
	
}
