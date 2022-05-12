package com.zms.java.wangyi;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/27 15:03
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int x = scan.nextInt();
        int y = scan.nextInt();

        int max = Math.max(a,b);
        int min = Math.min(a,b);
        int count = 0;
        if(x<=y){
            System.out.println( Math.max(a,b)/y+1);
        }else{
           //x>y
            if(y >= min){
                count+=1;
              int left = max - y;
              if(left % x == 0){
                  count+=left/x;
              }else {
                  count += left/x+1;
              }
            }else{
                //y<min
                System.out.println(max / x );

            }










        }
    }
}
