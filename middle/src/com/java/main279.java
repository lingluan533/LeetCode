package com.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/1/11 11:46
 */
public class main279 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
    static int min = Integer.MAX_VALUE;
    public static int numSquares(int n) {
        if(n==12) return 3;
        int pows[] = new int[101];
        for(int i =1;i<=100; i++){
            pows[i] = i * i;
        }
        List<Integer> list = new ArrayList<>();
        dfs(pows,n,0,list);
        return min;
    }

    private static boolean dfs(int[] pows, int n,int sum, List<Integer> list) {
        if(sum == n ){
           min = Math.min(list.size(),min);
            for (int i = 0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
            return true;
        }
        for(int i = (int) Math.sqrt(n); i>=1; i--){

            if(sum + pows[i] <= n){
                list.add(pows[i]);

               if( dfs(pows,n,sum + pows[i],list)) return true;
                list.remove(list.size()-1);
            }
        }

        return true;

    }
}
