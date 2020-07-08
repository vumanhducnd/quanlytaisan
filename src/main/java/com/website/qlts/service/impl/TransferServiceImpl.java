package com.website.qlts.service.impl;

import com.website.qlts.entity.TransferHistory;
import com.website.qlts.repository.TransferRepository;
import com.website.qlts.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    TransferRepository transferRepository;

    @Override
    public List<TransferHistory> getAll() {
        return transferRepository.getAll();
    }

    @Override
    public List<TransferHistory> getAllByDepartment() {
        return transferRepository.getAllByDepartment();
    }

    @Override
    public List<TransferHistory> getAllByStaff() {
        return transferRepository.getAllByStaff();
    }

    @Override
    public TransferHistory getById(long id) {
        return transferRepository.findById(id).orElse(null);
    }

    @Override
    public void createAndUpdate(String reason,long assetId, long oldDepartmentId, long newDepartmentId, Date startDate, Date endDate, int status) {
        TransferHistory transferHistory = new TransferHistory();
        transferHistory.setAssetId(assetId);
        transferHistory.setDepartmentIdOld(oldDepartmentId);
        transferHistory.setDepartmentIdNew(newDepartmentId);
        transferHistory.setStartDate(startDate);
        transferHistory.setEndDate(endDate);
        transferHistory.setStatus(status);
        transferHistory.setReason(reason);
        transferRepository.save(transferHistory);
    }

    @Override
    public void createAndUpdateWithStaff(String reason, long assetId, long oldStaff, long newStaff, Date startDate, Date endDate, int status) {
        TransferHistory transferHistory = new TransferHistory();
        transferHistory.setAssetId(assetId);
        transferHistory.setStaffIdOld(oldStaff);
        transferHistory.setStaffIdNew(newStaff);
        transferHistory.setStartDate(startDate);
        transferHistory.setEndDate(endDate);
        transferHistory.setStatus(status);
        transferHistory.setReason(reason);
        transferRepository.save(transferHistory);
    }
}
