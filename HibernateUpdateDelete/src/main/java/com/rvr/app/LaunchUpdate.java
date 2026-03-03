package com.rvr.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rvr.model.Student1;

public class LaunchUpdate {
	public static void main(String args[]) {
      
      
       Session session=null;
       Transaction transaction=null;
       boolean flag=false;
     SessionFactory sessionfactory =new Configuration().configure().addAnnotatedClass(Student1.class).buildSessionFactory();
     
     try {
       session = sessionfactory.openSession();
       transaction=session.beginTransaction();
       Student1 s=new Student1();
       s.setscity("ongole");
       s.setsname("kalyan");
       s.setsid(3);
//       session.saveOrUpdate(s);
       //merge==update in nwe version
       //saveorupdate still works for both but depricated
//       session.delete(s);
       session.remove(s);
       flag=true;
	}
     catch(HibernateException e) {
    	 e.printStackTrace();
    	 
     }
     catch(Exception e) {
    	 e.printStackTrace();
     }
     finally {
    	 if(flag==true)
    	 {
    		 transaction.commit();
    	 }
    	 else
    	 {
    		 transaction.rollback();

    	 }
    	 session.close();
    	 sessionfactory.close();
     }
	}
	
}
