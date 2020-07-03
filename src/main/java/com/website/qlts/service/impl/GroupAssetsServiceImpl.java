package com.website.qlts.service.impl;

import com.website.qlts.entity.GroupAssets;
import com.website.qlts.repository.GroupAssetsRepository;
import com.website.qlts.service.GroupAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupAssetsServiceImpl implements GroupAssetsService {
    @Autowired
    GroupAssetsRepository groupAssetsRepository;

    public GroupAssets create(String name) {
        return groupAssetsRepository.save(new GroupAssets(name));
    }

    public List<GroupAssets> getAll() {
        return groupAssetsRepository.findAll();
    }

    public GroupAssets getById(long id) {
        return groupAssetsRepository.findById(id).orElse(null);
    }

    public void update(long id, String name) {
        Optional<GroupAssets> groupAssets = groupAssetsRepository.findById(id);
        groupAssets.get().setGroupName(name);
        groupAssetsRepository.save(groupAssets.get());
    }

    public void delete(long id) {
        Optional<GroupAssets> categoryAssets = groupAssetsRepository.findById(id);
        groupAssetsRepository.delete(categoryAssets.get());
    }

    public List<GroupAssets> getByName(String name) {
        List<GroupAssets> groupAssets = groupAssetsRepository.getByName(name);
        return groupAssets;
    }
}
