package com.zms.java;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/24 21:26
 */
public class test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();

        int[][] flag = new int[n][m];
        String[] strings = new String[n];
        scanner.nextLine();
        for(int i = 0; i < n; i++){
            strings[i] = scanner.nextLine();
        }

        for(int i = 0; i < q; i++){
            int x1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int y2 = scanner.nextInt();

            for(int j = x1; j <= x2; j++){
                for(int k = y1; k <= y2; k++){
                    flag[j-1][k-1] += 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            char[] chars = strings[i].toCharArray();
            for(int j = 0; j < m; j++){
                if (flag[i][j] % 2 == 1){
                    if (chars[j] >= 'a'){
                        chars[j] -= 32;
                    }else{
                        chars[j] += 32;
                    }
                }
            }
            System.out.println(chars);
        }
    }
}
