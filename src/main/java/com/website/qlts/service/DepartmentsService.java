package com.website.qlts.service;

import com.website.qlts.entity.Departments;
import com.website.qlts.repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentsService  {
    public List<Departments> getAll();

    public List<Departments> getByParentId(int id);

    public List<Departments> getByChildId(int id);
}
