package com.java.week283;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/3/6 10:30
 */
public class main01 {
    public static void main(String[] args) {
//        cellsInRange("A1:F1").stream().map((i)->{
//            System.out.println(i);
//        });
    }
    public static List<String> cellsInRange(String s) {
        String[] split = s.split(":");
        char col1 = split[0].charAt(0);
        int row1 = split[0].charAt(1)-'0';

        char col2 = split[1].charAt(0);
        int row2 = split[1].charAt(1)-'0';
        List<String> list = new ArrayList<>();
        for(int i =row1;i<=row2;i++){
            String a = "";
            a+=col1;
            a+=i+"";
            list.add(a);
        }

        for(int i = col1+1;i<col2;i++){
            for(int j = row1;j<=row2;j++){
                String a = "";
                a+=(char)i;
                a+=j+"";
                list.add(a);
               // list.add(i+j+"");
            }
        }
        if(col1!=col2)
        for(int i =row1;i<=row2;i++){
            String a = "";
            a+=col1;
            a+=i+"";
            list.add(a);
           // list.add(col2+i+"");
        }
        return list;

    }
}
