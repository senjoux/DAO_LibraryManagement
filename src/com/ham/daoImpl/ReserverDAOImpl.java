package com.ham.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ham.dao.ReserverDAO;
import com.ham.entities.Lecteur;
import com.ham.entities.Livre;
import com.ham.entities.Reserver;
import com.ham.utils.MyConnection;

public class ReserverDAOImpl implements ReserverDAO{
	SessionFactory sf=MyConnection.getInstance();
	
	//*********************************
	public int ajouterReservation(Date date,Lecteur lecteur, Livre livre) {
		Session s=sf.openSession();
		Transaction tx=null;
		Integer ReservationID=null;
		try{
			tx=s.beginTransaction();
			Reserver res=new Reserver(date, lecteur, livre);
			ReservationID=(Integer) s.save(res);
			tx.commit();
		}catch (HibernateException e) { 
	            if (tx!=null) tx.rollback();
	            e.printStackTrace();
	     }finally{
	    	 s.close(); 
	     }    
		return ReservationID;
	}

	//*********************************
	public Reserver getReservation(int id) {
		 Session s=sf.openSession();
	        Transaction tx=null;
	        Reserver res=null;
	        try{ 
	            tx = s.beginTransaction(); 
	            res=(Reserver) s.get(Reserver.class, id);
	            tx.commit(); 
	        }catch (HibernateException e) { 
	            if (tx!=null) tx.rollback();
	            e.printStackTrace();
	        }finally { 
	            s.close(); 
	        }
	        return res;
	}
	
	//*********************************
	public boolean supprimerReservation(int id) {
		 Session s=sf.openSession();
	        Transaction tx=null;
	        Reserver res=null;
	        boolean temp=false;
	        try{ 
	            tx = s.beginTransaction(); 
	            res=(Reserver) s.get(Reserver.class, id);
	            s.delete(res);
	            tx.commit(); 
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
	public void modifierDateReservation(int id, Date date) {
		Session s=sf.openSession();
        Transaction tx=null;
        Reserver res=null;
        try{ 
            tx = s.beginTransaction(); 
            res=(Reserver) s.get(Reserver.class, id);
            res.setDate_reservation(date);
            s.update(res);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
		
	}

	//*********************************
	public ArrayList<Reserver> getAllReservation() {
		Session s=sf.openSession();
        Transaction tx=null;
        ArrayList<Reserver> lstres=new ArrayList<Reserver>();
        try{ 
            tx = s.beginTransaction(); 
            lstres=(ArrayList<Reserver>) s.createCriteria(Reserver.class).list();
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
        return lstres;
	}

	//*********************************
	public ArrayList<Reserver> getAllReservationByLecteur(Lecteur lecteur) {
		Session s=sf.openSession();
        Transaction tx=null;
        ArrayList<Reserver> lstres=new ArrayList<Reserver>();
        try{ 
            tx = s.beginTransaction(); 
            lstres=(ArrayList<Reserver>) s.createCriteria(Reserver.class).list();
            Iterator<Reserver> it=lstres.iterator();
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
        return lstres;
	}

	//*********************************
	public ArrayList<Reserver> getAllReservationByLivre(Livre livre) {
		Session s=sf.openSession();
        Transaction tx=null;
        ArrayList<Reserver> lstres=new ArrayList<Reserver>();
        try{ 
            tx = s.beginTransaction(); 
            lstres=(ArrayList<Reserver>) s.createCriteria(Reserver.class).list();
            Iterator<Reserver> it=lstres.iterator();
            while(it.hasNext()){
            	if(!it.next().getLivre().equals(livre)){
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
        return lstres;
	}

	

}
