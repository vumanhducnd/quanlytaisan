package com.website.qlts.controller;

import com.website.qlts.config.ExportExel;
import com.website.qlts.entity.RevokeHistory;
import com.website.qlts.repository.AssetsRepository;
import com.website.qlts.service.RevokeHistoryService;
import com.website.qlts.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class ReportController {
    @Autowired
    TransferService transferService;

    @Autowired
    AssetsRepository assetsRepository;

    @Autowired
    RevokeHistoryService revokeHistoryService;

    @RequestMapping("/report-statement")
    public String reportStatement(Model model) {
        List<RevokeHistory> revokeHistories;
        revokeHistories = revokeHistoryService.getAll();
        model.addAttribute("model", revokeHistories);
        return "/pages/report/statement";
    }

    @RequestMapping("/report-use")
    public String reportUse(Model model) {
        model.addAttribute("model", transferService.getAll());
        return "/pages/report/use";
    }

    @RequestMapping("/report-new")
    public String reportNew(Model model) {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        int year = localDate.getYear();
        model.addAttribute("model", assetsRepository.getAssetsNew(month, year));
        return "/pages/report/new";
    }

    @RequestMapping("/report-transfer")
    public String reportSTransfer(Model model) {
        model.addAttribute("model", transferService.getAll());
        return "/pages/report/transfer";
    }

    @RequestMapping("/export-file")
    public String export() {
        ExportExel exportExel = new ExportExel();
        exportExel.exportExcel(transferService.getAll());
        return "redirect:/report-transfer";
    }

    @RequestMapping("/report-revoke")
    public String reportRevoke(Model model) {
        List<RevokeHistory> revokeHistories;
        revokeHistories = revokeHistoryService.getAll();
        model.addAttribute("model", revokeHistories);
        return "/pages/report/revoke";
    }

    @RequestMapping("/report-revoke-poached")
    public String reportRevokePoached() {

        return "/pages/report/revoke-poached";
    }
}
