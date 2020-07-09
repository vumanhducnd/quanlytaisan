package com.website.qlts.repository;

import com.website.qlts.entity.RepairHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairsHistoryRepository extends JpaRepository<RepairHistory,Long> {
}
