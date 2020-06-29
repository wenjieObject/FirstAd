package com.wenjie.adc.util;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static String dateToStr(java.util.Date dateDate) {
        String dateString = format.format(dateDate);
        return dateString;
    }

    public static Date strToDate(String strDate) {
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = format.parse(strDate, pos);
        return strtodate;
    }
}
