package com.rvr.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rvr.model.Employee1;

public class LaunchSelective{

    public static void main(String args[]) {

        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        SessionFactory sessionfactory =
                new Configuration()
                        .configure("hibernatecfg..xml")
                        
                        .addAnnotatedClass(Employee1.class)
                        .buildSessionFactory();

        try {
            session = sessionfactory.openSession();
//            transaction = session.beginTransaction();

            // 🔥 Create Employee object
//            Employee1 emp = new Employee1();
//            emp.setEid(101);
//            emp.setEname("kanna");
//            emp.setAge(22);
//            emp.setEcity("Ongole"); // ⚠ Transient (won’t store in DB)
             Employee1 emp=session.get(Employee1.class, 102);
//            session.persist(emp);   // INSERT\
             System.out.println(emp);
//            flag = true;

        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

//            if (flag == true) {
//                transaction.commit();
//                System.out.println("Employee Inserted Successfully ✅");
//            } else {
//                transaction.rollback();
//            }

            session.close();
            sessionfactory.close();
        }
    }
}