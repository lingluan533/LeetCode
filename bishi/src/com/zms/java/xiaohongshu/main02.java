package com.zms.java.xiaohongshu;



import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/28 16:30
 */
public class main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long  K = scanner.nextLong();
        long ary[] = new long[n];
        boolean [][] ma = new boolean[n][n];
        for (int i = 0;i<n;i++){
            ary[i] = scanner.nextLong();
        }
        Arrays.sort(ary);
        for (int i = 0;i<n;i++){
            for (int j=0;j<i;j++){
                if (ma[i][j]) continue; //tiaoguo

                if ((i-1>=0 && ma[i-1][j]) ||(j-1>= 0&& ma[i][j-1]) || ary[i]*ary[j] >=K){
                    ma[i][j] = true;
                    for (int k = j;k<i;k++){//向右全部符合
                        ma[i][k] = true;
                    }
                    for(int l=i;l<n;l++){
                        ma[l][j] = true;
                    }
                }
            }
        }
        long res = 0;
        for (int i = 0;i<n;i++){
            for (int j = 0;j<i;j++){
                if (ma[i][j]) res+=2;
            }
        }
        System.out.println(res);
    }
}
