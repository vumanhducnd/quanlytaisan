package com.website.qlts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Assets implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private int amount;
    private String conditionAsset;
    private int status;
    private long price;
    private String position;
    private long departmentId;
    private long assetCategoryId;
    private long groupAssetId;
    private long supplierId;
    private long createdById;
    private long updatedById;
    private long deletedById;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Assets(String name, String description, int amount, String conditionAsset, int status, long price, String position, long departmentId, long assetCategoryId, long groupAssetId, long supplierId) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.conditionAsset = conditionAsset;
        this.status = status;
        this.price = price;
        this.position = position;
        this.departmentId = departmentId;
        this.assetCategoryId = assetCategoryId;
        this.groupAssetId = groupAssetId;
        this.supplierId = supplierId;
    }

    public Assets() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getConditionAsset() {
        return conditionAsset;
    }

    public void setConditionAsset(String conditionAsset) {
        this.conditionAsset = conditionAsset;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public long getAssetCategoryId() {
        return assetCategoryId;
    }

    public void setAssetCategoryId(long assetCategoryId) {
        this.assetCategoryId = assetCategoryId;
    }

    public long getGroupAssetId() {
        return groupAssetId;
    }

    public void setGroupAssetId(long groupAssetId) {
        this.groupAssetId = groupAssetId;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(long createdById) {
        this.createdById = createdById;
    }

    public long getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(long updatedById) {
        this.updatedById = updatedById;
    }

    public long getDeletedById() {
        return deletedById;
    }

    public void setDeletedById(long deletedById) {
        this.deletedById = deletedById;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
