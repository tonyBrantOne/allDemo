package com.dyc.webSpringMvcProgram.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * title:
 * create by tony_jaa
 * date 2018/11/4
 */
public class DateUtil {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static String dateConvertString ( Date date ){
       return simpleDateFormat.format(date);
    }
}
