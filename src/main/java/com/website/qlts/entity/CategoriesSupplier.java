package com.website.qlts.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class CategoriesSupplier implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
//    @OneToMany(mappedBy = "categoriesSupplier", targetEntity = Suppliers.class)
//    private List<Suppliers> suppliersList;
    public CategoriesSupplier(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public CategoriesSupplier() {
    }

    public CategoriesSupplier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
