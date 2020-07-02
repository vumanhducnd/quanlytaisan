package com.website.qlts.service.impl;

import com.website.qlts.config.CreateQRCodeConfig;
import com.website.qlts.entity.Assets;
import com.website.qlts.repository.AssetsRepository;
import com.website.qlts.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Service
public class AssetsServiceImpl implements AssetsService {
    @Autowired
    AssetsRepository assetsRepository;

    @Override
    public List<Assets> getAll() {
        return assetsRepository.findAll();
    }

    @Override
    public Assets create(String name, String description, int amount, String condition, int status, long price, String position, long departmentId, long cateId, long groupId, long suppId) {
        Assets assets = new Assets(name, description, amount, condition, status, price, position, departmentId, cateId, groupId, suppId);
        return assetsRepository.save(assets);
    }

    @Override
    public Assets findById(long id) {
        return assetsRepository.findById(id).orElse(null);
    }

    @Override
    public void makeUrl(String url, long id) {
        String[] listUrl = url.split("/assets/createQRCode/", url.length() - 1);
        CreateQRCodeConfig createQRCodeConfig = new CreateQRCodeConfig();
        createQRCodeConfig.createQrCodeAssets(listUrl[0] + "/assets/detail/" + id, id);
    }
}
