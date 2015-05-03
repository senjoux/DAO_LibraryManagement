package com.ham.daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ham.dao.LivreDAO;
import com.ham.entities.Examplaire;
import com.ham.entities.Livre;
import com.ham.entities.Theme;
import com.ham.utils.MyConnection;

public class LivreDAOImpl implements LivreDAO{

	private SessionFactory sf = MyConnection.getInstance();

	//********************************************
	public int ajouterLivre(String titre,Set<Theme> set_l_themes) {
		Session s=sf.openSession();
        Transaction tx=null;
        Integer IDLivre=null; 
        try{ 
            tx = s.beginTransaction(); 
            Livre l=new Livre();
            l.setTitre(titre);
            l.setSet_l_themes(set_l_themes);
            IDLivre=(int)s.save(l);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
        return IDLivre;
	}
	
	//*********************************************
	public int ajouterLivre(String titre){
		Session s=sf.openSession();
        Transaction tx=null;
        Integer IDLivre=null; 
        try{ 
            tx = s.beginTransaction(); 
            Livre l=new Livre();
            l.setTitre(titre);
            IDLivre=(int)s.save(l);
            tx.commit(); 
        }catch (HibernateException e) { 
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally { 
            s.close(); 
        }
        return IDLivre;	
        }
	
	//*********************************************
	 public Livre getLivre(Integer id) {    
	        Session s=sf.openSession();
	        Transaction tx=null;
	        Livre l=null;
	        try{ 
	            tx = s.beginTransaction(); 
	            l=(Livre) s.get(Livre.class, id);
	            tx.commit(); 
	        }catch (HibernateException e) { 
	            if (tx!=null) tx.rollback();
	            e.printStackTrace();
	        }finally { 
	            s.close(); 
	        }
	        return l;
	    }
	 
	 //*********************************************
	 public ArrayList<Livre> getAllLivres() {
			Session s=sf.openSession();
	        Transaction tx=null;
	        ArrayList<Livre> lst_livres=new ArrayList<Livre>();
	        try{ 
	            tx=s.beginTransaction();
	            lst_livres=(ArrayList<Livre>) s.createQuery("FROM Livre").list();
	            tx.commit();
	         }catch (HibernateException e) { 
	             if (tx!=null) tx.rollback();
	             e.printStackTrace();
	         }finally { 
	             s.close(); 
	         }
	 			return lst_livres;	
	 		}
	 //*********************************************
		public boolean supprimerLivre(Integer id){
			Session s=sf.openSession();
	        Transaction tx=null;
	        boolean res=false;
	        try{ 
	            tx = s.beginTransaction(); 
	            Livre l=(Livre) s.get(Livre.class, id);
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

	 
	 //*********************************************
	 public void modifierLivreTitre(Integer id,String titre){
		 Session s=sf.openSession();
	     Transaction tx=null;	
	     try{ 
	            tx=s.beginTransaction();
	            Livre l=(Livre) s.get(Livre.class, id);
	            l.setTitre(titre);
	            s.update(l);
	            tx.commit();
	         }catch (HibernateException e) { 
	             if (tx!=null) tx.rollback();
	             e.printStackTrace();
	         }finally { 
	             s.close(); 
	         }  
	 }
	 
	//************************************Methode (update) pour refraichir le nombre n'examplaire qu'un livre posséde :p
	 public void modifierNbrEx(Integer id){
		 Session s=sf.openSession();
	     Transaction tx=null;
	     try{ 
	            tx=s.beginTransaction();
	            Livre l=(Livre) s.get(Livre.class, id);
	            l.setNbr_exemplaires(l.getSet_exemplaires().size());
	            s.update(l);
	            tx.commit();
	         }catch (HibernateException e) { 
	             if (tx!=null) tx.rollback();
	             e.printStackTrace();
	         }finally { 
	             s.close(); 
	         }  
	 }
	 
	 
	//**********************************************
	 public boolean ajouterTheme_Livre(Integer id, Theme theme) {
			Session s=sf.openSession();
	        Transaction tx=null;
	        Livre l=null;
	        boolean res=false;
	        try{ 
	            tx = s.beginTransaction(); 
	            l=(Livre) s.get(Livre.class, id);
	            Set<Theme> st=l.getSet_l_themes();
	            if(!st.contains(theme)){
	            st.add(theme);
	            l.setSet_l_themes(st);
	            s.update(l);
	            tx.commit();
	            res=true;
	            }
	        }catch (HibernateException e) { 
	            if (tx!=null) tx.rollback();
	            e.printStackTrace();
	        }finally { 
	            s.close(); 
	        }
	        return res;
		}
	//********************************************

	 public boolean ajouterExamplaire_Livre(Integer id, Examplaire examplaire) {
		 Session s=sf.openSession();
	        Transaction tx=null;
	        Livre l=null;
	        boolean res=false;
	        try{ 
	            tx = s.beginTransaction(); 
	            l=(Livre) s.get(Livre.class, id);
	            Set<Examplaire> st=l.getSet_exemplaires();
	            if(!st.contains(examplaire)){
	            st.add(examplaire);
	            l.setSet_exemplaires(st);
	            l.setNbr_exemplaires(l.getSet_exemplaires().size());
	            s.update(l);
	            tx.commit();
	            res=true;
	            }
	        }catch (HibernateException e) { 
	            if (tx!=null) tx.rollback();
	            e.printStackTrace();
	        }finally { 
	            s.close(); 
	        }
	        return res;
		}
	 
	 //************************************************
	public boolean ajouterThemes_Livre(Integer id, Set<Theme> set_l_themes) {
		Session s=sf.openSession();
        Transaction tx=null;
        Livre l=null;
        boolean res=false;
        try{ 
            tx = s.beginTransaction(); 
            l=(Livre) s.get(Livre.class, id);
            Set<Theme> st=l.getSet_l_themes();
            //verification si les themes de la Set passées existent déja dans le livre 
            Iterator<Theme> it=set_l_themes.iterator();
            while(it.hasNext()){
            	if(!st.contains(it.next())){
            		st.add(it.next());
            	}
            }
            s.update(l);
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
	
	//*************************************************
	public boolean ajouterExamplaires_Livre(Integer id,Set<Examplaire> set_exemplaires) {
		Session s=sf.openSession();
        Transaction tx=null;
        Livre l=null;
        boolean res=false;
        try{ 
            tx = s.beginTransaction(); 
            l=(Livre) s.get(Livre.class, id);
            Set<Examplaire> st=l.getSet_exemplaires();
            Iterator<Examplaire> it=set_exemplaires.iterator();
            while(it.hasNext()){
            	if(!st.contains(it.next())){
            		st.add(it.next());
            	}
            }
            l.setNbr_exemplaires(l.getSet_exemplaires().size());
            s.update(l);
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
	
	 //************************************************
	public ArrayList<Livre> getAllLivresViaTheme(Theme theme) {
		Session s=sf.openSession();
        Transaction tx=null;
        ArrayList<Livre> lst_livres=new ArrayList<Livre>();
        try{ 
            tx=s.beginTransaction();
            lst_livres=(ArrayList<Livre>) s.createQuery("FROM Livre").list();
            tx.commit();
            Iterator<Livre> it=lst_livres.iterator();
            while(it.hasNext()){
            	if(!it.next().getSet_l_themes().contains(theme)){
            		it.remove();
            	}
            }
         }catch (HibernateException e) { 
             if (tx!=null) tx.rollback();
             e.printStackTrace();
         }finally { 
             s.close(); 
         }
 			return lst_livres;	
	}
}

	
