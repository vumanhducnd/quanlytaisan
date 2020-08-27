package com.website.qlts.repository;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.CategoryAssets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface AssetsRepository extends JpaRepository<Assets, Long>, JpaSpecificationExecutor<Assets> {
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

    @Query(value = "SELECT * FROM assets c WHERE c.staff_id = 0 AND c.department_id != 0 AND c.status = 1 AND c.is_deleted = 0", nativeQuery = true)
    public List<Assets> getAllWithDepart();

    @Query(value = "SELECT * FROM assets c WHERE c.department_id = 0 AND c.staff_id != 0 AND c.status = 1 AND c.is_deleted = 0", nativeQuery = true)
    public List<Assets> getAllWithStaff();

    @Query(value = "SELECT * FROM assets c WHERE  c.status = 2 AND c.is_deleted = 0", nativeQuery = true)
    public List<Assets> getAssetsNoUse();

    @Query(value = "SELECT * FROM assets c WHERE  c.status != 3 AND c.status != 4 AND c.is_deleted = 0", nativeQuery = true)
    public List<Assets> getAssetsNoRevoke();

    @Query(value = "SELECT * FROM assets as r WHERE MONTH(r.create_date) = ? AND YEAR(r.create_date) = ? AND  r.status = 2 AND r.is_deleted = 0", nativeQuery = true)
    public List<Assets> getAssetsNew(int month, int year);

    @Query(value = "select  * from assets  ORDER BY ID DESC LIMIT 1", nativeQuery = true)
    public Assets getLastRecord();

    @Query(value = "SELECT ID FROM assets c WHERE c.name like %:name% AND c.is_deleted = 0", nativeQuery = true)
    public List<Long> getListIdByName(@Param("name")String name);

    @Query(value = "SELECT * FROM assets c WHERE  c.price >= :pricefrom AND c.price < :priceto AND c.is_deleted = 0", nativeQuery = true)
    public List<Assets> getAssetsbyRangeprice(@Param("pricefrom") long pricefrom,@Param("priceto") long priceto);

    @Query(value = "SELECT * FROM assets c " +
            "WHERE  (c.status = :status or :status is null ) " +
            "AND (c.department_id = :departmentid or :departmentid is null)" +
            "AND (c.staff_id = :staffid or :staffid is null)" +
            "AND (c.create_date >= :datefrom or :datefrom is null) " +
            "AND (c.create_date < :dateto or :dateto is null) " +
            "AND (c.price >= :pricefrom or :pricefrom is null) " +
            "AND (c.price < :priceto or :priceto is null)" +
            "AND c.is_deleted = 0", nativeQuery = true)
    public List<Assets> getByMultilFilter(
            @Param("status") Integer status,
            @Param("departmentid") Long departmentid,
            @Param("staffid") Long staffid,
            @Param("pricefrom") Long pricefrom,
            @Param("priceto") Long priceto,
            @Param("datefrom") Date datefrom,
            @Param("dateto") Date dateto);
}
