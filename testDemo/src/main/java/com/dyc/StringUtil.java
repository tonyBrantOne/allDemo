package com.dyc;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/16 15:50
 * @Description:
 */

import java.text.MessageFormat;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/16 15:50
 * @Description:
 */
public class StringUtil {
    public static void main(String[] args) {
        String a = "UPDATE {0} SET {1} WHERE {2} = #'{entity.id}'";
        String b = "gold_record";
        String setValues = "status=#{entity.status},last_time=#{entity.lastTime},operator_id=#{entity.operatorId},";
        CharSequence k = setValues.subSequence(0, setValues.length() - 1);
        String d = "id";
        String e = "";
        String str = MessageFormat.format(a,b,k,d,e);
        System.out.println(str);
    }

    public void test1(){
        Long id = 123L;
   //     Lists.newArrayList(new Long[]{id});

    }
}
