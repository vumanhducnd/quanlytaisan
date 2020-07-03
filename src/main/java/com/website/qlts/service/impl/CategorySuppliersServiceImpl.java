package com.website.qlts.service.impl;

import com.website.qlts.entity.CategoriesSupplier;
import com.website.qlts.repository.CategorySuppliersRepository;
import com.website.qlts.service.CategorySuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorySuppliersServiceImpl implements CategorySuppliersService {
    @Autowired
    CategorySuppliersRepository categorySuppliersRepository;

    public CategoriesSupplier create(String name) {
        return categorySuppliersRepository.save(new CategoriesSupplier(name));
    }

    public List<CategoriesSupplier> getAll() {
        return categorySuppliersRepository.findAll();
    }

    public CategoriesSupplier getById(long id) {
        return categorySuppliersRepository.findById(id).orElse(null);
    }

    public void update(long id, String name) {
        Optional<CategoriesSupplier> categoryAssets = categorySuppliersRepository.findById(id);
        categoryAssets.get().setName(name);
        categorySuppliersRepository.save(categoryAssets.get());
    }

    public void delete(long id) {
        Optional<CategoriesSupplier> categoryAssets = categorySuppliersRepository.findById(id);
        categorySuppliersRepository.delete(categoryAssets.get());
    }

    public List<CategoriesSupplier> getByName(String name) {
        List<CategoriesSupplier> assetsList = categorySuppliersRepository.getByName(name);
        return assetsList;
    }
}
