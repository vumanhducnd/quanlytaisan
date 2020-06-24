package com.website.qlts.controller;

import com.website.qlts.models.CategoryAssets;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category-assets")
public class CategoryAssetsController {
    @RequestMapping("")
    public String indexPage(Model model){
        model.addAttribute("cate",new CategoryAssets());
        return "pages/category-assets/index";
    }
}
