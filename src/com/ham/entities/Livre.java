package com.ham.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Livre implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8694271875973103124L;
	
	private int idLivre;
	private String titre;
	private int nbr_exemplaires;
	private Set<Examplaire> set_exemplaires=new HashSet<Examplaire>() ;
	private Set<Theme> set_l_themes=new HashSet<Theme>();
	
	public Livre() {}
	
	public Livre(int id, String titre, int nbr_exemplaires) {
		this.idLivre = id;
		this.titre = titre;
		this.nbr_exemplaires = nbr_exemplaires;
	}
	
	public Livre(String titre, int nbr_exemplaires) {
		this.titre = titre;
		this.nbr_exemplaires = nbr_exemplaires;
	}

	public int getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getNbr_exemplaires() {
		return nbr_exemplaires;
	}

	public void setNbr_exemplaires(int nbr_exemplaires) {
		this.nbr_exemplaires = nbr_exemplaires;
	}

	public Set<Examplaire> getSet_exemplaires() {
		return set_exemplaires;
	}

	public void setSet_exemplaires(Set<Examplaire> set_exemplaires) {
		this.set_exemplaires = set_exemplaires;
	}

	public Set<Theme> getSet_l_themes() {
		return set_l_themes;
	}

	public void setSet_l_themes(Set<Theme> lst_l_themes) {
		this.set_l_themes = lst_l_themes;
	}

	@Override
	public String toString() {
		return "Livre [idLivre=" + idLivre + ", titre=" + titre
				+ ", nbr_exemplaires=" + nbr_exemplaires + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLivre;
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livre other = (Livre) obj;
		if (idLivre != other.idLivre)
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
	
	
	
}
