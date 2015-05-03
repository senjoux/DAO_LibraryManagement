package com.ham.entities;


public class Pays {
	
	private String code;
    private String nom;
    private String nom_complet;
    private String iso;
    private int numero;
    
    public Pays() {}

    public Pays(String code, String nom, String nom_complet, String iso, int numero) {
        this.code = code;
        this.nom = nom;
        this.nom_complet = nom_complet;
        this.iso = iso;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom_complet() {
        return nom_complet;
    }

    public void setNom_complet(String nom_complet) {
        this.nom_complet = nom_complet;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

	@Override
	public String toString() {
		return "Pays [code=" + code + ", nom=" + nom + ", nom_complet="
				+ nom_complet + ", iso=" + iso + ", numero=" + numero + "]";
	}
      
    
}
