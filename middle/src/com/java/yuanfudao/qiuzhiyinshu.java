package com.java.yuanfudao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/26 20:46
 */
public class qiuzhiyinshu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2;i*i<=a;i++){
            while (a!=1 && a % i==0){  //找到一个质因数，一直除一下，直到不再能除尽
                list.add(i);
                a/=i;
            }
            if (a==1) break;        //这里应该判断a是不是质数（素数 ）从而提前结束运算
        }
        if (a!=1) list.add(a);
        for (Integer i : list){
            System.out.print(i+" ");
        }
    }
}
