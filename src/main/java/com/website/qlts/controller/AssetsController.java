package com.website.qlts.controller;

import com.website.qlts.models.Assets;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/assets")
public class AssetsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String assetsPage(Model model){
        model.addAttribute("model",new Assets());
        return "pages/assets/index";
    }
}
