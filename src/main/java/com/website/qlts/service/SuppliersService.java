package com.website.qlts.service;

import com.website.qlts.entity.CategoriesSupplier;
import com.website.qlts.entity.Suppliers;
import com.website.qlts.repository.SuppliersReposiotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public void insertWithQuery(String name,String address, String phoneNumber, long id) {
//        entityManager.createNativeQuery("INSERT INTO suppliers (name, address, phone_number,supplier_category_id) VALUES (?,?,?,?)")
//                .setParameter(1, name)
//                .setParameter(2, address)
//                .setParameter(3, phoneNumber)
//                .setParameter(4,id)
//                .executeUpdate();
//    }
}
