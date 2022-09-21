package com.zms.java.duxiaoman;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/31 18:59
 */
public class main02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
      for (int i = 0;i<T;i++){
          int n = scan.nextInt();
          int m = scan.nextInt();
          int k = scan.nextInt();
          int x = scan.nextInt();
          int [][] g = new int[n][m];
          for (int j=0;j<n;j++){
              for (int l = 0;l<m;l++){
                  g[j][l] = scan.nextInt();
              }
          }
            boolean f = false;
          try {
              dfs(g,0,0,g[0][0],n,m,x);
          } catch (Exception e) {
              f = true;
              System.out.println("yes");
          }
          if (!f) System.out.println("no");
      }


    }
   static int [][] flag = new int[][]{{1,0},{0,1}};
    private static void dfs(int[][] g, int x, int y, int sum,int n,int m,int target) throws Exception {
        if (x==n-1 && y == m-1 ){
            if (sum == target) throw new Exception();
            return;
        }
        for (int i = 0;i<2;i++){
            int newX = x + flag[i][0];
            int newY = y + flag[i][1];
            if (newX<n && newY < m){
                sum += g[newX][newY];
                dfs(g,newX,newY,sum,n,m,target);
                sum -= g[newX][newY];
            }
        }

    }
}
