package com.website.qlts.service;

import com.website.qlts.entity.RepairHistory;

import java.util.List;

public interface RepairsHistoryService {
    void save(RepairHistory repairsHistory);
    List<RepairHistory> getAll();
}
