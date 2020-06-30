package com.website.qlts.service;

import com.website.qlts.models.CategoriesSupplier;
import com.website.qlts.models.Suppliers;
import com.website.qlts.repository.SuppliersReposiotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuppliersService {
    @Autowired
    SuppliersReposiotory suppliersReposiotory;

    public List<Suppliers> getAll2(){
        return suppliersReposiotory.findAll();
    }

    public List<Suppliers> getAll(){
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

    public Suppliers create(String name,String address,String phoneNumber,CategoriesSupplier categoriesSupplier){
        Suppliers suppliers = new Suppliers(name,address,phoneNumber);
        suppliers.setCategoriesSupplier(categoriesSupplier);
        return  suppliersReposiotory.save(suppliers);
    }
}
