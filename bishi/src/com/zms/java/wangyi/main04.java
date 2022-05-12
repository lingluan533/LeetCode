package com.zms.java.wangyi;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/27 16:11
 */
public class main04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int nums[][] = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                nums[i][j] = scan.nextInt();
            }
        }
        int dp[][] = new int[n][m];
        dp[0][0] = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i==0&& j==0) continue;
                if(i==0 ){
                    //上下边界
                    if(j==m-1){
                        int left = nums[i][j-1];
                        int cost = cost(nums,i,j-1,i,j);
                        dp[i][j] = dp[i][j-1] +  cost;
                    }else{
                        dp[i][j] = Math.min(dp[i][j-1] + cost(nums,i,j-1,i,j),dp[i][j+1] +cost(nums,i,j+1,i,j));
                    }
                }
                else if(j==0){
                    dp[i][j] = Math.min(dp[i-1][j] +cost(nums,i-1,j,i,j),dp[i][j+1] +cost(nums,i,j+1,i,j));
                }else if(j==m-1){
                    dp[i][j] = Math.min(dp[i][j-1] +cost(nums,i,j-1,i,j),dp[i-1][j] +cost(nums,i-1,j,i,j));
                }else{
                    dp[i][j] = Math.min(dp[i][j-1] +cost(nums,i,j-1,i,j),dp[i-1][j] +cost(nums,i-1,j,i,j));
                    dp[i][j] = Math.min(dp[i][j],dp[i][j+1] +cost(nums,i,j+1,i,j));
                }
            }
        }

        System.out.println(dp[n-1][m-1]);


    }

    private static int cost(int[][] nums, int i, int j, int toi, int toj) {
        if(nums[i][j] != nums[toi][toj]){
            return 2;
        }else{
            return 1;
        }
    }
}
