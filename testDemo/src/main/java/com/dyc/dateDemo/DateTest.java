package com.dyc.dateDemo;

import com.dyc.dateDemo.util.Simp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/22 14:07
 * @Description:
 */
public class DateTest {



    public static void main(String[] args) throws ParseException {

//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime( new Date() );
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//
//        System.out.println(year);
//        System.out.println(month);
//        System.out.println(new StringBuilder(year+"").append(month));
//        compareDate();
        getCurrentDayBeginTime();
        getCurrentDayEndTime();
    }


    public static void compareDate() throws ParseException {
        String beginStr = "2018-10-30 10:10:10";
        String endStr = "2018-10-30 10:05:10";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Simp.DATE_TIME_PATTERN);
        Date date1 = simpleDateFormat.parse(beginStr);
        Date date2 = simpleDateFormat.parse(endStr);

        long l = date1.getTime() - date2.getTime();
        System.out.println(l);
    }

    /**
     * 获取当天起始时间
     */
    public static void getCurrentDayBeginTime(){
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        System.out.println(todayStart.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Simp.MILLISECOND_PATTERN);
        System.out.println(simpleDateFormat.format(todayStart.getTime()));
    }

    public static void getCurrentDayEndTime(){
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        System.out.println(todayEnd.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Simp.MILLISECOND_PATTERN);
        System.out.println(simpleDateFormat.format(todayEnd.getTime()));
    }





}
