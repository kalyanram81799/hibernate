package com.rvr.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rvr.model.Student;

public class LaunchFirst {
public static void main(String args[]) {
	Configuration config=null;
	SessionFactory sessionfactory=null;
	Session session=null;
	Transaction transaction=null;
	boolean flag=false;
	config =new Configuration();
	config.configure();
	sessionfactory=config.buildSessionFactory();
	session=sessionfactory.openSession();
	Student s=new Student();
	s.setsid(2);
	s.setscity("Ongole");
	s.setsname("nandu");
	try {
		transaction=session.beginTransaction();
		session.persist(s);
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
		else {
			transaction.rollback();
		}
	}
}
}
