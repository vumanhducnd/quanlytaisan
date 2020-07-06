package com.website.qlts.entity;

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
    private int is_deleted;

    @Column(name = "department_id", unique = false)
    private long departmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", updatable = false, insertable = false, unique = false)
    private Departments departments;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Staffs(String name, Date dateOfBirth, String address, String phoneNumber, int is_deleted, long departmentId) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.is_deleted = is_deleted;
        this.departmentId = departmentId;
    }

    public Staffs() {
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
