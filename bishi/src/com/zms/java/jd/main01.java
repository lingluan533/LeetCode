package com.zms.java.jd;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/4/2 19:28
 */
public class main01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int X = scan.nextInt();
        scan.nextLine();
        String in = scan.nextLine();
        long cur = X ;
        for(Character c : in.toCharArray()){
            switch (c){
                case 'U':
                    cur = cur / 2;
                    continue;
                case 'R':
                    cur = cur * 2 +1;
                    continue;
                case 'L':
                    cur = cur * 2 ;
                    continue;
            }
        }
        System.out.println(cur);
    }
}
