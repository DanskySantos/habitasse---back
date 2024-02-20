package com.project.habitasse.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Utils {

    private final static DateTimeFormatter formatoDateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static Date d1 = null;

    public static Date dateToSave(String date) {
        LocalDate d = LocalDate.parse(date, formatoDateTimeFormatter);
        return d1 = Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
