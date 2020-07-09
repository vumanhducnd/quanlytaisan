package com.website.qlts.controller;

import com.website.qlts.entity.Departments;
import com.website.qlts.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/departments")
public class DeparmentsController {

    @Autowired
    DepartmentsService departmentsService;

    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("model",departmentsService.getAll());
        return "pages/departments/index";
    }

    @RequestMapping("/create")
    public String create(Model model){
        model.addAttribute("model", new Departments());
        return "pages/departments/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam("departmentName") String departmentName){
        departmentsService.create(departmentName);
        return "pages/departments/create";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") long id){
        departmentsService.getById(id);
        return "pages/departments/edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable("id") long id, @RequestParam("departmentName") String departmentName){
        departmentsService.update(id,departmentName);
        return "redirect:/departments";
    }

}
