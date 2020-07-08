package com.website.qlts.repository;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.CategoryAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface AssetsRepository extends JpaRepository<Assets, Long> {
    @Query(value = "SELECT * FROM assets c WHERE c.status != 4 AND c.is_deleted = 0", nativeQuery = true)
    public List<Assets> getAll();

    @Query(value = "SELECT * FROM assets c WHERE c.status = ? AND c.is_deleted = 0", nativeQuery = true)
    public List<Assets> getByStatus(int status);

    @Query(value = "SELECT * FROM assets c WHERE c.department_id = ? AND c.is_deleted = 0", nativeQuery = true)
    public List<Assets> getByDepartmentsId(long department_id);

    @Query(value = "SELECT * FROM assets c WHERE c.group_assets_id = ? AND c.is_deleted = 0", nativeQuery = true)
    public List<Assets> getByGroupId(long group_assets_id);

    @Query(value = "SELECT * FROM assets c WHERE c.asset_category_id = ? AND c.is_deleted = 0", nativeQuery = true)
    public List<Assets> getByCateId(long asset_category_id);

    @Query(value = "SELECT * FROM assets c WHERE c.name like %:name% AND c.is_deleted = 0", nativeQuery = true)
    public List<Assets> getByName(@Param("name")String name);

    @Query(value = "SELECT * FROM assets c WHERE c.staff_id = 0 AND c.is_deleted = 0", nativeQuery = true)
    public List<Assets> getAllWithDepart();

    @Query(value = "SELECT * FROM assets c WHERE c.department_id = 0 AND c.is_deleted = 0", nativeQuery = true)
    public List<Assets> getAllWithStaff();
}
