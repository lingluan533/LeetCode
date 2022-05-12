package com.java.beibao;

import java.util.Scanner;
/**
 * @author: zms
 * @create: 2022/1/11 12:29
 */
public class beibao0101 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();//物品数量
        int V = scan.nextInt();//背包体积
        int v[] = new int[N];
        int w[] = new int[N];
        for(int i =0;i<N;i++){
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }
        int dp[][] = new int [N][V+1];
        for(int i = 0;i<= V;i++){
            if(i>=v[0]){
                dp[0][i] = w[0];
            }
        }
        for(int i=1;i<N;i++){//遍历所有的
            for(int j = 1;j<=V;j++){
                if(j>=v[i]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-v[i]] + w[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        for(int i=0;i<N;i++){
            for(int j = 1;j<=V;j++){
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println(dp[N-1][V]);

    }

}
