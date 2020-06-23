package com.website.qlts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class AppRole implements Serializable {
    private long roleName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public AppRole(long roleName, long id) {
        this.roleName = roleName;
        this.id = id;
    }

    public AppRole() {
    }

    public long getRoleName() {
        return roleName;
    }

    public void setRoleName(long roleName) {
        this.roleName = roleName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
