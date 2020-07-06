package com.website.qlts.service.impl;

import com.website.qlts.entity.Departments;
import com.website.qlts.repository.DepartmentsRepository;
import com.website.qlts.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
    @Autowired
    DepartmentsRepository departmentsRepository;
    @Override
    public List<Departments> getAll() {
        return departmentsRepository.getAll();
    }

    @Override
    public List<Departments> getByParentId(int id) {
        return null;
    }

    @Override
    public List<Departments> getByChildId(int id) {
        return null;
    }
}
