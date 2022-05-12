package com.zms.java.meituan;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/12 15:16
 */
public class maintest02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            int m = scan.nextInt();
            int n = scan.nextInt();
            if(m>=100 && n<=999 && m<=n){
                int j= 0;
                for(int i = m;i<=n;i++){
                    int gewei,shiwei,baiwei;
                    baiwei = i/100;

                    shiwei =  (i-baiwei*100)/10;
                    gewei = i -baiwei*100 -  shiwei*10;
                    if(gewei*gewei*gewei + shiwei*shiwei*shiwei + baiwei*baiwei*baiwei==i){
                        j++;
                        if(j>1){
                            System.out.print(" "+i);
                        }else{
                            System.out.print(i);
                        }
                    }

                }
                if(j==0) System.out.print("no");
                System.out.println();
            }

        }

    }
}
