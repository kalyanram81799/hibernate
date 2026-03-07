package com.rvr.model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rvr.app.Department;
import com.rvr.app.Student;

public class LaunchApp {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
//        cfg.configure();
        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Department.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Department dept = new Department("CSE");

        Student s1 = new Student("Kalyan", dept);
        Student s2 = new Student("Ram", dept);
        Student s3 = new Student("Ravi", dept);

        session.persist(dept);
        session.persist(s1);
        session.persist(s2);
        session.persist(s3);

        tx.commit();

        session.close();
        factory.close();

        System.out.println("Data inserted");
    }
}