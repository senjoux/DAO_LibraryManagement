package com.ham.daoImpl;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ham.dao.ExamplaireDAO;
import com.ham.entities.Examplaire;
import com.ham.utils.MyConnection;

public class ExamplaireDAOImpl implements ExamplaireDAO{

	private SessionFactory sf = MyConnection.getInstance();
			
	public ExamplaireDAOImpl() {}

	public int ajouterExamplaire(String etat, Date dateAchat) {
		Session s=sf.openSession();
        Transaction tx=null;
        Integer examplaireID=null;
        try{ 
            tx = s.beginTransaction(); 
            Examplaire e=new Examplaire(true, etat, dateAchat);
            examplaireID=(Integer)s.save(e);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
        return examplaireID;
	}

	//**********************************************
	public Examplaire getExamplaire(Integer id){
		Session s=sf.openSession();
        Transaction tx=null;
        Examplaire ex=null;
        try{ 
            tx = s.beginTransaction(); 
            ex=(Examplaire) s.get(Examplaire.class, id);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
        return ex;	
        }

	//**********************************************
	
	public boolean supprimerExamplaire(Integer id) {
		Session s=sf.openSession();
        Transaction tx=null;
        boolean res=false;
        try{ 
            tx = s.beginTransaction(); 
            Examplaire ex=(Examplaire) s.get(Examplaire.class, id);
            s.delete(ex);
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

	//**********************************************
	
	public void modifierExamplaireEtat(Integer id,String etat) {
		Session s=sf.openSession();
	     Transaction tx=null;	
	     try{ 
	            tx=s.beginTransaction();
	            Examplaire ex=(Examplaire) s.get(Examplaire.class, id);
	            ex.setEtat(etat);
	            s.update(ex);
	            tx.commit();
	         }catch (HibernateException e) { 
	             if (tx!=null) tx.rollback();
	             e.printStackTrace();
	         }finally { 
	             s.close(); 
	         }  		
	}

	//**********************************************

	public void modifierExamplaireDisponible(Integer id,boolean disponible) {
		Session s=sf.openSession();
	     Transaction tx=null;	
	     try{ 
	            tx=s.beginTransaction();
	            Examplaire ex=(Examplaire) s.get(Examplaire.class, id);
	            ex.setDisponible(disponible);
	            s.update(ex);
	            tx.commit();
	         }catch (HibernateException e) { 
	             if (tx!=null) tx.rollback();
	             e.printStackTrace();
	         }finally { 
	             s.close(); 
	         }  			
	}

	//**********************************************

	public void modifierDateAchat(Integer id,Date date) {
		Session s=sf.openSession();
	     Transaction tx=null;	
	     try{ 
	            tx=s.beginTransaction();
	            Examplaire ex=(Examplaire) s.get(Examplaire.class, id);
	            ex.setDate_achat(date);
	            s.update(ex);
	            tx.commit();
	         }catch (HibernateException e) { 
	             if (tx!=null) tx.rollback();
	             e.printStackTrace();
	         }finally { 
	             s.close(); 
	         }  		
	}

	//**********************************************

	public ArrayList<Examplaire> getAllExamplaires() {
		Session s=sf.openSession();
        Transaction tx=null;
        ArrayList<Examplaire> lst_examplaires=new ArrayList<Examplaire>();
        try{ 
            tx=s.beginTransaction();
            lst_examplaires=(ArrayList<Examplaire>) s.createQuery("FROM Examplaire").list();
            tx.commit();
         }catch (HibernateException e) { 
             if (tx!=null) tx.rollback();
             e.printStackTrace();
         }finally { 
             s.close(); 
         }
 			return lst_examplaires;	
	}

	
}
