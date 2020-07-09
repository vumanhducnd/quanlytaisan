package com.website.qlts.service.impl;

import com.website.qlts.entity.RepairHistory;
import com.website.qlts.repository.RepairsHistoryRepository;
import com.website.qlts.service.RepairsHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairsHistoryServiceImpl implements RepairsHistoryService {

    @Autowired
    private RepairsHistoryRepository repairsHistoryRepository;

    @Override
    public void save(RepairHistory repairsHistory){
        repairsHistoryRepository.save(repairsHistory);
    }
}
