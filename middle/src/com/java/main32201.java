package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author: zms
 * @create: 2022/4/8 16:45
 */
public class main32201 {
    public static void main(String[] args) {
        coinChange(new int[]{186,419,83,408},6249);
    }
   static Integer [] coins;
    static int amount;
    static int min = Integer.MAX_VALUE;
    public static int coinChange(int[] coin, int amoun) {
        amount = amoun;
        coins = new Integer[coin.length];
        for (int i = 0;i<coin.length;i++){
            coins[i] = coin[i];
        }
        Arrays.sort(coins, Collections.reverseOrder());
        if(amount == 0) return 0;
        try {
            dfs(0,0,new ArrayList<Integer>());
        }catch (Exception e){
            return  min;
        }

        return -1;
    }

    private static void dfs(int start , int sum,ArrayList<Integer> path) throws Exception {
        if(path.size()>min || sum > amount){
            return;
        }
        if(sum == amount){
            min = path.size();
            //throw new Exception();
            return;
        }

        for(int i = start; i < coins.length;i++){
            sum += coins[i];
            path.add(coins[i]);
            dfs(i,sum,path);
            path.remove(path.size()-1);
            sum -= coins[i];
        }

    }
}
