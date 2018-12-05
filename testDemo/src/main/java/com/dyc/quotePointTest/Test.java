package com.dyc.quotePointTest;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/29 19:42
 * @Description:
 */

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/29 19:42
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
//        String str = "2";
//        test1(str);
//        System.out.println(str);
//        People people = new Test().new People();
//        people.str = "5";
        People people = null;
        new Test().test3(people);
        System.out.println(people);
    }


    public static void test1(String str){
        str = "3";
    }

    public static void test1(People people){
        people.str = "3";
    }

    public  void test3(People people){
        people = new People();
    }

    class People{
       public String str;
    }

}
