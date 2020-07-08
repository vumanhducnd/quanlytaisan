package com.website.qlts.repository;

import com.website.qlts.entity.TransferHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository  extends JpaRepository<TransferHistory,Long> {
    @Query(value = "SELECT * FROM transfer_history c WHERE  c.is_deleted = 0", nativeQuery = true)
    public List<TransferHistory> getAll();

    @Query(value = "SELECT * FROM transfer_history c WHERE  c.is_deleted = 0 AND c.status = 1", nativeQuery = true)
    public List<TransferHistory> getAllByDepartment();

    @Query(value = "SELECT * FROM transfer_history c WHERE  c.is_deleted = 0 AND c.status = 2", nativeQuery = true)
    public List<TransferHistory> getAllByStaff();
}
