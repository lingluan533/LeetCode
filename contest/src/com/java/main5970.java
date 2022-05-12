package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/1/2 11:33
 */
public class main5970 {
    public static int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        if(n==2) return 2;
        boolean flag [] ;
        int max =Integer.MIN_VALUE;
      for(int i=0;i<favorite.length;i++){
            flag = new boolean[n];
            int j = favorite[i];
            int ans = 1;
            flag[i] = true;
            while(!flag[j]){
                flag[j] = true;
                ans ++;
                j = favorite[j];
                if(flag[j])ans--;
            }
            max = Math.max(max,ans);
      }

        return max;
    }

    public static void main(String[] args) {
        maximumInvitations(new int[]{3,0,1,4,1});
    }
}
