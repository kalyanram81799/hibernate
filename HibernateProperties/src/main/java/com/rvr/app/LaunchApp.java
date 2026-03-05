package com.rvr.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rvr.model.Student;

public class LaunchApp {

    public static void main(String[] args) {

        Configuration config = new Configuration();

//        config.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
//        config.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/hibernatedb");
//        config.setProperty("hibernate.connection.username","root");
//        config.setProperty("hibernate.connection.password","rvr@csd");
//        config.setProperty("hibernate.hbm2ddl.auto","update");
//        config.setProperty("hibernate.show_sql","true");
//        config.setProperty("hibernate.format_sql","true");
        config.addAnnotatedClass(Student.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Student student = new Student();
//            student.setsid(8);
            student.setsname("kalyan");
            student.setscity("ongole");

            session.persist(student);   // VERY IMPORTANT

            transaction.commit();
            System.out.println("Student saved successfully!");

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}