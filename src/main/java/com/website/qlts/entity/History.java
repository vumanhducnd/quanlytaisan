package com.website.qlts.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class History implements Serializable {
    private static final long serialVersionUID = 1L;
    private long assetId;
    private long staffId;
    private String reason;
    private int status;
    private Date startDate;
    private Date endDate;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public History(long assetId, long staffId, String reason, int status, Date startDate, Date endDate) {
        this.assetId = assetId;
        this.staffId = staffId;
        this.reason = reason;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public History() {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
