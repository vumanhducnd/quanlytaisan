package com.website.qlts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DardboardController {
    @RequestMapping("")
    public String dardBoard(){
        return "pages/dardboard/index";
    }
}
