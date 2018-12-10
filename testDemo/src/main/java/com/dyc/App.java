package com.dyc;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        BigDecimal bigDecimal = new BigDecimal("12.00000").setScale(2, BigDecimal.ROUND_UP);
        System.out.println(bigDecimal);
    }
}
