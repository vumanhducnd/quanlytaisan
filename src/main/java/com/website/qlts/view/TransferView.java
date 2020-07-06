package com.website.qlts.view;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.Staffs;

import java.util.List;

public class TransferView {
    private List<Staffs> staffsList;
    private List<Assets> assetsList;

    public TransferView(List<Staffs> staffsList, List<Assets> assetsList) {
        this.staffsList = staffsList;
        this.assetsList = assetsList;
    }

    public List<Staffs> getStaffsList() {
        return staffsList;
    }

    public void setStaffsList(List<Staffs> staffsList) {
        this.staffsList = staffsList;
    }

    public List<Assets> getAssetsList() {
        return assetsList;
    }

    public void setAssetsList(List<Assets> assetsList) {
        this.assetsList = assetsList;
    }

    public TransferView() {
    }
}
