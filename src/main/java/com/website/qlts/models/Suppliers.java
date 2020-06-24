package com.website.qlts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Suppliers implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private String phoneNumber;
    private long supplierCategoryId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Suppliers() {
    }

    public Suppliers(String name, String address, String phoneNumber, long supplierCategoryId) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.supplierCategoryId = supplierCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getSupplierCateogryId() {
        return supplierCategoryId;
    }

    public void setSupplierCateogryId(long supplierCategoryId) {
        this.supplierCategoryId = supplierCategoryId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
