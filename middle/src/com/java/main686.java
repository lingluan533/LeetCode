package com.java;

import java.time.Clock;

/**
 * @author: zms
 * @create: 2021/12/22 9:43
 */
public class main686 {

     public int repeatedStringMatch(String a, String b) {
        if(a.contains(b)){
            return 1;
        }
        if(b.equals("")){
            return 0;
        }
        int count = 0;
        StringBuilder sb = new StringBuilder(a);
        while (sb.length() < b.length()){
            sb.append(a);
            count++;
        }
         Clock clock = Clock.systemDefaultZone();
         long start = clock.millis();
         while (clock.millis() - start < 100) {
             if (sb.indexOf(b) != -1) return count;
             sb.append(a);
             count++;
         }
        return -1;

    }
    public static void main(String[] args) {

    }
}
