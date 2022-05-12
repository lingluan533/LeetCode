package com.zms.java.meituan;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/12 15:59
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i =0;i<n;i++){
            int m = scan.nextInt();

            if(m%11==0 ){
                System.out.println("yes");
                continue;
            }else{
                String sm = m+"";
                int count = 0;
                for(int j = 0;j<sm.length();j++){
                    if(sm.charAt(j)=='1'){
                        count++;
                        if(count==2) break;
                    }
                }
                if(count>=2){
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }

            }
        }

    }
}
