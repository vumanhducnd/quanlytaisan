package com.website.qlts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class CategoriesSupplier implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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
