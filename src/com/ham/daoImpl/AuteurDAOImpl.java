package com.ham.daoImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ham.dao.AuteurDAO;
import com.ham.entities.Auteur;
import com.ham.entities.Livre;
import com.ham.entities.Pays;
import com.ham.utils.MyConnection;

public class AuteurDAOImpl implements AuteurDAO{
private SessionFactory sf = MyConnection.getInstance();
    
    public AuteurDAOImpl() {}

    //*********************************
    public int ajouterAuteur(String nom,String prenom, Pays pays) {
        
        Session s=sf.openSession();
        Transaction tx=null;
        Integer auteurID=null;
        try{ 
            tx = s.beginTransaction(); 
            Auteur a=new Auteur(nom,prenom,pays);
            auteurID=(Integer)s.save(a);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
        return auteurID;
    }
    
    //*********************************
    public Auteur getAuteur(Integer id) {
        
        Session s=sf.openSession();
        Transaction tx=null;
        Auteur a=null;
        try{ 
            tx = s.beginTransaction(); 
            a=(Auteur) s.get(Auteur.class, id);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
        return a;
    }
 
 	//*********************************
	public boolean supprimerAuteur(Integer id) {
		Session s=sf.openSession();
        Transaction tx=null;
        boolean res=false;
        try{ 
            tx = s.beginTransaction(); 
            Auteur a=(Auteur) s.get(Auteur.class, id);
            s.delete(a);
            tx.commit();
            res=true;
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
		return res;
	}
	
	//*********************************
	public ArrayList<Auteur> getAllAuteurs() {
		Session s=sf.openSession();
        Transaction tx=null;
        ArrayList<Auteur> lst_auteurs=new ArrayList<Auteur>();
        try{ 
            tx=s.beginTransaction();
            lst_auteurs=(ArrayList<Auteur>) s.createQuery("FROM Auteur").list();
            tx.commit();
         }catch (HibernateException e) { 
             if (tx!=null) tx.rollback();
             e.printStackTrace();
         }finally { 
             s.close(); 
         }
 			return lst_auteurs;	
 		}
	//*********************************
	public void modifierAuteurNom(Integer id, String nom) {
		Session s=sf.openSession();
		Transaction tx=null;
		try{
			tx=s.beginTransaction();
			Auteur a=(Auteur)s.get(Auteur.class, id);
			a.setNom(nom);
			s.update(a);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}

	//*********************************
	public void modifierAuteurPrenom(Integer id, String prenom) {
		Session s=sf.openSession();
		Transaction tx=null;
		try{
			tx=s.beginTransaction();
			Auteur a=(Auteur)s.get(Auteur.class, id);
			a.setPrenom(prenom);
			s.update(a);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}		
	}
	
	//*********************************
	public void modifierAuteurPays(Integer id, Pays pays) {
		Session s=sf.openSession();
		Transaction tx=null;
		try{
			tx=s.beginTransaction();
			Auteur a=(Auteur)s.get(Auteur.class, id);
			a.setPays(pays);
			s.update(a);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}			
	}
	
	//*********************************
	public void modifierAuteurLivres(Integer id, Set<Livre> set_a_livres) {
		Session s=sf.openSession();
		Transaction tx=null;
		try{
			tx=s.beginTransaction();
			Auteur a=(Auteur)s.get(Auteur.class, id);
			a.setSet_livres(set_a_livres);
			s.update(a);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}			
	}

	//*********************************
	public void modifierAuteur(Integer id, Auteur nouv) {
		Session s=sf.openSession();
		Transaction tx=null;
		try{
			tx=s.beginTransaction();
			Auteur a=(Auteur)s.get(Auteur.class, id);
			a.setNom(nouv.getNom());
			a.setNom(nouv.getPrenom());
			a.setPays(nouv.getPays());
			a.setSet_livres(nouv.getSet_livres());
			s.update(a);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}	
	}

	//********************************
	 public Set<Livre> getAuteurLivres(Integer id) {        
	        Session s=sf.openSession();
	        Transaction tx=null;
	        Auteur a=null;
	        Set<Livre> sl=null;
	        try{ 
	            tx = s.beginTransaction(); 
	            a=(Auteur) s.get(Auteur.class, id);
	            sl=a.getSet_livres();
	            tx.commit(); 
	        }catch (HibernateException e) { 
	            if (tx!=null) tx.rollback();
	            e.printStackTrace();
	        }finally { 
	            s.close(); 
	        }
	        return sl;
	    }	
	//************************************	
	 public void ajouterLivre_Auteur(Integer id,Livre livre) {
			Session s=sf.openSession();
			Transaction tx=null;
			Set<Livre> sl=new HashSet<Livre>();
			try{
				tx=s.beginTransaction();
				Auteur a=(Auteur)s.get(Auteur.class, id);
				sl=a.getSet_livres();
				if(!sl.contains(livre)){
				sl.add(livre);
				a.setSet_livres(sl);
				s.update(a);
				tx.commit();
				}
			}catch(HibernateException e){
				if(tx!=null) tx.rollback();
				e.printStackTrace();
			}finally{
				s.close();
			}			
		}

}
