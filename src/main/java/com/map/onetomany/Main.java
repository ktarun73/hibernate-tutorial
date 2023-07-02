package com.map.onetomany;

import com.map.onetoone.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= cfg.buildSessionFactory();

        //creating Question
        Question2 q1=new Question2();
        q1.setQuestionId(101);
        q1.setQuestion("What is Java");

        //creating Answer1
        Answer2 a1=new Answer2();
        a1.setAnswerId(5001);
        a1.setAnswer("Java is a powerful programing language");
        a1.setQuestion(q1);

        //creating Answer2
        Answer2 a2=new Answer2();
        a2.setAnswerId(5002);
        a2.setAnswer("We can crete computer applications like software, website with Java");
        a2.setQuestion(q1);

        //creating Answer2
        Answer2 a3=new Answer2();
        a3.setAnswerId(5003);
        a3.setAnswer("There are frameworks for Java are available");
        a3.setQuestion(q1);

        List<Answer2> list=new ArrayList<Answer2>();
        list.add(a1);
        list.add(a2);
        list.add(a3);

        q1.setAnswers(list);

        //Session
        Session session= factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(a1);
        session.save(a2);
        session.save(a3);
        session.save(q1);

        tx.commit();

        Question2 question=session.get(Question2.class,101);
        System.out.println(question.getQuestion());
        for(Answer2 a: q1.getAnswers()){
            System.out.println(a.getAnswer());
        }

//        Question newQ=session.get(Question.class,101);
//        System.out.println(newQ.getQuestion()+"\n"+newQ.getAnswer().getAnswer());
        session.close();
        factory.close();
    }
}
