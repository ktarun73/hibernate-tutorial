package com.states;

import com.hib.Certificate;
import com.hib.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    /*
    1. Transient
    2. Persistent
    3. Detached
    4. Removed
    */

    public static void main(String[] args) {

        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Student student=new Student();
        student.setId(1414);
        student.setName("Tarun");
        student.setCity("Paonta Sahib");
        student.setCertificate(new Certificate("Java","6 months"));
        //student is in transient state now


        Session s= factory.openSession();
        Transaction tx= s.beginTransaction();
        s.save(student);
        //student is in persistent state now - session , database
        tx.commit();




        s.close();
        //student is in detach state now



        factory.close();
    }
}
