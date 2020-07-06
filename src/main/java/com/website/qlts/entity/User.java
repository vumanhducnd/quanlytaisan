package com.website.qlts.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String passWord;
    private String rePassword;
    private long staffId;
    private String role;
    private int status;
    private String permission;
    private int is_deleted;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public User(String userName, String passWord, String rePassword, long staffId, String role, int status, String permission, int is_deleted) {
        this.userName = userName;
        this.passWord = passWord;
        this.rePassword = rePassword;
        this.staffId = staffId;
        this.role = role;
        this.status = status;
        this.permission = permission;
        this.is_deleted = is_deleted;
    }

    public User() {
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
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

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
