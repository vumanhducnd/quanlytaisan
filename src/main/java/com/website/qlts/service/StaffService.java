package com.website.qlts.service;

import com.website.qlts.entity.Staffs;

import java.util.List;

public interface StaffService {
    public Staffs create(Staffs staffs);

    public List<Staffs> getAll();

    public List<Staffs> getByName(String name);

    public void delete(long id);
}
