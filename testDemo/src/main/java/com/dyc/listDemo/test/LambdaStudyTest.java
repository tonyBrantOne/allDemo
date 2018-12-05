package com.dyc.listDemo.test;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/19 14:12
 * @Description:
 */

import com.dyc.listDemo.model.UserBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/19 14:12
 * @Description:
 */
public class LambdaStudyTest {
    public static void main(String[] args) {
//        List<UserBean> list  = new ArrayList<>();
//        list.add(new UserBean( 1l,"tony", 11L));
//        list.add(new UserBean( 2l,"tony", 12L));
//        list.add(new UserBean( 3l,"tony", null));
//        list.add(new UserBean( 4l,"tony", 14L));
//
//        Predicate<UserBean> contain1 = n -> null != n.getPlayId() ;
//
//        list.stream().filter(contain1).forEach(
//                n -> System.out.println(n.hashCode())
//        );
//        System.out.println("");
//        System.out.println(list.get(0).hashCode());
        test2();

    }

    public static void test1(){
        List<Long> list  = new ArrayList<>();
        Long a = null;
        list.add(1L);
        list.add(a);
        list.add(3L);
        System.out.println(list);
        list.removeAll(Collections.singleton(null));
        System.out.println(list);
    }

    public static void test2(){
//        Predicate<UserBean> contain1 = n -> null != n.getPlayId() ;
//        List<UserBean> list  = new ArrayList<>();
//        list.add(new UserBean( 1l,"tony", 11L));
//        list.add(new UserBean( 2l,"tony", 12L));
//        list.add(new UserBean( 3l,"tony", null));
//        list.add(new UserBean( 4l,"tony", 14L));
//        List<UserBean> newList = list.stream().filter(contain1).collect(Collectors.toList());
//        System.out.println(newList);
//        System.out.println("");
//        newList.forEach(n -> System.out.println(newList.indexOf(n)));
//        list.removeAll(newList);
//        System.out.println("");
//        System.out.println(list);
//   //     List<UserBean> listWithoutDup = new ArrayList<UserBean>(new HashSet<UserBean>());
//        newList.addAll(list);
//        System.out.println(newList);

    }

    public static void test3(){
        List<UserBean> list  = new ArrayList<>();
        UserBean userBean = new UserBean( 1l,"tony", 11L);
        list.add(userBean);
        list.add(userBean);

        list.add(userBean);
        System.out.println(list);
    }

}
