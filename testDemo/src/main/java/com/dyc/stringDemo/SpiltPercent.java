package com.dyc.stringDemo;

/**
 * title:
 * create by tony_jaa
 * date 2018/12/23
 */
public class SpiltPercent {
    private static final String urlUserService = "dubbo%3A%2F%2F192.168.0.138%3A20880%2Fcom.dyc.serverApi.service.UserService%3Fanyhost%3Dtrue%26application%3Ddubbo-server%26dubbo%3D2.5.3%26interface%3Dcom.dyc.serverApi.service.UserService%26methods%3DhelloWord%26owner%3Ddyc%26pid%3D10592%26side%3Dprovider%26timestamp%3D1545531692966";

    public static void main(String[] args) {
        String[] objArr = urlUserService.split("%");
        for( String str : objArr){
            System.out.println(str);
        }
    }
}
