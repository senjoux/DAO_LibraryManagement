package com.ham.daoImpl;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ham.dao.ThemeDAO;
import com.ham.entities.Theme;
import com.ham.utils.MyConnection;

public class ThemeDAOImpl implements ThemeDAO{
	
	private SessionFactory sf = MyConnection.getInstance();
	
	//************************************
	public int ajouterTheme(String theme){
		Session s=sf.openSession();
        Transaction tx=null;
        Integer themeID=null;
        try{ 
            tx = s.beginTransaction(); 
            Theme tm=new Theme(theme);
            themeID=(Integer)s.save(tm);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
        return themeID;
	}
	//***********************************
	public int ajouterTheme(Theme theme){
		Session s=sf.openSession();
        Transaction tx=null;
        Integer themeID=null;
        try{ 
            tx = s.beginTransaction(); 
            themeID=(Integer)s.save(theme);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
        return themeID;
	}
	//************************************	
	public Theme getTheme(Integer id){
		 	Session s=sf.openSession();
	        Transaction tx=null;
	        Theme t=null;
	        try{ 
	            tx = s.beginTransaction(); 
	            t=(Theme) s.get(Theme.class, id);
	            tx.commit(); 
	        }catch (HibernateException e) { 
	            if (tx!=null) tx.rollback();
	            e.printStackTrace();
	        }finally { 
	            s.close(); 
	        }
	        return t;
	}
	
	//*************************************
	public boolean supprimerTheme(Integer id) {
		Session s=sf.openSession();
        Transaction tx=null;
        boolean res=false;
        try{ 
            tx = s.beginTransaction(); 
            Theme t=(Theme) s.get(Theme.class, id);
            s.delete(t);
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
	public void modifierTheme(Integer id, String theme) {
		Session s=sf.openSession();
		Transaction tx=null;
		try{
			tx=s.beginTransaction();
			Theme t=(Theme)s.get(Theme.class, id);
			t.setTheme(theme);
			s.update(t);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			s.close();
		}
	}
	@Override
	public ArrayList<Theme> getAllThemes() {
		Session s=sf.openSession();
        Transaction tx=null;
        ArrayList<Theme> lst_themes=new ArrayList<Theme>();
        try{ 
            tx=s.beginTransaction();
            //lst_themes=(ArrayList<Theme>) s.createQuery("FROM Theme").list();
            //ou avec criteria :p
            lst_themes=(ArrayList<Theme>) s.createCriteria(Theme.class).list();
            tx.commit();
         }catch (HibernateException e) { 
             if (tx!=null) tx.rollback();
             e.printStackTrace();
         }finally { 
             s.close(); 
         }
 			return lst_themes;	
	}

}
