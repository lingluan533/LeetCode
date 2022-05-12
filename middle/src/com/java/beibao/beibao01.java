package com.java.beibao;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/1/11 12:29
 */
public class beibao01 {

    public static void main(String[] args) {

        getMax(6,15,new int[]{22,1,20,8,13,8},new int[]{126,115,452,632,395,143});
    }
    //N:物品件数  V：容量 v:体积数组 w:价值数组
    public static  int getMax(int N,int V, int v[],int w[]){

        dfs(v,w,0,0,0,V,new boolean[N]);

        return 0;
    }
    static int max = Integer.MIN_VALUE;
    private static void dfs(int[] v, int[] w, int start, int sum,int sumv,int V,boolean visited[]) {
        if(start >= v.length || sumv == V){
            System.out.println(sum);
            return ;
        }

        for(int i = start;i<v.length;i++){
            if(visited[i])continue;
            if(sumv + v[i] <= V){
                sum += w[i];
                visited[i] = true;
                dfs(v,w,i+1,sum,sumv+v[i],V,visited);
                visited[i] = false;
                sum-=w[i];
            }
        }
    }
}
