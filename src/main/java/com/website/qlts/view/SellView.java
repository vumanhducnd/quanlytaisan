package com.website.qlts.view;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.History;

import java.util.List;

public class SellView {
    private List<Assets> assetsList;
    private History history;
    private long newPrice;

    public SellView(List<Assets> assetsList, History history) {
        this.assetsList = assetsList;
        this.history = history;
    }

    public SellView() {
    }

    public List<Assets> getAssetsList() {
        return assetsList;
    }

    public void setAssetsList(List<Assets> assetsList) {
        this.assetsList = assetsList;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public long getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(long newPrice) {
        this.newPrice = newPrice;
    }
}
