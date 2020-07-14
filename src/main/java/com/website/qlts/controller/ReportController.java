package com.website.qlts.controller;

import com.website.qlts.config.ExportExcel;
import com.website.qlts.entity.RevokeHistory;
import com.website.qlts.repository.AssetsRepository;
import com.website.qlts.service.RevokeHistoryService;
import com.website.qlts.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
    public String reportStatement(Model model,String toDate, String fromDate,String keyWord) {
        List<RevokeHistory> revokeHistories;
        revokeHistories = revokeHistoryService.getAll();
        model.addAttribute("model", revokeHistories);
        return "/pages/report/statement";
    }

    @RequestMapping("/report-use")
    public String reportUse(Model model, String toDate, String fromDate,String keyWord) {
        if(keyWord != null && keyWord !=""){
            model.addAttribute("model", transferService.getByName(keyWord));
        }
        if(toDate != null && fromDate != null && toDate != "" && fromDate != ""){
            model.addAttribute("model", transferService.getByDate(fromDate,toDate));
        }
        else {
            model.addAttribute("model", transferService.getAll());
        }

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
    public String reportSTransfer(Model model,String toDate, String fromDate,String keyWord) {
        if(keyWord != null && keyWord !=""){
            model.addAttribute("model", transferService.getByName(keyWord));
        }
        if(toDate != null && fromDate != null && toDate != "" && fromDate != ""){
            model.addAttribute("model", transferService.getByDate(fromDate,toDate));
        }
        else{
            model.addAttribute("model", transferService.getAll());
        }
        return "/pages/report/transfer";
    }

    @RequestMapping("/report-revoke")
    public String reportRevoke(Model model,String toDate, String fromDate,String keyWord) {
        if(keyWord != null && keyWord !=""){
            model.addAttribute("model", transferService.getByName(keyWord));
        }
        if(toDate != null && fromDate != null && toDate != "" && fromDate != ""){
            model.addAttribute("model", revokeHistoryService.getByDate(convertStringToDate(fromDate),convertStringToDate(toDate)));
        }
        else{
            model.addAttribute("model", revokeHistoryService.getAll());
        }
        return "/pages/report/revoke";
    }

    @RequestMapping("/report-revoke-poached")
    public String reportRevokePoached() {
        return "/pages/report/revoke-poached";
    }

    @RequestMapping("/export-file-transfer")
    public String exportTransfer(HttpServletResponse httpServletResponse) throws IOException {
        ExportExcel createDownloadFile = new ExportExcel();
        createDownloadFile.exportExcelTransfer(httpServletResponse, transferService.getAll());
        return "redirect:/report-transfer";
    }

    @RequestMapping("/export-file-use")
    public String exportUse(HttpServletResponse httpServletResponse) throws IOException {
        ExportExcel createDownloadFile = new ExportExcel();
        createDownloadFile.exportExcelUse(httpServletResponse, transferService.getAll());
        return "redirect:/report-transfer";
    }

    @RequestMapping("/export-file-new")
    public String exportNew(HttpServletResponse httpServletResponse) throws IOException {
        ExportExcel createDownloadFile = new ExportExcel();
        createDownloadFile.exportExcelNew(httpServletResponse, transferService.getAll());
        return "redirect:/report-new";
    }

    @RequestMapping("/export-file-revoke")
    public String exportRevoke(HttpServletResponse httpServletResponse) throws IOException {
        ExportExcel createDownloadFile = new ExportExcel();
        createDownloadFile.exportExcelRevoke(httpServletResponse, transferService.getAll());
        return "redirect:/report-revoke";
    }

    public Date convertStringToDate(String dateString) {
        String dateStringFormat = dateString.replace('-','/');
        Date date = new Date();
        try {
            date=new SimpleDateFormat("yyyy/MM/dd").parse(dateStringFormat);
        }catch (Exception ex){
        }
        return date;
    }
}
