package com.ham.daoImpl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ham.dao.PaysDAO;
import com.ham.entities.Pays;
import com.ham.utils.MyConnection;

public class PaysDAOImpl implements PaysDAO {

	private SessionFactory sf = MyConnection.getInstance();

	public Pays getPays(String code) {
		Session s=sf.openSession();
        Transaction tx=null;
        Pays pays=null;
        try{ 
           tx=s.beginTransaction();
           pays=(Pays) s.get(Pays.class, code);
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
		return pays;
	}

	public ArrayList<Pays> getAllPays() {
		Session s=sf.openSession();
        Transaction tx=null;
        ArrayList<Pays> lst_pays=new ArrayList<Pays>();
        try{ 
            tx=s.beginTransaction();
            lst_pays=(ArrayList<Pays>) s.createQuery("FROM Pays").list();
         }catch (HibernateException e) { 
             if (tx!=null) tx.rollback();
             e.printStackTrace();
         }finally { 
             s.close(); 
         }
 		return lst_pays;
	}

}
