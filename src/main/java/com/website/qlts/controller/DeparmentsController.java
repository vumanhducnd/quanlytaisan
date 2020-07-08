package com.website.qlts.controller;

import com.website.qlts.entity.Departments;
import com.website.qlts.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DeparmentsController {
//    @Autowired
//    DepartmentsService departmentsService;
//    @RequestMapping("/create")
//    public String createPage(Model model){
//        List<Departments> listParentId = departmentsService.getByParentId(1);
//        model.addAttribute("");
//        return "pages/departments/create";
//    }
}
