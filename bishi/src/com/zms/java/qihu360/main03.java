package com.zms.java.qihu360;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/19 16:26
 */
public class main03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        int q = scan.nextInt();
        ArrayList<Long> list = new ArrayList<>();
        for(int i = 0;i<q;i++){
            long l = scan.nextLong();
            long r = scan.nextLong();
            l = l-1;
            list.add(l);
            list.add(r);
            Collections.sort(list);
            long ans = n;
            int size = list.size();
            for(int j = 0;j<size - 1;j++){
                if(j%2==0){
                    long temp = list.get(j+1) - list.get(j);
                    ans -= temp;
                }
            }
            System.out.println(ans);
        }
    }
}
