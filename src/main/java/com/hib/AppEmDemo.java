package com.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppEmDemo {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        Student student1=new Student();
        student1.setId(1);
        student1.setName("Tarun");
        student1.setCity("Paonta Sahib");
        student1.setCertificate(new Certificate("Java","4 months"));


        Student student2=new Student();
        student2.setId(2);
        student2.setName("Mehak");
        student2.setCity("Ludhiana");
        student2.setCertificate(new Certificate("Spring","6 months"));

        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();

        session.save(student1);
        session.save(student2);
        tx.commit();

        session.close();
        factory.close();
    }
}
