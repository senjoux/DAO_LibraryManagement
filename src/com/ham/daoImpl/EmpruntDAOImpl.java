package com.ham.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ham.dao.EmpruntDAO;
import com.ham.entities.Emprunter;
import com.ham.entities.Examplaire;
import com.ham.entities.Lecteur;
import com.ham.utils.MyConnection;

public class EmpruntDAOImpl implements EmpruntDAO{
	SessionFactory sf=MyConnection.getInstance();

	//*********************************
	public int ajouterEmprunt(Date date_debut, Date date_fin, Lecteur lecteur,	Examplaire examplaire) {
		Session s=sf.openSession();
		Transaction tx=null;
		Integer EmpruntID=null;
		try{
			//Test si l'examplaire est disponible avant de l'emprunter
			if(examplaire.isDisponible()){
				tx=s.beginTransaction();
				Emprunter emp=new Emprunter(date_debut, date_fin, examplaire, lecteur);
				EmpruntID=(Integer) s.save(emp);
				tx.commit();
			}
			
			ExamplaireDAOImpl edo=new ExamplaireDAOImpl();
			edo.modifierExamplaireDisponible(examplaire.getIdExamplaire(), false);
		}catch (HibernateException e) { 
	            if (tx!=null) tx.rollback();
	            e.printStackTrace();
	     }finally{
	    	 s.close(); 
	     }    
		return EmpruntID;
	}

	//*********************************
	public Emprunter getEmprunt(int id) {
		Session s=sf.openSession();
        Transaction tx=null;
        Emprunter emp=null;
        try{ 
            tx = s.beginTransaction(); 
            emp=(Emprunter) s.get(Emprunter.class, id);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
        return emp;
	}

	//*********************************
	public boolean supprimerEmprunter(int id) {
		Session s=sf.openSession();
		 Transaction tx=null;
		 Emprunter emp=null;
		 Examplaire examp=null;
		 boolean temp=false;
		 try{ 
			 tx = s.beginTransaction(); 
			 emp=(Emprunter) s.get(Emprunter.class, id);
			 examp=emp.getExamplaire();
		     s.delete(emp);
		     tx.commit(); 
		     //Si l'emprunt est supprimé l'examplaire est disponible de nouveau 
		     ExamplaireDAOImpl edo=new ExamplaireDAOImpl();
		     edo.modifierExamplaireDisponible(examp.getIdExamplaire(), true);
		     temp=true;
		 }catch (HibernateException e) { 
			 if (tx!=null) tx.rollback();
		     e.printStackTrace();
		 }finally { 
		 s.close(); 
		 }
		 return temp;
	}

	//*********************************
	public void modifierDateDebut(int id, Date date_debut) {
		Session s=sf.openSession();
        Transaction tx=null;
        Emprunter emp=null;
        try{ 
            tx = s.beginTransaction(); 
            emp=(Emprunter) s.get(Emprunter.class, id);
            emp.setDate_debut(date_debut);
            s.update(emp);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
				
	}

	//*********************************
	public void modifierDateFin(int id, Date date_fin) {
		Session s=sf.openSession();
        Transaction tx=null;
        Emprunter emp=null;
        try{ 
            tx = s.beginTransaction(); 
            emp=(Emprunter) s.get(Emprunter.class, id);
            emp.setDate_fin(date_fin);
            s.update(emp);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }		
	}

	//*********************************
	public ArrayList<Emprunter> getAllEmprunter() {
		Session s=sf.openSession();
        Transaction tx=null;
        ArrayList<Emprunter> lstemp=new ArrayList<Emprunter>();
        try{ 
            tx = s.beginTransaction(); 
            lstemp=(ArrayList<Emprunter>) s.createCriteria(Emprunter.class).list();
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
        return lstemp;
	}

	//*********************************
	public ArrayList<Emprunter> getAllEmprunterByLecteur(Lecteur lecteur) {
		Session s=sf.openSession();
        Transaction tx=null;
        ArrayList<Emprunter> lstemp=new ArrayList<Emprunter>();
        try{ 
            tx = s.beginTransaction(); 
            lstemp=(ArrayList<Emprunter>) s.createCriteria(Emprunter.class).list();
            Iterator<Emprunter> it=lstemp.iterator();
            while(it.hasNext()){
            	if(!it.next().getLecteur().equals(lecteur)){
            		it.remove();
            	}
            }
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
        return lstemp;
	}

}
