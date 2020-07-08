package com.website.qlts.service;

import com.website.qlts.entity.CategoriesSupplier;
import com.website.qlts.repository.CategorySuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CategorySuppliersService {
    public CategoriesSupplier create(String name);

    public List<CategoriesSupplier> getAll();

    public CategoriesSupplier getById(long id);

    public void update(long id, String name);

    public void delete(long id);

    public List<CategoriesSupplier> getByName(String name);
}
