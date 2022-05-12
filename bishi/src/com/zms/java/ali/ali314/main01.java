package com.zms.java.ali.ali314;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/14 18:45
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s  = scan.next();
        s = s.substring(2);
        long  res = 0;
        for(int i=0;i<s.length();i++){

            Character M = s.charAt(i) ;
            //如果不是0-9
            int cur = 0;
            if(!Character.isDigit(M)){
                 cur  = ( M -  'a'+10);
            }else cur = M - '0';
            int curcount = 0;
            if(cur == 0) continue;
            while(cur != 1){
                int yu = cur % 2;
                cur = cur /2;
                if(yu == 1){
                    curcount ++;
                }
            }
            curcount++;
            res += curcount;

        }
        System.out.println(res);

    }
    public static String solve (int M, int N) {
        // write code here
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        if(M<0){
            M = -1*M;
            flag = false;
        }
        while(M!=1){
            int yu = M%N;
            if(yu>9){
                sb.append((char)('A' + (yu-10)));
            }else{
                sb.append(yu+"");
            }
            M = M / N;
        }
        sb.append('1');
        String res = sb.reverse().toString();
        if(!flag) return "-"+res;
        return res;
    }
}
