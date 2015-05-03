package com.ham.dao;

import java.util.ArrayList;

import com.ham.entities.Auteur;
import com.ham.entities.Pays;
import com.ham.entities.Theme;


public interface ThemeDAO {
	
	public int ajouterTheme(String theme);
	public int ajouterTheme(Theme theme);
	public Theme getTheme(Integer id);
	public boolean supprimerTheme(Integer id);
	public void modifierTheme(Integer id,String theme);
	public ArrayList<Theme> getAllThemes();
	
	
}
