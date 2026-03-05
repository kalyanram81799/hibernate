package com.rvr.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rvr.app.Passport;
import com.rvr.app.Person;

public class LaunchApp {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Person.class);
        cfg.addAnnotatedClass(Passport.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();

        Person p = new Person();
        p.setPersonId(1);
        p.setName("Kalyan");

        Passport pass = new Passport();
        pass.setPassportId(101);
        pass.setPassportNumber("IND12345");

        p.setPassport(pass);
        pass.setPerson(p);

        session.save(p);

        session.getTransaction().commit();
        session.close();

        System.out.println("Data inserted successfully");
    }
}