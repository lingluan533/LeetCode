package com.zms.java.baidu;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/22 19:51
 */
public class main02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int len = str.length();
        if(str.charAt(0) == str.charAt(str.length()-1)){
            System.out.print(1);
            System.out.print(" ");
            System.out.print(len-2);
            System.out.println(" ");
            System.out.println(2);
            System.out.println(" ");
            System.out.println(len);
        }
        char cs[] = str.toCharArray();
        int total0 = 0;
        int total1 = 0;
        for(Character c : cs){
            if (c == '0') {
                total0++;
            } else {
                total1++;
            }
        }
        for(int i = len-1;i>=1;i--){  //遍历所有长度子串
            int jianqu0=0,jianqu1 = 0;
            int k = 0;
           for(int j = len-1;k < len -i ;k++,j--){
               if(cs[j] == '0'){
                   jianqu0++;
               }else{
                   jianqu1++;
               }
           }
           int cur0 = total0 - jianqu0;
           int cur1 = total1 - jianqu1;

           //计算各个子串中 0 和 1 的个数
            int zijianqu0=0,zijianqu1=0;
           for(int start = 1;start <= len - i;start++){
                for(int left = 0;left <start;left++){
                    if(cs[left] == '0'){
                        zijianqu0++;
                    }else{
                        zijianqu1++;
                    }
                }

                for (int right = len-1;right >=start+i;right++){
                    if(cs[right] == '0'){
                        zijianqu0++;
                    }else{
                        zijianqu1++;
                    }
                }

                if(zijianqu0 == jianqu0){
                    //System.out.print();
                    return;
                }
           }


        }



    }
}
