package com.ham.dao;

import java.util.ArrayList;
import java.util.Date;

import com.ham.entities.Lecteur;

public interface LecteurDAO {
	public int ajouterLecteur(String nom,String prenom,String adresse,String mail,String tel,Date date_inscription);
	public Lecteur getLecteur(Integer id);
	public boolean supprimerLecteur(Integer id);
	public void modifierLecteurNom(int id,String nom);
	public void modifierLecteurPrenom(int id,String prenom);
    public void modifierLecteurAdresse(int id,String adresse);
    public void modifierLecteurMail(int id,String mail);
    public void modifierLecteurTel(int id,String tel);
    public void modifierLecteurDateInscription(int id,Date date);
    public void modifierLecteurSanction(int id,boolean sanction);
    public ArrayList<Lecteur> getAllLecteurs();

    
}
