package com.ham.entities;

import java.io.Serializable;
import java.util.Date;

public class Examplaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1123652852801120744L;
	
	private int idExamplaire;
	private boolean disponible;
	private String etat;
	private Date date_achat;
	
	public Examplaire() {}
	
	public Examplaire(int id,boolean disponible, String etat,Date date_achat) {
		this.idExamplaire = id;
		this.disponible = disponible;
		this.etat = etat;
		this.date_achat = date_achat;
	}

	public Examplaire(boolean disponible, String etat,Date date_achat) {
		this.disponible = disponible;
		this.etat = etat;
		this.date_achat = date_achat;
	}

	public int getIdExamplaire() {
		return idExamplaire;
	}

	public void setIdExamplaire(int idExamplaire) {
		this.idExamplaire = idExamplaire;
	}
	
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Date getDate_achat() {
		return date_achat;
	}

	public void setDate_achat(Date date_achat) {
		this.date_achat = date_achat;
	}
	
	
	@Override
	public String toString() {
		return "Examplaire [idExamplaire=" + idExamplaire + ", disponible="
				+ disponible + ", etat=" + etat + ", date_achat=" + date_achat
				+ "]";
	}

	
	
	
	
}
