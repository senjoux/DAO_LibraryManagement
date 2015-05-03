package com.ham.dao;

import java.util.ArrayList;
import java.util.Set;

import com.ham.entities.Examplaire;
import com.ham.entities.Livre;
import com.ham.entities.Theme;

public interface LivreDAO {
	
	public int ajouterLivre(String titre, Set<com.ham.entities.Theme> set_l_themes);
	public int ajouterLivre(String titre);
	public Livre getLivre(Integer id);
	public ArrayList<Livre> getAllLivres();
	public ArrayList<Livre> getAllLivresViaTheme(Theme theme);
	public boolean supprimerLivre(Integer id);
	public void modifierLivreTitre(Integer id,String titre);
	public void modifierNbrEx(Integer id);
	public boolean ajouterTheme_Livre(Integer id, Theme theme);
	public boolean ajouterThemes_Livre(Integer id, Set<Theme> set_l_themes);
	public boolean ajouterExamplaires_Livre(Integer id,Set<Examplaire> set_exemplaires);
}
