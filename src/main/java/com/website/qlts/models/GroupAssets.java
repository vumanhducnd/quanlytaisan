package com.website.qlts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class GroupAssets implements Serializable {
    private static final long serialVersionUID = 1L;
    private String groupName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public GroupAssets(String groupName) {
        this.groupName = groupName;
    }

    public GroupAssets() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
