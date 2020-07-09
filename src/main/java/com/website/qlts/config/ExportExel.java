package com.website.qlts.config;

import com.website.qlts.entity.TransferHistory;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

public class ExportExel {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public void exportExcel(List<TransferHistory> transferHistories) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Employees sheet");

        List<TransferHistory> list = transferHistories;

        int rownum = 0;
        Cell cell;
        Row row;

        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("STT");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên tài sản");
        cell.setCellStyle(style);
        // EmpName
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Chi tiết");
        cell.setCellStyle(style);
        // Salary
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Người dùng trước");
        cell.setCellStyle(style);
        // Grade
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Người dùng sau");
        cell.setCellStyle(style);
        // Bonus
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Thời gian từ");
        cell.setCellStyle(style);

        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Đến");
        cell.setCellStyle(style);

        // Data
        for (TransferHistory emp : list) {
            rownum++;
            row = sheet.createRow(rownum);

            // EmpNo (A)
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(rownum);
            // EmpName (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(emp.getAssets().getName());
            // Salary (C)
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(emp.getReason());
            // Grade (D)
            if(emp.getStaffIdNew() == 0  || emp.getStaffIdOld() == 0){
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(emp.getDepartments().getDepartmentName());
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(emp.getDepartment().getDepartmentName());
            }
            else {
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(emp.getStaffs().getName());
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(emp.getStaff().getName());
            }
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue(emp.getStartDate());
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue(emp.getEndDate());

        }
        File file = new File("D:/Download/qlts/src/main/java/com/website/qlts/config/123123"+".xls");
        file.getParentFile().mkdirs();

        try {
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
        } catch (Exception e) {

        }

    }

}

