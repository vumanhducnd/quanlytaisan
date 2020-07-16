package com.website.qlts.config;

import com.website.qlts.entity.TransferHistories;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

public class ExportExcel {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    private static String[] columns = {"STT", "Tên", "Lý do", "Người dùng trước", "Người sau sau", "Thời gian từ", "Đến"};

    public void exportExcelTransfer(HttpServletResponse response, List<TransferHistories> transferHistories) {
        int time = new Date().getHours() + new Date().getDay() + new Date().getMonth() + new Date().getYear();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Baocao" + time);
        List<TransferHistories> list = transferHistories;
        int rownum = 1;
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cells = headerRow.createCell(i);
            cells.setCellValue(columns[i]);
            cells.setCellStyle(headerCellStyle);
        }
        int rowNum = 1;
        for (TransferHistories emp : list) {
            Row row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(rowNum++);
            row.createCell(1).setCellValue(emp.getAssets().getName());
            row.createCell(2).setCellValue(emp.getReason());
            if (emp.getStaffIdNew() == 0 || emp.getStaffIdOld() == 0) {
                row.createCell(3).setCellValue(emp.getDepartments().getDepartmentName());
                row.createCell(4).setCellValue(emp.getDepartment().getDepartmentName());
            } else {
                row.createCell(3).setCellValue(emp.getStaffs().getName());
                row.createCell(4).setCellValue(emp.getStaff().getName());
            }
            CreationHelper createHelper = workbook.getCreationHelper();
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            Cell startDate = row.createCell(5);
            startDate.setCellValue(emp.getStartDate());
            startDate.setCellStyle(dateCellStyle);
            Cell endDate = row.createCell(6);
            endDate.setCellValue(emp.getEndDate());
            endDate.setCellStyle(dateCellStyle);
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }
        }
        File directory = new File("");
        File file = new File(directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\BaoCao" + time + ".xls");
        String filePath = directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\\\BaoCao" + time + ".xls";
        file.getParentFile().mkdirs();

        try {
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            CreateDownloadFile downloadFile = new CreateDownloadFile();
            downloadFile.download(response, filePath);
            file.delete();
        } catch (Exception e) {
        }
    }

    public void exportExcelUse(HttpServletResponse response, List<TransferHistories> transferHistories) {
        int time = new Date().getHours() + new Date().getDay() + new Date().getMonth() + new Date().getYear();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Baocao" + time);
        List<TransferHistories> list = transferHistories;
        int rownum = 1;
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cells = headerRow.createCell(i);
            cells.setCellValue(columns[i]);
            cells.setCellStyle(headerCellStyle);
        }
        int rowNum = 1;
        for (TransferHistories emp : list) {
            Row row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(rowNum++);
            row.createCell(1).setCellValue(emp.getAssets().getName());
            row.createCell(2).setCellValue(emp.getReason());
            if (emp.getStaffIdNew() == 0 || emp.getStaffIdOld() == 0) {
                row.createCell(3).setCellValue(emp.getDepartments().getDepartmentName());
                row.createCell(4).setCellValue(emp.getDepartment().getDepartmentName());
            } else {
                row.createCell(3).setCellValue(emp.getStaffs().getName());
                row.createCell(4).setCellValue(emp.getStaff().getName());
            }
            CreationHelper createHelper = workbook.getCreationHelper();
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            Cell startDate = row.createCell(5);
            startDate.setCellValue(emp.getStartDate());
            startDate.setCellStyle(dateCellStyle);
            Cell endDate = row.createCell(6);
            endDate.setCellValue(emp.getEndDate());
            endDate.setCellStyle(dateCellStyle);
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }
        }
        File directory = new File("");
        File file = new File(directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\BaoCao" + time + ".xls");
        String filePath = directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\\\BaoCao" + time + ".xls";
        file.getParentFile().mkdirs();

        try {
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            CreateDownloadFile downloadFile = new CreateDownloadFile();
            downloadFile.download(response, filePath);
            file.delete();
        } catch (Exception e) {
        }
    }

    public void exportExcelNew(HttpServletResponse response, List<TransferHistories> transferHistories) {
        int time = new Date().getHours() + new Date().getDay() + new Date().getMonth() + new Date().getYear();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Baocao" + time);
        List<TransferHistories> list = transferHistories;
        int rownum = 1;
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cells = headerRow.createCell(i);
            cells.setCellValue(columns[i]);
            cells.setCellStyle(headerCellStyle);
        }
        int rowNum = 1;
        for (TransferHistories emp : list) {
            Row row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(rowNum++);
            row.createCell(1).setCellValue(emp.getAssets().getName());
            row.createCell(2).setCellValue(emp.getReason());
            if (emp.getStaffIdNew() == 0 || emp.getStaffIdOld() == 0) {
                row.createCell(3).setCellValue(emp.getDepartments().getDepartmentName());
                row.createCell(4).setCellValue(emp.getDepartment().getDepartmentName());
            } else {
                row.createCell(3).setCellValue(emp.getStaffs().getName());
                row.createCell(4).setCellValue(emp.getStaff().getName());
            }
            CreationHelper createHelper = workbook.getCreationHelper();
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            Cell startDate = row.createCell(5);
            startDate.setCellValue(emp.getStartDate());
            startDate.setCellStyle(dateCellStyle);
            Cell endDate = row.createCell(6);
            endDate.setCellValue(emp.getEndDate());
            endDate.setCellStyle(dateCellStyle);
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }
        }
        File directory = new File("");
        File file = new File(directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\BaoCao" + time + ".xls");
        String filePath = directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\\\BaoCao" + time + ".xls";
        file.getParentFile().mkdirs();

        try {
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            CreateDownloadFile downloadFile = new CreateDownloadFile();
            downloadFile.download(response, filePath);
            file.delete();
        } catch (Exception e) {
        }
    }

    public void exportExcelRevoke(HttpServletResponse response, List<TransferHistories> transferHistories) {
        int time = new Date().getHours() + new Date().getDay() + new Date().getMonth() + new Date().getYear();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Baocao" + time);
        List<TransferHistories> list = transferHistories;
        int rownum = 1;
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 10);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cells = headerRow.createCell(i);
            cells.setCellValue(columns[i]);
            cells.setCellStyle(headerCellStyle);
        }
        int rowNum = 1;
        for (TransferHistories emp : list) {
            Row row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(rowNum++);
            row.createCell(1).setCellValue(emp.getAssets().getName());
            row.createCell(2).setCellValue(emp.getReason());
            if (emp.getStaffIdNew() == 0 || emp.getStaffIdOld() == 0) {
                row.createCell(3).setCellValue(emp.getDepartments().getDepartmentName());
                row.createCell(4).setCellValue(emp.getDepartment().getDepartmentName());
            } else {
                row.createCell(3).setCellValue(emp.getStaffs().getName());
                row.createCell(4).setCellValue(emp.getStaff().getName());
            }
            CreationHelper createHelper = workbook.getCreationHelper();
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
            Cell startDate = row.createCell(5);
            startDate.setCellValue(emp.getStartDate());
            startDate.setCellStyle(dateCellStyle);
            Cell endDate = row.createCell(6);
            endDate.setCellValue(emp.getEndDate());
            endDate.setCellStyle(dateCellStyle);
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }
        }
        File directory = new File("");
        File file = new File(directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\BaoCao" + time + ".xls");
        String filePath = directory.getAbsolutePath() + "\\src\\main\\resources\\static\\file\\\\BaoCao" + time + ".xls";
        file.getParentFile().mkdirs();

        try {
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            CreateDownloadFile downloadFile = new CreateDownloadFile();
            downloadFile.download(response, filePath);
            file.delete();
        } catch (Exception e) {
        }
    }
}

