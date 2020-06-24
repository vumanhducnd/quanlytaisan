package com.website.qlts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TransferHistory implements Serializable {
    private String oldPosition;
    private String newPosition;
    private String reason;
    private long oldStaff;
    private long newStaff;
    private long assetId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public TransferHistory(String oldPosition, String newPosition, String reason, long oldStaff, long newStaff, long assetId) {
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
        this.reason = reason;
        this.oldStaff = oldStaff;
        this.newStaff = newStaff;
        this.assetId = assetId;
    }

    public TransferHistory() {
    }

    public String getOldPosition() {
        return oldPosition;
    }

    public void setOldPosition(String oldPosition) {
        this.oldPosition = oldPosition;
    }

    public String getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(String newPosition) {
        this.newPosition = newPosition;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public long getOldStaff() {
        return oldStaff;
    }

    public void setOldStaff(long oldStaff) {
        this.oldStaff = oldStaff;
    }

    public long getNewStaff() {
        return newStaff;
    }

    public void setNewStaff(long newStaff) {
        this.newStaff = newStaff;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(long assetId) {
        this.assetId = assetId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
