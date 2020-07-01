package com.website.qlts.controller;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.GroupAssets;
import com.website.qlts.repository.CategoryAssetsRepository;
import com.website.qlts.repository.DepartmentsRepository;
import com.website.qlts.repository.GroupAssetsRepository;
import com.website.qlts.repository.SuppliersReposiotory;
import com.website.qlts.service.AssetsService;
import com.website.qlts.view.AssetsView;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/assets")
@Slf4j
public class AssetsController {
    @Autowired
    GroupAssetsRepository groupAssetsRepository;
    @Autowired
    CategoryAssetsRepository categoryAssetsRepository;
    @Autowired
    SuppliersReposiotory suppliersReposiotory;
    @Autowired
    DepartmentsRepository departmentsRepository;

    @Autowired
    AssetsService assetsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String assetsPage(Model model) {
        model.addAttribute("model", new Assets());
        return "pages/assets/index";
    }

    @RequestMapping(value = "/create")
    public String createPage(Model model) {
        AssetsView assetsView = setAssetView();
        model.addAttribute("model", assetsView);
        return "pages/assets/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPage(@ModelAttribute AssetsView assetsView) {
        assetsService.create(assetsView.getAssets().getName(),assetsView.getAssets().getDescription(),assetsView.getAssets().getAmount(),assetsView.getAssets().getConditionAsset(),assetsView.getAssets().getStatus(),assetsView.getAssets().getPrice(),assetsView.getAssets().getPosition(),Long.parseLong(assetsView.getDepartmentsList().get(0).getDepartmentName()),Long.parseLong(assetsView.getCategoryAssetsList().get(0).getName()),Long.parseLong(assetsView.getGroupAssetsList().get(0).getGroupName()),assetsView.getSuppliersList().get(0).getId());
        return "redirect:/assets";
    }

    public AssetsView setAssetView() {
        AssetsView assetsView = new AssetsView();
        assetsView.setCategoryAssetsList(categoryAssetsRepository.findAll());
        assetsView.setAssets(new Assets());
        assetsView.setDepartmentsList(departmentsRepository.findAll());
        assetsView.setSuppliersList(suppliersReposiotory.findAll());
        assetsView.setGroupAssetsList(groupAssetsRepository.findAll());
        return assetsView;
    }
}
