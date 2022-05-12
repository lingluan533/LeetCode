package com.java;

import com.java.double71.main;

/**
 * @author: zms
 * @create: 2022/3/14 21:40
 */
public class IPtoInt {
    public static void main(String[] args) {
        System.out.println(IpToint("145.45.120.142"));
    }
    public static long IpToint(String ip){
        String[] split = ip.split("\\.");
        long a = Long.parseLong(split[0]) << 24;
        System.out.println(a);
        long b = Long.parseLong(split[1]) << 16;

        long c = Long.parseLong(split[2]) << 8;
        long d = Long.parseLong(split[3]) << 0;


       return a+b+c+d;
    }
}
