package com.map.manytomany;

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

//        Creating Employee
        Emp emp1=new Emp();
        Emp emp2=new Emp();
        //set e1
        emp1.setEid(101);
        emp1.setName("Tarun");
        //set2
        emp2.setEid(102);
        emp2.setName("Mehak");

        //Creating project
        Project p1=new Project();
        Project p2=new Project();
        //set p1
        p1.setPid(33241);
        p1.setProjectName("Library Management System");
        //set p2
        p2.setPid(321123);
        p2.setProjectName("Chat-Bot");

        //creating list of employees and project
        List<Emp> empList1=new ArrayList<Emp>();
        List<Project> projectList2=new ArrayList<Project>();

        //add employees to list
        empList1.add(emp1);
        empList1.add(emp2);

        //add projects to list
        projectList2.add(p1);
        projectList2.add(p2);

        //assign project to emp1
        emp1.setProjects(projectList2);

        //assign employees to p1
        p1.setEmps(empList1);


        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();
        session.save(emp1);
        session.save(emp2);
        session.save(p1);
        session.save(p2);
        tx.commit();
        Emp emp=session.get(Emp.class,101);
        List<Project> empproject=emp.getProjects();

        System.out.println("Employee "+emp.getEid());
        System.out.println(emp.getName());
        for(Project p:empproject){
            System.out.println(p.getPid()+" : "+p.getProjectName());
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        Project project=session.get(Project.class,33241);
        List<Emp> projectemp=project.getEmps();
        System.out.println("Project "+project.getPid());
        System.out.println(project.getProjectName());
        for(Emp emp3:projectemp){
            System.out.println(emp3.getEid()+" : "+emp3.getName());
        }

        session.close();
        factory.close();

    }
}
