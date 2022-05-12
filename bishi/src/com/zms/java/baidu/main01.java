package com.zms.java.baidu;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/22 19:24
 */
public class main01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int src [][] = new int[N][N];
        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                src[i][j] = scan.nextInt();
            }
        }
        int tar = N * K;
        int dest [][] = new int[tar][tar];

        for(int i = 0;i<N;i++){
            for(int j = 0;j<N;j++){
                for(int k = i*K;k<(i+1)*K;k++){
                    for(int l = j*K;l<(j+1)*K;l++){
                        dest[k][l] = src[i][j];
                     //   System.out.print(dest[k][l]+" ");
                    }
                    //System.out.println();
                }
            }
        }

        for(int i = 0;i<tar;i++){
            for(int j = 0;j<tar;j++){
                if(j!=tar-1)
                System.out.print(dest[i][j]+" ");
                else System.out.println(dest[i][j]);
            }
        }

    }
}
