package com.website.qlts.service;

import com.website.qlts.models.CategoryAssets;
import com.website.qlts.repository.CategoryAssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryAssetsService {
    @Autowired
    CategoryAssetsRepository categoryAssetsRepository;

    public CategoryAssets create(String name) {
        return categoryAssetsRepository.save(new CategoryAssets(name));
    }

    public List<CategoryAssets> getAll() {
        return categoryAssetsRepository.findAll();
    }

    public Optional<CategoryAssets> getById(long id) {
        return categoryAssetsRepository.findById(id);
    }

    public void update(long id, String name) {
        Optional<CategoryAssets> categoryAssets = categoryAssetsRepository.findById(id);
        categoryAssets.get().setName(name);
        categoryAssetsRepository.save(categoryAssets.get());
    }

    public  void delete(long id){
        Optional<CategoryAssets> categoryAssets = categoryAssetsRepository.findById(id);
        categoryAssetsRepository.delete(categoryAssets.get());
    }
    public  List<CategoryAssets> getByName(String name){
        List<CategoryAssets> assetsList = categoryAssetsRepository.getByName(name);
        return  assetsList;
    }

}
