package com.ham.dao;

import java.util.ArrayList;
import java.util.Date;

import com.ham.entities.Lecteur;
import com.ham.entities.Livre;
import com.ham.entities.Reserver;

public interface ReserverDAO {
	public int ajouterReservation(Date date,Lecteur lecteur, Livre livre);
	public Reserver getReservation(int id);
	public boolean supprimerReservation(int id);
	public void modifierDateReservation(int id, Date date);
	public ArrayList<Reserver> getAllReservation();
	public ArrayList<Reserver> getAllReservationByLecteur(Lecteur lecteur);
	public ArrayList<Reserver> getAllReservationByLivre(Livre livre);
}
