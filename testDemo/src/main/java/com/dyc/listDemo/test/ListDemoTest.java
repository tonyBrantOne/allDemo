package com.dyc.listDemo.test;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/19 14:46
 * @Description:
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/19 14:46
 * @Description:
 */
public class ListDemoTest {

    public static void main(String[] args) {
        List<Long> listId =  new ArrayList<>();
        listId.add(1L);
        listId.add(1L);
        listId.add(1L);
        listId.add(2L);
        listId.add(3L);
        listId.addAll(new HashSet<Long>(listId));
        System.out.println(listId);
    }
}
