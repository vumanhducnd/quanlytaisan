package com.website.qlts.service.impl;

import com.website.qlts.entity.RevokeHistory;
import com.website.qlts.repository.RevokeHistoryRepository;
import com.website.qlts.service.RevokeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RevokeHistoryServiceImpl implements RevokeHistoryService {
    @Autowired
    RevokeHistoryRepository revokeHistoryRepository;

    @Override
    public void createHistory(long assetId, long staffId, long departmentId, String reason, Date revokeDate) {
        RevokeHistory revokeHistory = new RevokeHistory();
        revokeHistory.setAssetId(assetId);
        revokeHistory.setStaffId(staffId);
        revokeHistory.setDepartmentId(departmentId);
        revokeHistory.setReason(reason);
        revokeHistory.setRevokeDate(revokeDate);
        revokeHistoryRepository.save(revokeHistory);
    }

    @Override
    public List<RevokeHistory> getAll() {
        return revokeHistoryRepository.getAll();
    }
}
