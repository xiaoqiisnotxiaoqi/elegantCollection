package com.elegantcollection.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date2String {
    public static String date2StringYMD(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String date2StringYMDHms(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(date);
    }

}
