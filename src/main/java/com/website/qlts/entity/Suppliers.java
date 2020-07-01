package com.website.qlts.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Suppliers implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private String phoneNumber;
    //    private long supplier_category_id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "supplier_category_id")
    private CategoriesSupplier categoriesSupplier;

    public Suppliers() {
    }

    public Suppliers(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
//
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CategoriesSupplier getCategoriesSupplier() {
        return categoriesSupplier;
    }

    public void setCategoriesSupplier(CategoriesSupplier categoriesSupplier) {
        this.categoriesSupplier = categoriesSupplier;
    }

//    public long getSupplier_category_id() {
//        return supplier_category_id;
//    }
//
//    public void setSupplier_category_id(long supplier_category_id) {
//        this.supplier_category_id = supplier_category_id;
//    }
}
