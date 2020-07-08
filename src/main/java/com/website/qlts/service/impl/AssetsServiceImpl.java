package com.website.qlts.service.impl;

import com.website.qlts.config.CreateQRCodeConfig;
import com.website.qlts.entity.Assets;
import com.website.qlts.repository.AssetsRepository;
import com.website.qlts.service.AssetsService;
import com.website.qlts.view.AssetsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AssetsServiceImpl implements AssetsService {
    @Autowired
    AssetsRepository assetsRepository;

    @Override
    public void updateStatus(long id) {
        Assets assets = findById(id);
        assets.setStatus(4);
        assetsRepository.save(assets);
    }

    @Override
    public void assetSell() {
        List<Assets> assetsList = new ArrayList<>();
        for(Long x : listIntId){
            updateStatus(x);
        }
    }

    @Override
    public List<Assets> getByName(String name) {
        return assetsRepository.getByName(name);
    }

    @Override
    public List<Assets> getByStatus(int status) {
        return assetsRepository.getByStatus(status);
    }

    @Override
    public List<Assets> getByDeparment(long id) {
        return assetsRepository.getByDepartmentsId(id);
    }

    @Override
    public List<Assets> getByGroupAsset(long id) {
        return assetsRepository.getByGroupId(id);
    }

    @Override
    public List<Assets> getByCateAsset(long id) {
        return assetsRepository.getByCateId(id);
    }

    @Override
    public List<Assets> sell(String listId,String price) {
        String[] listStringId = listId.split(",");
        String [] listStringPrice = price.split(",");
        List<Assets> assetsList = new ArrayList<>();
        for (String x : listStringPrice){
            if(Long.parseLong(x) != 0){
                listPrice.add(Long.parseLong(x));
            }
        }
        for (String x : listStringId) {
            listIntId.add(Long.parseLong(x));
        }
        for (int i = 0; i < listIntId.size(); i++) {
            Assets assets = findById(listIntId.get(i));
            assets.setSellPrice(listPrice.get(i));
            assetsList.add(assets);
        }
        return assetsList;
    }

    @Override
    public List<Assets> getAll() {
        return assetsRepository.getAll();
    }

    @Override
    public List<Assets> getAllWithDepart() {
        return assetsRepository.getAllWithDepart();
    }

    @Override
    public List<Assets> getAllWithStaff() {
        return assetsRepository.getAllWithStaff();
    }

    @Override
    public Assets create(String name, String description, int amount, String condition, int status, long price, String position, long departmentId, long cateId, long groupId, long suppId) {
        Assets assets = new Assets(name, description, amount, condition, status, price, position, departmentId, cateId, groupId, suppId,0, new Date());
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
        if (assets != null) {
            assets.setIs_deleted(1);
            assetsRepository.save(assets);
        }
    }

    @Override
    public void update(long id, AssetsView assetsView, long suppliersId, long departmentsId, long groupAssetsId, long categoryAssetsId) {
        Assets assets = assetsRepository.findById(id).orElse(null);
        if (assets != null) {
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

    @Override
    public void updateTransferDepart(long id, long departmentId, Date date) {
        Assets assets = assetsRepository.findById(id).orElse(null);
        assets.setDepartment_id(departmentId);
        assets.setUpdatedDate(date);
        assetsRepository.save(assets);
    }

    @Override
    public void updateTransferStaff(long id, long staffId, Date date) {
        Assets assets = assetsRepository.findById(id).orElse(null);
        assets.setStaff_id(staffId);
        assets.setUpdatedDate(date);
        assetsRepository.save(assets);
    }
}
