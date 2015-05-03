package com.ham.entities;

import java.io.Serializable;
import java.util.Date;

public class Reserver implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2161339525182953905L;
	
	private int id_reservation;
	private Date date_reservation;
	private Lecteur lecteur;
	private Livre livre;
	
	public Reserver() {
	}

	public Reserver(Date date_reservation, Lecteur lecteur, Livre livre) {
		this.date_reservation = date_reservation;
		this.lecteur = lecteur;
		this.livre = livre;
	}

	
	public int getId_reservation() {
		return id_reservation;
	}

	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}

	public Date getDate_reservation() {
		return date_reservation;
	}

	public void setDate_reservation(Date date_reservation) {
		this.date_reservation = date_reservation;
	}

	public Lecteur getLecteur() {
		return lecteur;
	}

	public void setLecteur(Lecteur lecteur) {
		this.lecteur = lecteur;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	@Override
	public String toString() {
		return "Reserver [id_reservation=" + id_reservation
				+ ", date_reservation=" + date_reservation + ", lecteur="
				+ lecteur.toString() + ", livre=" + livre.toString() + "]";
	}
	
	
	
	
}
