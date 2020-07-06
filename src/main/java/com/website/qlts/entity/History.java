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
    private long price;
    private Date startDate;
    private Date endDate;
    private int is_deleted;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public History(long assetId, long staffId, String reason, int status, long price, Date startDate, Date endDate, int is_deleted) {
        this.assetId = assetId;
        this.staffId = staffId;
        this.reason = reason;
        this.status = status;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.is_deleted = is_deleted;
    }

    public History() {
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
