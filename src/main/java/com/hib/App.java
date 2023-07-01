package com.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App {
    public static void main(String[] args)throws IOException {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();
        // creating student
        Student student=new Student(1,"Tarun","Paonta Sahib");

        //creating object of address class
        Address address=new Address();
        address.setStreet("street1");
        address.setCity("Delhi");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(123.12);
        FileInputStream fis=new FileInputStream("src/main/resources/image.jpg");
        byte[] image=new byte[fis.available()];
        fis.read(image);
        address.setImage(image);




        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(student);
        session.save(address);
        transaction.commit();
        session.close();
        System.out.println("Done....");
    }
}
