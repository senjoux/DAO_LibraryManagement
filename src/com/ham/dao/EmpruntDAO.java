package com.ham.dao;

import java.util.ArrayList;
import java.util.Date;

import com.ham.entities.Emprunter;
import com.ham.entities.Examplaire;
import com.ham.entities.Lecteur;

public interface EmpruntDAO {
	public int ajouterEmprunt(Date date_debut,Date date_fin,Lecteur lecteur, Examplaire examplaire);
	public Emprunter getEmprunt(int id);
	public boolean supprimerEmprunter(int id);
	public void modifierDateDebut(int id, Date date_debut);
	public void modifierDateFin(int id, Date date_fin);
	public ArrayList<Emprunter> getAllEmprunter();
	public ArrayList<Emprunter> getAllEmprunterByLecteur(Lecteur lecteur);
}
