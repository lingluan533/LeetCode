package com.zms.java.xiecheng;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/30 19:19
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q= scan.nextInt();
        for(int i =0;i<q;i++){
            int x = scan.nextInt();
            if ((x%2==0)) System.out.println(x);
            else{
                String text = x + "";
                int len = text.length();
                char cs [] = text.toCharArray();
                boolean flag = false;
                for (int j=0 ; j<len ;j++){
                    if ((text.charAt(j)-'0')%2==0){
                        char t = text.charAt(j);
                        cs[j] = cs[len-1];
                        cs[len-1] = t;
                        flag = true;
                        break;
                    }
                }
                if (!flag) {System.out.println(-1);
                continue;}
                String re = "";
                for (int j=0;j<len;j++){
                    re += cs[j];
                }
                System.out.println(Integer.parseInt(re));
            }
        }
    }
}
