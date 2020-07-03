package com.website.qlts.service;

import com.website.qlts.entity.Assets;
import com.website.qlts.view.AssetsView;

import java.util.List;

public interface AssetsService {

    public List<Assets> getAll();

    public Assets create(String name, String description, int amount, String condition, int status, long price, String position, long departmentId, long cateId, long groupId, long suppId);

    public Assets findById(long id);

    public void makeUrl(String url, long id);

    public void delete(long id);

    public void update(long id, AssetsView assetsView, long suppliersId,long departmentsId, long groupAssetsId, long categoryAssetsId);
}
