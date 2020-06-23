package com.website.qlts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Staffs implements Serializable {
    private static final long serialVersionUID = 1L;
    private  String name;
    private Date dateOfBirht;
    private String address;
    private String phoneNumber;
    private long departmentId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Staffs(String name, Date dateOfBirht, String address, String phoneNumber, long departmentId, long id) {
        this.name = name;
        this.dateOfBirht = dateOfBirht;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.departmentId = departmentId;
        this.id = id;
    }

    public Staffs() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirht() {
        return dateOfBirht;
    }

    public void setDateOfBirht(Date dateOfBirht) {
        this.dateOfBirht = dateOfBirht;
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
