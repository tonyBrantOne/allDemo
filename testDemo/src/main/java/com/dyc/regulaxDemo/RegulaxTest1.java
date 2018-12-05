package com.dyc.regulaxDemo;/**
 * @Auther: tony_jaa
 * @Date: 2018/11/30 12:37
 * @Description:
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: tony_jaa
 * @Date: 2018/11/30 12:37
 * @Description:
 */
public class RegulaxTest1 {


    public static void main(String[] args) {
//        String regux = "^\\d{4}\\-\\d{2}\\-\\d{2}\\''\\d{2}:\\d{2}:\\d{2}$";
//        String value = "2018-11-01 00:00:00";
        String regux = "^\\d{4}\\-\\d{2}\\-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$";
        String value = "2018-11-01 00:00:00";
        Pattern pattern = Pattern.compile( regux  );
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            System.out.println("校验通过");
        }else{
            System.out.println("失败哦");
        }

    }


}
