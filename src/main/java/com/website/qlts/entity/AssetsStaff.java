package com.website.qlts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class AssetsStaff implements Serializable {
    private static final long serialVersionUID = 1L;
    private long assetId;
    private long staffId;
    private String reason;
    private int isHistory;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public AssetsStaff(long assetId, long staffId, String reason, int isHistory) {
        this.assetId = assetId;
        this.staffId = staffId;
        this.reason = reason;
        this.isHistory = isHistory;
    }

    public AssetsStaff() {
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getIsHistory() {
        return isHistory;
    }

    public void setIsHistory(int isHistory) {
        this.isHistory = isHistory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
