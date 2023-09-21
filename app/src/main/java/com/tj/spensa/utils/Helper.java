package com.tj.spensa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    private static final String MY_DATE_FORMAT = "dd/MM/yyyy";


    public static String formatDateString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(MY_DATE_FORMAT);
        return simpleDateFormat.format(date);
    }
}
