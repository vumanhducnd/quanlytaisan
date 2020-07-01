package com.website.qlts.service;

import com.website.qlts.entity.Assets;
import com.website.qlts.repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetsService {
    @Autowired
    private AssetsRepository assetsRepository;

    public Assets create(String name,String description, int amount, String condition, int status, long price, String position, long departmentId, long cateId, long groupId, long suppId){
        Assets assets = new Assets(name,description,amount,condition,status,price,position,departmentId,cateId,groupId,suppId);
        return assetsRepository.save(assets);
    }

}
