package com.elegantcollection.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date2String {
    /**
     * 日期 转换成 yyyy-MM-dd 格式的字符串
     * @param date 要转换的日期
     * @return 转换后的 字符串
     */
    public static String date2StringYMD(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 日期转换成 yyyy-MM-dd HH:mm 格式的字符串
     * @param date 要转换的日期
     * @return 转后完成后的字符串
     */
    public static String date2StringYMDHms(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(date);
    }

}
