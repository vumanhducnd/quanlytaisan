package com.website.qlts.models;

import org.springframework.boot.SpringApplication;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Staffs implements Serializable {
    private static final long serialVersionUID = 1L;
    private  String name;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private long departmentId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public Staffs(String name, Date dateOfBirth, String address, String phoneNumber, long departmentId) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.departmentId = departmentId;
    }

    public Staffs() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
