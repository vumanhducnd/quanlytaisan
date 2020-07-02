package com.website.qlts.controller;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.Suppliers;
import com.website.qlts.repository.CategoryAssetsRepository;
import com.website.qlts.repository.DepartmentsRepository;
import com.website.qlts.repository.GroupAssetsRepository;
import com.website.qlts.repository.SuppliersReposiotory;
import com.website.qlts.service.AssetsService;
import com.website.qlts.view.AssetsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/assets")
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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String assetsPage(Model model) {
        model.addAttribute("model", assetsService.getAll());
        return "pages/assets/index";
    }

    @RequestMapping(value = "/create")
    public String createPage(Model model) {
        AssetsView assetsView = setAssetView();
        model.addAttribute("model", assetsView);
        return "pages/assets/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPage(@ModelAttribute AssetsView assetsView, @RequestParam("suppliers") String suppliers,
                             @RequestParam("departments") String departments, @RequestParam("groupAssets") String groupAssets,
                             @RequestParam("categoryAssets") String categoryAssets) {
        assetsService.create(assetsView.getAssets().getName(), assetsView.getAssets().getDescription(), assetsView.getAssets().getAmount(),
                assetsView.getAssets().getConditionAsset(), assetsView.getAssets().getStatus(), assetsView.getAssets().getPrice(),
                assetsView.getAssets().getPosition(), Long.parseLong(departments),
                Long.parseLong(categoryAssets),
                Long.parseLong(groupAssets),
                Long.parseLong(suppliers));
        return "redirect:/assets";
    }

    @RequestMapping("/edit/{id}")
    public String editPage(Model model, @PathVariable("id") long id) {
        Assets assets = assetsService.findById(id);
        model.addAttribute("model",assets);
        return "pages/assets/edit";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model, @PathVariable("id") long id) {
        Assets assets = assetsService.findById(id);
        model.addAttribute("model", assets);
        return "pages/assets/detail";
    }

    @RequestMapping(value = "/createQRCode/{id}", method = RequestMethod.GET)
    public String createQRCode(Model model, HttpServletRequest request, @PathVariable("id") long id) {
        String a = request.getRequestURL().toString();
        assetsService.makeUrl(request.getRequestURL().toString(), id);
        model.addAttribute("model", assetsService.findById(id));
        return "pages/assets/qr-code";
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
