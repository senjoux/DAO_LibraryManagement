package com.ham.dao;

import java.util.ArrayList;
import java.util.Date;

import com.ham.entities.Examplaire;

public interface ExamplaireDAO {

	public int ajouterExamplaire(String etat,Date dateAchat);
	public Examplaire getExamplaire(Integer id);
	public boolean supprimerExamplaire(Integer id);
	public void modifierExamplaireEtat(Integer id,String etat);
	public void modifierExamplaireDisponible(Integer id,boolean disponible);
	public void modifierDateAchat(Integer id,Date date);
	public ArrayList<Examplaire> getAllExamplaires();
}
