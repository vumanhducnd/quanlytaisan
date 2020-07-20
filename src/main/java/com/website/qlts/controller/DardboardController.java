package com.website.qlts.controller;

import com.website.qlts.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DardboardController {
    @Autowired
    private  AssetsService assetsService;
    @RequestMapping("")
    public String dardBoard(Model model){
        model.addAttribute("model",assetsService.getAll());
        return "pages/assets/index";
    }
}
