package com.website.qlts.controller;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.RepairHistory;
import com.website.qlts.entity.RevokeHistory;
import com.website.qlts.entity.SellAsset;
import com.website.qlts.service.*;
import com.website.qlts.view.AssetRevoke;
import com.website.qlts.view.AssetsView;
import com.website.qlts.view.SellView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    RevokeHistoryService revokeHistoryService;

    @Autowired
    RepairsHistoryService repairsHistoryService ;

    @Autowired
    SellAssetService sellAssetService;

    @Autowired
    TransferService transferService;
    @RequestMapping(value = "")
    public String assetsPage(Model model, String keyWord, String status, String categoryAssets, String groupAssets) {
        AssetsView assets;
        if (keyWord == null && status == null && categoryAssets == null && groupAssets == null) {
            assets = setAssetView(new Assets());
            model.addAttribute("model", assets);
        } else {
            if (keyWord != null) {
                assets = setAssetView(new Assets());
                assets.setAssetsList(assetsService.getByName(keyWord));
                model.addAttribute("model", assets);
            }
            if (!status.contains("-1")) {
                assets = setAssetView(new Assets());
                assets.setAssetsList(assetsService.getByStatus(Integer.parseInt(status)));
                model.addAttribute("model", assets);
            }
            if (!categoryAssets.contains("-1")) {
                assets = setAssetView(new Assets());
                assets.setAssetsList(assetsService.getByCateAsset(Integer.parseInt(categoryAssets)));
                model.addAttribute("model", assets);
            }
            if (!groupAssets.contains("-1")) {
                assets = setAssetView(new Assets());
                assets.setAssetsList(assetsService.getByGroupAsset(Integer.parseInt(groupAssets)));
                model.addAttribute("model", assets);
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
    public String createPage( @RequestParam("suppliers") String suppliers, @RequestParam("groupAssets") String groupAssets,
                             @RequestParam("categoryAssets") String categoryAssets, @Valid @ModelAttribute("model") AssetsView assetsView, BindingResult result) {
        if(result.hasErrors()){
            return "pages/assets/create";
        }
        assetsService.create(assetsView.getAssets().getName(), assetsView.getAssets().getDescription(), assetsView.getAssets().getAmount(),
                assetsView.getAssets().getConditionAsset(), assetsView.getAssets().getStatus(), assetsView.getAssets().getPrice(),
                assetsView.getAssets().getPosition(),
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

    @RequestMapping("/repair/{id}")
    public String repair(Model model, @PathVariable("id") long id) {
        Assets assets = assetsService.findById(id);
        model.addAttribute("model",assets);
        return "pages/assets/repair";
    }

    @RequestMapping(value ="/repair/{id}", method = RequestMethod.POST)
    public String repair( Model model, @PathVariable("id") long id,
                          @RequestParam("startAt") String startAt,
                          @RequestParam("endAt") String endAt,
                          @RequestParam("description") String description) {
        RepairHistory repairHistory = new RepairHistory();
        Assets assets = assetsService.findById(id);
            repairHistory.setAssetId(id);
            repairHistory.setDepartmentId(assets.getDepartment_id());
            repairHistory.setStaffId(assets.getStaff_id());
            repairHistory.setStartAt(convertStringToDate(startAt));
            repairHistory.setEndAt(convertStringToDate(endAt));
            repairHistory.setDescription(description);
            repairsHistoryService.save(repairHistory);
            assetsService.updateRepair(id);
        return "redirect:/assets";
    }

    @RequestMapping("/repair/history")
    public String repairHistory(Model model){
        model.addAttribute("model",repairsHistoryService.getAll());
        return "pages/assets/repair-history";
    }

    @RequestMapping(value = "/revoke/{id}")
    public String revoke(Model model, @PathVariable("id") long id) {
        Assets assets = assetsService.findById(id);
        AssetRevoke assetRevoke = new AssetRevoke();
        assetRevoke.setAssets(assets);
        assetRevoke.setRevokeHistory(new RevokeHistory());
        model.addAttribute("model", assetRevoke);
        return "pages/assets/revoke";
    }

    @RequestMapping(value = "/revoke/{id}", method = RequestMethod.POST)
    public String revoke(@PathVariable("id") long id, @RequestParam("reason") String reason) {
        assetsService.updateStatusRevoke(id);
        Assets assets = assetsService.findById(id);
        revokeHistoryService.createHistory(id, assets.getStaff_id(), assets.getDepartment_id(), reason, new Date());
        return "redirect:/assets/action";
    }

    @RequestMapping("/inventory")
    public String inventory() {
        return "pages/assets/inventory";
    }

    @RequestMapping("/sell/{id}")
    public String sell(Model model, @PathVariable("id") long id) {
        SellView sellView = new SellView();
        sellView.setAsset(assetsService.findById(id));
        sellView.setSellAsset(new SellAsset());
        model.addAttribute("model", sellView);
        return "pages/assets/sell";
    }

    @RequestMapping(value = "/sell/{id}", method = RequestMethod.POST)
    public String sell(@PathVariable("id") long id,@RequestParam("newPrice") String newPrice, @RequestParam("note") String note,
                       @RequestParam("person") String person, @RequestParam("phoneNumber") String phoneNumber) {
        SellAsset sellAsset = new SellAsset();
        sellAsset.setAssetId(id);
        sellAsset.setPriceSell(Long.parseLong(newPrice.trim()));
        sellAsset.setName(person);
        sellAsset.setNote(note);
        sellAsset.setPhoneNumber(phoneNumber);
        sellAsset.setCreatedDate(new Date());
        sellAssetService.createSellAsset(sellAsset);
        assetsService.updateStatus(id);
        return "pages/assets/sell-history";
    }

    @RequestMapping("/revoke/history")
    public String revokePage(Model model){
        List<RevokeHistory> revokeHistories;
        revokeHistories = revokeHistoryService.getAll();
        model.addAttribute("model", revokeHistories);
        return "pages/assets/revoke-history";
    }

    @RequestMapping("/sell/history")
    public String assetSellPage(Model model){
        model.addAttribute("model",sellAssetService.getAll());
        return "pages/assets/sell-history";
    }

    @RequestMapping("/action")
    public String action(Model model) {
        model.addAttribute("model", assetsService.getAssetsNoRevoke());
        return "pages/assets/action";
    }

    @RequestMapping("/used-history")
    public String history(Model model) {
        model.addAttribute("model",transferService.getAll());
        return "pages/assets/used-history";
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

    public Date convertStringToDate(String dateString){
        Date date = new Date();
        try {
            date=new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        }catch (Exception ex){
        }
        return date;
    }
}
