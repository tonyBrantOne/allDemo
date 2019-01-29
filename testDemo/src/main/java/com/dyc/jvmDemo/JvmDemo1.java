package com.dyc.jvmDemo;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/27 12:11
 * @Description:
 */

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/27 12:11
 * @Description:
 */
public class JvmDemo1 {
        private static final int NUM = 100000000;
        public static void main(String args[])
        {
            System.out.println(sum2(NUM));
       //     System.out.println(sum(NUM));
        }

        static long sum(long a)
        {
            if (a == 1) {
                return 1;
            } else {
                return a + sum(a - 1);
            }
        }

        static long sum2(long a)
        {
            if (a == 1) {
                return 1;
            } else {
                return sum2(a - 1) + a; // 仅此顺序倒了一下
            }
        }
}
