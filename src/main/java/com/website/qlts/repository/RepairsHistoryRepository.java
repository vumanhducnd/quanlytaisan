package com.website.qlts.repository;

import com.website.qlts.entity.RepairHistory;
import com.website.qlts.entity.SellAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepairsHistoryRepository extends JpaRepository<RepairHistory,Long> {
    @Query(value = "SELECT * FROM repair_history c WHERE   c.is_deleted = 0", nativeQuery = true)
    public List<RepairHistory> getAll();
}
