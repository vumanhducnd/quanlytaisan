package com.website.qlts.repository;

import com.website.qlts.models.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AssetsRepository  extends JpaRepository<Assets,Long> {
}
