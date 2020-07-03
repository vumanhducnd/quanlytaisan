package com.website.qlts.service.impl;

import com.website.qlts.config.CreateQRCodeConfig;
import com.website.qlts.entity.Assets;
import com.website.qlts.repository.AssetsRepository;
import com.website.qlts.service.AssetsService;
import com.website.qlts.view.AssetsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void delete(long id) {
        Assets assets = assetsRepository.findById(id).orElse(null);
        if( assets != null){
            assetsRepository.delete(assets);
        }
    }

    @Override
    public void update(long id, AssetsView assetsView, long suppliersId, long departmentsId, long groupAssetsId, long categoryAssetsId) {
        Assets assets = assetsRepository.findById(id).orElse(null);
        if(assets != null){
            assets.setName(assetsView.getAssets().getName());
            assets.setDescription(assetsView.getAssets().getDescription());
            assets.setAmount(assetsView.getAssets().getAmount());
            assets.setConditionAsset(assetsView.getAssets().getConditionAsset());
            assets.setPosition(assetsView.getAssets().getPosition());
            assets.setPrice(assetsView.getAssets().getPrice());
            assets.setStatus(assetsView.getAssets().getStatus());
            assets.setDepartment_id(departmentsId);
            assets.setSupplier_id(suppliersId);
            assets.setGroup_assets_id(groupAssetsId);
            assets.setAsset_category_id(categoryAssetsId);
        }
        assetsRepository.save(assets);
    }
}
