package com.dyc.dateDemo;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/22 14:21
 * @Description:
 */

import com.dyc.dateDemo.util.Simp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/22 14:21
 * @Description:
 */
public class SimpleDateFormatTest {

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat(Simp.MILLISECOND_PATTERN);
        System.out.println( formatter.format(new Date()) );
    }
}
