package com.website.qlts.repository;

import com.website.qlts.models.CategoryAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryAssetsRepository extends JpaRepository<CategoryAssets,Long> {

}
