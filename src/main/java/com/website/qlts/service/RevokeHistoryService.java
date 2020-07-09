package com.website.qlts.service;

import com.website.qlts.entity.RevokeHistory;

import java.util.Date;
import java.util.List;

public interface RevokeHistoryService {
    public  void createHistory(long assetId, long staffId, long departmentId, String reason, Date revokeDate);

    public List<RevokeHistory> getAll();
}
