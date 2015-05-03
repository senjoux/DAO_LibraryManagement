package com.ham.dao;

import java.util.ArrayList;
import java.util.Set;

import com.ham.entities.Auteur;
import com.ham.entities.Livre;
import com.ham.entities.Pays;

public interface AuteurDAO {
	
	public int ajouterAuteur(String nom, String prenom,Pays pays );
	public Auteur getAuteur(Integer id);
	public boolean supprimerAuteur(Integer id);
    public ArrayList<Auteur> getAllAuteurs();
    public void modifierAuteurNom(Integer id,String nom);
    public void modifierAuteurPrenom(Integer id,String prenom);
    public void modifierAuteurPays(Integer id,Pays pays);    
    public void modifierAuteurLivres(Integer id,Set<Livre> set_a_livres);
    
    public void modifierAuteur(Integer id,Auteur nouv);
    
    public void ajouterLivre_Auteur(Integer id,Livre livre);

}
