package com.website.qlts.view;

import com.website.qlts.entity.CategoriesSupplier;
import com.website.qlts.entity.Suppliers;

import java.util.List;

public class SuppliersCate {
    private Suppliers suppliers;
    private List<CategoriesSupplier> list;

    public SuppliersCate(Suppliers suppliers, List<CategoriesSupplier> list) {
        this.suppliers = suppliers;
        this.list = list;
    }

    public SuppliersCate() {
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public List<CategoriesSupplier> getList() {
        return list;
    }

    public void setList(List<CategoriesSupplier> list) {
        this.list = list;
    }
}
