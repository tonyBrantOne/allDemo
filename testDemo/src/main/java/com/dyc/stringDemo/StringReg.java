package com.dyc.stringDemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/8 10:52
 * @Description:
 */
public class StringReg {
    private static final String sql = "select count(1) as current_connections from pg_stat_activity where id = #{ selId} and name = #{nameStr} or type = #{typeStr}";
    private static final String regux = "\\[([^\\]]+)\\]";
    private static final String regux2 = "#\\{([^\\}]+)\\}";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile( regux2  );
        Matcher matcher = pattern.matcher(sql);
        while (matcher.find()){
            System.out.println(matcher.group(1).trim());
        }
    }

}
