package com.rvr.model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rvr.app.Course;
import com.rvr.app.Student;

import java.util.HashSet;
import java.util.Set;

public class LaunchApp {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();

        cfg.addAnnotatedClass(Student.class);
        cfg.addAnnotatedClass(Course.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Course c1 = new Course("Java");
        Course c2 = new Course("SQL");

        Set<Course> courses = new HashSet<>();
        courses.add(c1);
        courses.add(c2);

        Student s1 = new Student("Kalyan", courses);
        Student s2 = new Student("Ram", courses);

        session.persist(c1);
        session.persist(c2);
        session.persist(s1);
        session.persist(s2);

        tx.commit();

        session.close();
        factory.close();

        System.out.println("Many to Many Data Inserted");
    }
}