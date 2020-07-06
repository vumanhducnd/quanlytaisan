package com.website.qlts.controller;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.website.qlts.entity.Assets;
import com.website.qlts.entity.Suppliers;
import com.website.qlts.repository.CategoryAssetsRepository;
import com.website.qlts.repository.DepartmentsRepository;
import com.website.qlts.repository.GroupAssetsRepository;
import com.website.qlts.repository.SuppliersReposiotory;
import com.website.qlts.service.*;
import com.website.qlts.view.AssetsView;
import com.website.qlts.view.SellView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/assets")
public class AssetsController {
    @Autowired
    AssetsService assetsService;

    @Autowired
    CategoryAssetsService categoryAssetsService;

    @Autowired
    DepartmentsService departmentsService;

    @Autowired
    SuppliersService suppliersService;

    @Autowired
    GroupAssetsService groupAssetsService;

    @Autowired
    HistoryService historyService;

    @RequestMapping(value = "")
    public String assetsPage(Model model,String keyWord, String status,String departments, String categoryAssets, String groupAssets) {
        AssetsView assets ;
        if(keyWord == null && status == null && departments == null && categoryAssets == null && groupAssets == null){
            assets = setAssetView(new Assets());
            model.addAttribute("model",assets);
        }
        else {
            if(keyWord != null){
                assets = setAssetView(new Assets());
                assets.setAssetsList(assetsService.getByName(keyWord));
                model.addAttribute("model",assets);
            }
            if(!status.contains("-1")){
                assets = setAssetView(new Assets());
                assets.setAssetsList(assetsService.getByStatus(Integer.parseInt(status)));
                model.addAttribute("model",assets);
            }
            if(!categoryAssets.contains("-1")){
                assets = setAssetView(new Assets());
                assets.setAssetsList(assetsService.getByCateAsset(Integer.parseInt(categoryAssets)));
                model.addAttribute("model",assets);
            }
            if(!departments.contains("-1")){
                assets = setAssetView(new Assets());
                assets.setAssetsList(assetsService.getByDeparment(Integer.parseInt(departments)));
                model.addAttribute("model",assets);
            }
            if(!groupAssets.contains("-1")){
                assets = setAssetView(new Assets());
                assets.setAssetsList(assetsService.getByGroupAsset(Integer.parseInt(groupAssets)));
                model.addAttribute("model",assets);
            }
        }

        return "pages/assets/index";
    }

    @RequestMapping(value = "/create")
    public String createPage(Model model) {
        AssetsView assetsView = setAssetView(new Assets());
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
        Assets asset = assetsService.findById(id);
        AssetsView assetsView = setAssetView(asset);
        model.addAttribute("model", assetsView);
        return "pages/assets/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute AssetsView assetsView, @PathVariable("id") long id,
                         @RequestParam("suppliers") long suppliers, @RequestParam("departments") long departments,
                         @RequestParam("groupAssets") long groupAssets, @RequestParam("categoryAssets") long categoryAssets) {
        assetsService.update(id, assetsView, suppliers, departments, groupAssets, categoryAssets);
        return "redirect:/assets";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        assetsService.delete(id);
        return "redirect:/assets";
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

    @RequestMapping("/transfer")
    public String transfer() {
        return "pages/assets/transfer";
    }

    @RequestMapping("/revoke")
    public String revoke() {
        return "pages/assets/revoke";
    }

    @RequestMapping("/inventory")
    public String inventory() {
        return "pages/assets/inventory";
    }

    @RequestMapping("/sell")
    public String sell(Model model) {
        SellView sellView = new SellView();
        model.addAttribute("model", assetsService.getAll());
        return "pages/assets/sell";
    }

    @RequestMapping(value = "/sell-view", method = RequestMethod.POST)
    public String sell(Model model, @RequestParam("checkBox") String checkBox,@RequestParam("priceNew") String price, @ModelAttribute Assets assets) {
        if (checkBox != null) {
            model.addAttribute("model", assetsService.sell(checkBox, price));
        }
        return "pages/assets/sell-view";
    }

    @RequestMapping(value = "/sell-assets", method = RequestMethod.POST)
    public String sell(@ModelAttribute SellView assets) {
        assetsService.assetSell();

        return "redirect:/assets";
    }

    @RequestMapping("/used-history")
    public String history() {
        return "pages/assets/history";
    }

    public AssetsView setAssetView(Assets assets) {
        AssetsView assetsView = new AssetsView();
        if (assets != null) {
            assetsView.setAssets(assets);
        } else {
            assetsView.setAssets(new Assets());
        }
        assetsView.setAssetsList(assetsService.getAll());
        assetsView.setCategoryAssetsList(categoryAssetsService.getAll());
        assetsView.setDepartmentsList(departmentsService.getAll());
        assetsView.setSuppliersList(suppliersService.getAll());
        assetsView.setGroupAssetsList(groupAssetsService.getAll());
        return assetsView;
    }
}
