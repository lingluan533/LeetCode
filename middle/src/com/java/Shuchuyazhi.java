package com.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/4/20 21:39
 */
public class Shuchuyazhi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long  my[] = new long[n];
        long enemy[] = new long[n];
        long summy[] = new long[n];
        long sumenemy[] = new long[n];
        long summyNum = 0;
        long sumenemyNum = 0;
        for(int i = 0;i<n;i++){
            my[i] = scan.nextLong();
            summyNum+=my[i];
            summy[i] = summyNum;
        }
         for(int i = 0;i<n;i++){
             enemy[i] = scan.nextLong();
             sumenemyNum += enemy[i];
             sumenemy[i] = sumenemyNum;
        }
        List<Integer> list = new ArrayList<>();
         for(int i = 0;i<n;i++){
             if(summy[i] <= sumenemy[i]){
                 list.add(i);
             }
         }
         if(list.size() ==0){ //不需要加钱
             System.out.println(0);
             return;
         }
         //计算填补这个缺口需要的金钱数
         long add = 1;
         while(true){ //遍历每一个i 直到找到第一个能填补完全缺口的数
             int i = 0;
            for(;i<list.size(); i++){
                int index = list.get(i) + 1 ;
                long addCount = index * add ;
                if(summy[index-1] + addCount <= sumenemy[index-1]){
                    break;
                }
            }
            if(i==list.size()){
                System.out.println(add);//找到了
                return;
            }else{
                add++;
            }
         }
    }
}
