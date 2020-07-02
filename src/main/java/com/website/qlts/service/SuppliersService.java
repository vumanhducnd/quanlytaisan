package com.website.qlts.service;

import com.website.qlts.entity.CategoriesSupplier;
import com.website.qlts.entity.Suppliers;
import com.website.qlts.repository.SuppliersReposiotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuppliersService {
    @Autowired
    SuppliersReposiotory suppliersReposiotory;

    public List<Suppliers> getAll2() {
        return suppliersReposiotory.findAll();
    }

    public List<Suppliers> getAll() {
        return suppliersReposiotory.findAll();
    }

    public List<Suppliers> getByName(String name) {
        List<Suppliers> assetsList = suppliersReposiotory.getByName(name);
        return assetsList;
    }

    public List<CategoriesSupplier> getCate() {
        List<CategoriesSupplier> categoriesSuppliers = suppliersReposiotory.getCate();
        return categoriesSuppliers;
    }

    public Suppliers create(String name, String address, String phoneNumber, long id) {
        Suppliers suppliers = new Suppliers(name, address, phoneNumber,id);
        return suppliersReposiotory.save(suppliers);
    }

    public void update(long id,Suppliers suppliers){
        Suppliers suppliers1 = suppliersReposiotory.findById(id).orElse(null);
        suppliers1.setName(suppliers.getName());
        suppliers1.setAddress(suppliers.getAddress());
        suppliers1.setPhoneNumber(suppliers.getPhoneNumber());
        suppliers1.setSupplier_category_id(suppliers.getSupplier_category_id());
        suppliersReposiotory.save(suppliers1);
    }

    public Suppliers getById(long id){
        return suppliersReposiotory.findById(id).orElse(null);
    }

}
