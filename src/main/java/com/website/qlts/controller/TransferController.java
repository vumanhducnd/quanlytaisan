package com.website.qlts.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.website.qlts.service.AssetsService;
import com.website.qlts.service.DepartmentsService;
import com.website.qlts.service.StaffService;
import com.website.qlts.service.TransferService;
import com.website.qlts.view.TransferView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    StaffService staffService;

    @Autowired
    DepartmentsService departmentsService;

    @Autowired
    TransferService transferService;

    @Autowired
    AssetsService assetsService;
    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("model",transferService.getAll());
        return "pages/transfer-history/index";
    }

    @RequestMapping("/department")
    public String transferDepart(Model model){
        model.addAttribute("model",transferService.getAllByDepartment());
        return "pages/transfer-history/department-transfer";
    }

    @RequestMapping("/action/{id}")
    public String action(Model model, @PathVariable("id") long id){
        TransferView transferView = new TransferView();
        transferView.setTransferHistory(transferService.getById(id));
        transferView.setDepartmentsListOld(departmentsService.getAll());
        transferView.setDepartmentsListNew(departmentsService.getAll());
        model.addAttribute("model",transferView);
        return "pages/transfer-history/department";
    }

    @RequestMapping(value = "/action/{id}", method = RequestMethod.POST)
    public String transferWithDepart( @PathVariable("id") long id,@RequestParam("reason") String reason, @RequestParam("newDepartment") long newDepartmentId,  @RequestParam("oldDepartment") long oldDepartmentId){
        transferService.createAndUpdate(reason,id,oldDepartmentId,newDepartmentId,new Date(), new Date(),1);
        return "redirect:/transfer";
    }

    @RequestMapping("/staff")
    public String transferStaff(Model model){
        model.addAttribute("model",transferService.getAllByStaff());
        return "pages/transfer-history/department-transfer";
    }

    @RequestMapping("/staff-action/{id}")
    public String staffAction(Model model, @PathVariable("id") long id){
        TransferView transferView = new TransferView();
        transferView.setTransferHistory(transferService.getById(id));
        transferView.setStaffsListOld(staffService.getAll());
        transferView.setStaffsListNew(staffService.getAll());
        model.addAttribute("model",transferView);
        return "pages/transfer-history/staff";
    }

    @RequestMapping(value = "/action/{id}", method = RequestMethod.POST)
    public String transferWithStaff( @PathVariable("id") long id,@RequestParam("reason") String reason, @RequestParam("newDepartment") long newDepartmentId,  @RequestParam("oldDepartment") long oldDepartmentId){
        transferService.createAndUpdate(reason,id,oldDepartmentId,newDepartmentId,new Date(), new Date(),1);
        return "redirect:/transfer";
    }
}
