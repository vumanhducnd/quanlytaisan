package com.website.qlts.controller;

import com.website.qlts.entity.CategoriesSupplier;
import com.website.qlts.entity.Suppliers;
import com.website.qlts.view.SuppliersCate;
import com.website.qlts.service.CategorySuppliersService;
import com.website.qlts.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SuppliersController {
    @Autowired
    SuppliersService suppliersService;
    @Autowired
    CategorySuppliersService categorySuppliersService;

    @RequestMapping("")
    public String indexPage(Model model, String keyWord) {
        List<Suppliers> list;
        if(keyWord != null){
            list = suppliersService.getByName(keyWord);
        }
        else {
        list = suppliersService.getAll2();
        }
        model.addAttribute("sups", list);
        return "pages/suppliers/index";
    }

    @RequestMapping("/create")
    public String createPage(Model model) {
        List<CategoriesSupplier> listAssets;
        listAssets = categorySuppliersService.getAll();
        SuppliersCate suppliersCate = new SuppliersCate();
        suppliersCate.setList(listAssets);
        suppliersCate.setSuppliers(new Suppliers());
        model.addAttribute("listCate",suppliersCate);
        return "pages/suppliers/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPage(@ModelAttribute SuppliersCate suppliers) {
        suppliersService.create(suppliers.getSuppliers().getName(), suppliers.getSuppliers().getAddress(), suppliers.getSuppliers().getPhoneNumber(), Long.parseLong(suppliers.getList().get(0).getName()) ) ;
        return "redirect:/suppliers";
    }
}
