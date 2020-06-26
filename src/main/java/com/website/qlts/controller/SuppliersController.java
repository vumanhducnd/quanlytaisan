package com.website.qlts.controller;

import com.website.qlts.models.Suppliers;
import com.website.qlts.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SuppliersController {
    @Autowired
    SuppliersService suppliersService;
    @RequestMapping("")
    public String indexPage(Model model,String keyWord){
        List<Suppliers> list;
        if(keyWord != null){
            list = suppliersService.getByName(keyWord);
        }
        else {
            list = suppliersService.getAll();
        }
        model.addAttribute("sup",list);
        return "pages/suppliers/index";
    }
}
