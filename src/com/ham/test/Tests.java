package com.ham.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.SessionFactory;

import com.ham.dao.ReserverDAO;
import com.ham.daoImpl.AuteurDAOImpl;
import com.ham.daoImpl.ExamplaireDAOImpl;
import com.ham.daoImpl.LecteurDAOImpl;
import com.ham.daoImpl.LivreDAOImpl;
import com.ham.daoImpl.PaysDAOImpl;
import com.ham.daoImpl.ReserverDAOImpl;
import com.ham.daoImpl.ThemeDAOImpl;
import com.ham.entities.Auteur;
import com.ham.entities.Examplaire;
import com.ham.entities.Lecteur;
import com.ham.entities.Livre;
import com.ham.entities.Pays;
import com.ham.entities.Reserver;
import com.ham.entities.Theme;
import com.ham.utils.MyConnection;

public class Tests {
	public static void main(String args[]){
		//SessionFactory sf=MyConnection.getInstance();
		
		ReserverDAOImpl rdo=new ReserverDAOImpl();
		LecteurDAOImpl lcdo=new LecteurDAOImpl();
		//ThemeDAOImpl tdo=new ThemeDAOImpl();
		LivreDAOImpl ldo=new LivreDAOImpl();
		//ExamplaireDAOImpl edo=new ExamplaireDAOImpl();
		
		//ldo.supprimerLivre(5);
		//AuteurDAOImpl ado=new AuteurDAOImpl();
		//PaysDAOImpl pdo=new PaysDAOImpl();
		
		//***************Tests AuteurDAO & PaysDAO
		//Pays p1=pdo.getPays("TN");
		//Pays p2=pdo.getPays("FR");
		//modification nom & prenom & pays auteur
		//ado.modifierAuteurNom(12, "hassen");
		//ado.modifierAuteurPrenom(12, "hedhly");
		//ado.modifierAuteurPays(12, p1);
		//Suppression auteur
		//ado.supprimerAuteur(13);
		//Pays p3=pdo.getPays("AT");
		//Pays p4=pdo.getPays("DZ");
		//System.out.println(p4.toString());
		/*ArrayList<Pays> lstp=new ArrayList<Pays>();
		lstp=pdo.getAllPays();
		Iterator<Pays> it=lstp.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		*/
		//System.out.println(ado.ajouterAuteur("ssss", "xxx", p2));
		//System.out.println(ado.ajouterAuteur("salah2", "ben salih2", p2));
	/*
		ArrayList<Auteur> lsta=ado.getAllAuteurs();
		System.out.println(lsta.size());
		Iterator<Auteur> it=lsta.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	*/
		/*
		//Affichage de liste des  livres d'un auteur 
		Set<Livre> stliv=ado.getAuteurLivres(5);
		Iterator<Livre> it=stliv.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		*/
		//ado.modifierAuteurPays(2, p3);
		//Affectation d'un livre à un auteur
		//ado.ajouterLivre_Auteur(2, ldo.getLivre(6));
		
		//***************Tests ThemeDAO
		//Affichage theme
		//Theme t1=tdo.getTheme(1);
		//System.out.println(t1.toString());
		//Ajout theme
		//Theme thtest=new Theme("TEST");
		//System.out.println(tdo.ajouterTheme(thtest));
		//Suppression theme
		//System.out.println(tdo.supprimerTheme(6));
		//Modification theme
		//tdo.modifierTheme(7, "Drama");
		//Affichage de la liste des themes
		/*
		ArrayList<Theme> lsttm=tdo.getAllThemes();
		Iterator<Theme> it=lsttm.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		*/
		
		
		//******************Tests LivreDAO
		//Ajout livre 
		//System.out.println(ldo.ajouterLivre("LOTR"));
		//Ajout examplaire à un livre
		//ldo.ajouterExamplaire_Livre(6, edo.getExamplaire(5));
		//Affichages des livres par theme
		/*
		Theme t1=tdo.getTheme(1);
		ArrayList<Livre> lslvtm=ldo.getAllLivresViaTheme(t1);
		Iterator<Livre> it=lslvtm.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		*/
		//Affectation des themes à un livre
		//Theme t1=tdo.getTheme(7);
		//ldo.ajouterTheme_Livre(2, t1);
		//System.out.println(t1);
		//Theme t2=tdo.getTheme(2);
		/* Set<Theme> st=new HashSet<Theme>(); 
		st.add(t1);
		st.add(t2);
		ldo.ajouterLivre("Livre de geo et phys",15, st);
		*/
		//affectation d'un livre à un auteur
		//ado.ajouterLivre_Auteur(5, ldo.getLivre(3));
		//ajout d'un theme à un livre
		//Theme t=tdo.getTheme(4);
		//ldo.ajouterTheme_Livre(2, t);
		//Affichage de tous livres 
		/*
		ArrayList<Livre> lstl=ldo.getAllLivres();
		Iterator<Livre> it=lstl.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		*/
		//Modification du titre d'un livre
		//ldo.modifierLivreTitre(2, "Les miserables");
		
		//Tests DAO Examplaire
		//Test ajout examplaire
		//Date d=new Date(5, 8, 2015);d.setYear(114);d.setMonth(05);d.setHours(01);
		//edo.ajouterExamplaire("bon", d);
		//Test get Examplaire
		//System.out.println(edo.getExamplaire(1).toString());
		//Tests modification examplaire
		//edo.modifierExamplaireEtat(2, "mauvais");
		//tes getAllExamplaires
		/*ArrayList<Examplaire> lstex=edo.getAllExamplaires();
		Iterator<Examplaire> it=lstex.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}*/
		//ldo.ajouterExamplaire_Livre(3, edo.getExamplaire(3));
		
		//*********************Tests LecteurDAO
		//Ajout Lecteur
		//System.out.println(lcdo.ajouterLecteur("hh2", "el h2", "xxx", "hmz@gg", "55525541", null));
		//Get Auteur
		//System.out.println(lcdo.getLecteur(1).toString());
		//Suppression Lecteur
		//lcdo.supprimerLecteur(4);
		//Modification nom & prenom & adresse & mail & tel & date inscription & sanction Lecteur
		//lcdo.modifierLecteurNom(3, "hassen");
		//lcdo.modifierLecteurPrenom(3, "el hedhly");
		//lcdo.modifierLecteurAdresse(3, "Rue mongi slim xxxx");
		//lcdo.modifierLecteurMail(3, "hassen@gmail.com");
		//lcdo.modifierLecteurTel(3, "96489833");
		//Date d=new Date(114, 8, 22);
		//lcdo.modifierLecteurDateInscription(3, d);
		//lcdo.modifierSanction(3, true);
		//Lister les lecteurs
		/*
		ArrayList<Lecteur> lstlec=lcdo.getAllLecteurs();
		Iterator<Lecteur> it=lstlec.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
		*/
		
		//*********************Tests ReserverDAO
		//Ajout reservation
		//System.out.println(rdo.ajouterReservation(new Date(114, 1, 15), lcdo.getLecteur(3), ldo.getLivre(1)));
		//Get reservation
		//System.out.println(rdo.getReservation(1).toString());
		//Modification date reservation
		//rdo.modifierDateReservation(2, new Date(112, 5, 5));
		//Affichage de tous les reservations 
		/*ArrayList<Reserver> lstres=rdo.getAllReservation();
		Iterator<Reserver> it1=lstres.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next().toString());
		}
		*/
		//Affichage des reservations d'un lecteur
		/*ArrayList<Reserver> lstres=rdo.getAllReservationByLecteur(lcdo.getLecteur(3));
		Iterator<Reserver> it2=lstres.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next().toString());
		}*/
		//Affichage des reservations d'un livre
		/*ArrayList<Reserver> lstres=rdo.getAllReservationByLivre(ldo.getLivre(1));
		Iterator<Reserver> it3=lstres.iterator();
		while(it3.hasNext()){
			System.out.println(it3.next().toString());
		}
		*/
		//Suppression reservation
		//System.out.println(rdo.supprimerReservation(3));
		
		
	}

	
}
