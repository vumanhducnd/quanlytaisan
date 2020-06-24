package com.website.qlts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Departments implements Serializable {
    private static final long serialVersionUID = 1L;
    private String departmentName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Departments(String departmentName) {
        this.departmentName = departmentName;
    }

    public Departments() {
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
