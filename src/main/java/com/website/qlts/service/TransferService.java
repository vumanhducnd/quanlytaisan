package com.website.qlts.service;

import com.website.qlts.entity.TransferHistory;

import java.util.Date;
import java.util.List;

public interface TransferService {
    public List<TransferHistory> getAll();

    public List<TransferHistory> getAllByDepartment();

    public List<TransferHistory> getAllByStaff();

    public TransferHistory getById(long id);



    public void createAndUpdate(String reason,long assetId, long oldDepartmentId, long newDepartmentId, Date startDate, Date endDate, int status);

    public void createAndUpdateWithStaff(String reason,long assetId, long oldDepartmentId, long newDepartmentId, Date startDate, Date endDate, int status);
}