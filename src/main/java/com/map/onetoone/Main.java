package com.map.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

        //creating Question
        Question q1=new Question();
        q1.setQuestionId(101);
        q1.setQuestion("What is Java");
        //creating Answer
        Answer a1=new Answer();
        a1.setAnswerId(5001);
        a1.setAnswer("Java is a powerful programing language");
        a1.setQuestion(q1);
        q1.setAnswer(a1);


        //creating Question
        Question q2=new Question();
        q2.setQuestionId(102);
        q2.setQuestion("What is Collection Framework");
        //creating Answer
        Answer a2=new Answer();
        a2.setAnswerId(5002);
        a2.setAnswer("API to work with group of objects");
        a2.setQuestion(q2);
        q2.setAnswer(a2);


        //Session
        Session session= factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(a1);
        session.save(a2);
        session.save(q1);
        session.save(q2);

        tx.commit();

//        Question newQ=session.get(Question.class,101);
//        System.out.println(newQ.getQuestion()+"\n"+newQ.getAnswer().getAnswer());
        session.close();
        factory.close();
    }
}
