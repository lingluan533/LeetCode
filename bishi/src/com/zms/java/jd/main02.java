package com.zms.java.jd;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/4/2 19:53
 */
public class main02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i = 0;i<T;i++){
            int n = scan.nextInt();
            scan.nextLine();
            String str = scan.nextLine();
            int Ac = 0,Bc = 0,Cc=0;
            for(int j = 0;j<str.length();j++){
                if(str.charAt(j)=='A')Ac++;
                if(str.charAt(j)=='B')Bc++;
                if(str.charAt(j)=='C')Cc++;
            }
            if(Bc==n && Ac==n&&Cc==n){
                System.out.println(0);
            }
        }
    }
}
