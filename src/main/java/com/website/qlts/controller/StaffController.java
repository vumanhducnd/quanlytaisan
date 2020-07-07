package com.website.qlts.controller;

import com.website.qlts.entity.Departments;
import com.website.qlts.entity.Staffs;
import com.website.qlts.service.DepartmentsService;
import com.website.qlts.service.StaffService;
import com.website.qlts.view.StaffDepartments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @Autowired
    private DepartmentsService departmentsService;

    @RequestMapping("")
    public String indexPage(Model model, String keyWord) {
        List<Staffs> staffsList;
        if (keyWord != null) {
            staffsList = staffService.getByName(keyWord);
        } else {
            staffsList = staffService.getAll();
        }

        model.addAttribute("staffs", staffsList);
        return "pages/staffs/index";
    }

    @RequestMapping("/create")
    public String createPage(Model model) {
        StaffDepartments staffDepartments = new StaffDepartments();
        staffDepartments.setDepartmentsList(departmentsService.getAll());
        staffDepartments.setStaffs(new Staffs());
        model.addAttribute("staffDepartments", staffDepartments);
        return "pages/staffs/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPage(@ModelAttribute StaffDepartments staffDepartments, @RequestParam("departmentsId") String departmentsId) {
        Staffs staffs = staffDepartments.getStaffs();
        staffService.create(new Staffs(staffs.getName(), staffs.getDateOfBirth(), staffs.getAddress(), staffs.getPhoneNumber(),0,Long.parseLong(departmentsId) ));
        return "redirect:/staffs/";
    }


    @RequestMapping("/delete/{id}")
    public String deletePage(@PathVariable("id") long id, Model model) {
        staffService.delete(id);
        return "redirect:/category-assets/";
    }

    @RequestMapping("/search")
    public String search(@RequestParam String name, Model model){
        List<Staffs> staffsList = staffService.getByName(name);
        model.addAttribute("staffs",staffsList);
        return "redirect:/staffs/";
    }
}
