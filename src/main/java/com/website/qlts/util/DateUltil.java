package com.website.qlts.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUltil {
    public static Date convertStringToDate(String dateString) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        } catch (Exception ex) {
        }
        return date;
    }
}
