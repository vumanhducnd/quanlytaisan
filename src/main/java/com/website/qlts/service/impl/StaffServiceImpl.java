package com.website.qlts.service.impl;

import com.website.qlts.entity.Staffs;
import com.website.qlts.repository.StaffRepository;
import com.website.qlts.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staffs create(Staffs staffs){
        return staffRepository.save(staffs);
    }

    @Override
    public List<Staffs> getAll() {
        return staffRepository.getAll();
    }

    @Override
    public  List<Staffs> getByName(String name){
        List<Staffs> staffsList = staffRepository.getByName(name);
        return  staffsList;
    }

    @Override
    public  void delete(long id){
        Staffs staffs = staffRepository.findById(id).orElse(null);
        staffRepository.delete(staffs);
    }

}
