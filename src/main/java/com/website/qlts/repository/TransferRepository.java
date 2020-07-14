package com.website.qlts.repository;

import com.website.qlts.entity.TransferHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransferRepository  extends JpaRepository<TransferHistory,Long> {
    @Query(value = "SELECT * FROM transfer_history c WHERE  c.is_deleted = 0 ORDER BY c.asset_id", nativeQuery = true)
    public List<TransferHistory> getAll();

    @Query(value = "SELECT * FROM transfer_history c WHERE  c.is_deleted = 0 AND c.status = 1", nativeQuery = true)
    public List<TransferHistory> getAllByDepartment();

    @Query(value = "SELECT * FROM transfer_history c WHERE  c.is_deleted = 0 AND c.status = 2", nativeQuery = true)
    public List<TransferHistory> getAllByStaff();

    @Query(value = "SELECT * FROM transfer_history c WHERE  c.is_deleted = 0 AND c.start_date >= ? AND c.end_date <= ?", nativeQuery = true)
    public List<TransferHistory> getAllByDate(Date fromDate, Date toDate);

    @Query(value = "SELECT * FROM transfer_history c WHERE  c.is_deleted = 0 AND c.start_date >= ? AND c.end_date <= ?", nativeQuery = true)
    public List<TransferHistory> getByName(String name);
}
