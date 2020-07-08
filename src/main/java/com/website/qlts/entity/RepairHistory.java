package com.website.qlts.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class RepairHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "asset_id", unique = false)
    private long assetId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", updatable = false, insertable = false, unique = false)
    private Assets assets;

    @Column(name = "staff_id", unique = false)
    private long staffId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", updatable = false, insertable = false, unique = false)
    private Staffs staffs;

    private Date endAt;
    private Date startAt;
    public RepairHistory(long id, long assetId, Assets assets, long staffId, Staffs staffs) {
        this.id = id;
        this.assetId = assetId;
        this.assets = assets;
        this.staffId = staffId;
        this.staffs = staffs;
    }

    public RepairHistory() {
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public Staffs getStaffs() {
        return staffs;
    }

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }
}
