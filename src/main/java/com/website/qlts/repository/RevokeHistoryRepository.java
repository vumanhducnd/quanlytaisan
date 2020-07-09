package com.website.qlts.repository;

import com.website.qlts.entity.RevokeHistory;
import com.website.qlts.entity.SellAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevokeHistoryRepository extends JpaRepository<RevokeHistory, Long> {
    @Query(value = "SELECT * FROM revoke_history c WHERE   c.is_deleted = 0", nativeQuery = true)
    public List<RevokeHistory> getAll();
}
