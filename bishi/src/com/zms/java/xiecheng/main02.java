package com.zms.java.xiecheng;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/30 19:29
 */
public class main02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q= scan.nextInt();
        for(int i =0;i<q;i++){
            int y = scan.nextInt();
            int o = scan.nextInt();
            int u = scan.nextInt();
            int min = Math.min(y,o);
            min = Math.min(min,u);
            int score = min * 2;
            score +=( o - min ) -1;
            System.out.println(score);
        }
    }

}
