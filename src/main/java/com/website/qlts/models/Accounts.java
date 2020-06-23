package com.website.qlts.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Accounts implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String passWord;
    private long staffId;
    @Transient
    private String passwordConfirm;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToMany
    private Set<Role> roles;
    public Accounts(String userName, long staffId, String passWord, long id) {
        this.userName = userName;
        this.staffId = staffId;
        this.passWord = passWord;
        this.id = id;
    }

    public Accounts() {
        id = 0;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
