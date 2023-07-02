package com.map.manytomany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Emp {
    @Id
    private int eid;
    @Column(name = "employee_name")
    private String name;
    @ManyToMany
    private List<Project> projects;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Emp() {
    }

    public Emp(int eid, String name, List<Project> projects) {
        this.eid = eid;
        this.name = name;
        this.projects = projects;
    }
}
