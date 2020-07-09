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
    public Departments create(String name) {
        Departments departments = new Departments();
        departments.setDepartmentName(name);
        departmentsRepository.save(departments);
        return null;
    }

    @Override
    public List<Departments> getAll() {
        return departmentsRepository.getAll();
    }

    @Override
    public Departments getById(long id) {
        return null;
    }

    @Override
    public void update(long id, String name) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Departments> getByName(String name) {
        return null;
    }
}

