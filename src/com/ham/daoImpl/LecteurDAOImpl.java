package com.ham.daoImpl;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ham.dao.LecteurDAO;
import com.ham.entities.Lecteur;
import com.ham.utils.MyConnection;

public class LecteurDAOImpl implements LecteurDAO{
	private SessionFactory sf = MyConnection.getInstance();

	//***************************
	public int ajouterLecteur(String nom,String prenom,String adresse,String mail,String telephone,Date date_inscription) {
		Session s=sf.openSession();
        Transaction tx=null;
        Integer lecteurID=null;
        try{ 
            tx = s.beginTransaction(); 
            Lecteur l=new Lecteur(nom, prenom, mail, adresse, telephone, date_inscription);
            lecteurID=(Integer)s.save(l);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
        return lecteurID;
	}

	//***************************
	public Lecteur getLecteur(Integer id) {
		Session s=sf.openSession();
		Transaction tx=null;
		Lecteur l=null;
        try{ 
            tx = s.beginTransaction(); 
            l=(Lecteur) s.get(Lecteur.class, id);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
        return l;
	}

	@Override
	public boolean supprimerLecteur(Integer id) {
		Session s=sf.openSession();
		Transaction tx=null;
		Lecteur l=null;
		boolean res=false;
        try{ 
            tx = s.beginTransaction(); 
            l=(Lecteur) s.get(Lecteur.class, id);
            s.delete(l);
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

	@Override
	public void modifierLecteurNom(int id,String nom) {
		Session s=sf.openSession();
		Transaction tx=null;
		Lecteur l=null;
        try{ 
            tx = s.beginTransaction(); 
            l=(Lecteur) s.get(Lecteur.class, id);
            l.setNom(nom);
            s.update(l);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
	}

	//***************************
	public void modifierLecteurPrenom(int id, String prenom) {
		Session s=sf.openSession();
		Transaction tx=null;
		Lecteur l=null;
        try{ 
            tx = s.beginTransaction(); 
            l=(Lecteur) s.get(Lecteur.class, id);
            l.setPrenom(prenom);
            s.update(l);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }		
	}

	//***************************
	public void modifierLecteurAdresse(int id, String adresse) {
		Session s=sf.openSession();
		Transaction tx=null;
		Lecteur l=null;
        try{ 
            tx = s.beginTransaction(); 
            l=(Lecteur) s.get(Lecteur.class, id);
            l.setAdresse(adresse);
            s.update(l);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }		
		
	}

	//***************************
	public void modifierLecteurMail(int id, String mail) {
		Session s=sf.openSession();
		Transaction tx=null;
		Lecteur l=null;
        try{ 
            tx = s.beginTransaction(); 
            l=(Lecteur) s.get(Lecteur.class, id);
            l.setMail(mail);
            s.update(l);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }				
	}

	//***************************
	public void modifierLecteurTel(int id, String tel) {
		Session s=sf.openSession();
		Transaction tx=null;
		Lecteur l=null;
        try{ 
            tx = s.beginTransaction(); 
            l=(Lecteur) s.get(Lecteur.class, id);
            l.setTelephone(tel);
            s.update(l);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }					
	}

	//***************************
	public void modifierLecteurDateInscription(int id, Date date) {
		Session s=sf.openSession();
		Transaction tx=null;
		Lecteur l=null;
        try{ 
            tx = s.beginTransaction(); 
            l=(Lecteur) s.get(Lecteur.class, id);
            l.setDate_inscription(date);
            s.update(l);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }				
	}
	
	//***************************
	public void modifierLecteurSanction(int id, boolean sanction) {
		Session s=sf.openSession();
		Transaction tx=null;
		Lecteur l=null;
        try{ 
            tx = s.beginTransaction(); 
            l=(Lecteur) s.get(Lecteur.class, id);
            l.setSanction(sanction);
            s.update(l);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }				
	}

	//***************************
	public ArrayList<Lecteur> getAllLecteurs() {
		Session s=sf.openSession();
        Transaction tx=null;
        ArrayList<Lecteur> lst_lecteurs=new ArrayList<Lecteur>();
        try{ 
            tx=s.beginTransaction();
            lst_lecteurs=(ArrayList<Lecteur>) s.createQuery("FROM Lecteur").list();
            tx.commit();
         }catch (HibernateException e) { 
             if (tx!=null) tx.rollback();
             e.printStackTrace();
         }finally { 
             s.close(); 
         }
 			return lst_lecteurs;	
	}

}
