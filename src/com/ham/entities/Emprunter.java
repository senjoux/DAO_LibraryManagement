package com.ham.entities;

import java.util.Date;

public class Emprunter {
	
	private int id_emprunt;
	private Date date_debut;
	private Date date_fin;
	private Examplaire examplaire;
	private Lecteur lecteur;
		
	public Emprunter() {}

	public Emprunter(Date date_debut, Date date_fin, Examplaire examplaire,Lecteur lecteur) {
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.examplaire = examplaire;
		this.lecteur = lecteur;
	}

	
	public int getId_emprunt() {
		return id_emprunt;
	}

	public void setId_emprunt(int id_emprunt) {
		this.id_emprunt = id_emprunt;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public Examplaire getExamplaire() {
		return examplaire;
	}

	public void setExamplaire(Examplaire examplaire) {
		this.examplaire = examplaire;
	}

	public Lecteur getLecteur() {
		return lecteur;
	}

	public void setLecteur(Lecteur lecteur) {
		this.lecteur = lecteur;
	}
		
}
