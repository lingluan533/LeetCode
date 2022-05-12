package com.zms.java.ali.ali314;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/14 18:45
 */
public class main02 {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(System.in);
        Scanner scan = new Scanner(bufferedInputStream);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int a [][] = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){//列
                a[i][j] = scan.nextInt();
                 }
        }
        int res= 0;
        for(int i = 0;i<n;i++){//行
            for(int j = 0;j<m;j++){//列
                if(a[i][j] == 1) continue;
                int curscore = 0;
                //上
                //boolean flag1 = true;
                for(int k = i-1;k>=0;k--){
                    if(a[k][j] == 1 ){
                        curscore++;
                        break;
                    }
                }
            //xia
                for(int l = i+1;l<n;l++){
                    if(a[l][j]==1){
                        curscore++;
                        break;
                    }
                }
                for(int k = j-1;k>=0;k--){
                    if(a[i][k] == 1){
                        curscore++;
                        break;
                    }
                }
//you
                for(int k = j+1;k<m;k++){
                    if(a[i][k] == 1){
                        curscore++;
                        break;
                    }
                }
                res += curscore;

                //↓
                //左
                // 右
            }
        }
        System.out.println(res);

    }
}
