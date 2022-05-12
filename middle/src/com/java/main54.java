package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/1/19 21:59
 */
public class main54 {
    public static void main(String[] args) {
        int a [][] = new int[3][3];
        a[0] = new int[]{1,2,3};
        a[1] = new int[]{4,5,6};a[2] = new int[]{7,8,9};
        System.out.println(spiralOrder(a));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int row = 0,col=0;
        while(count < m * n){
            //向右
            while(col <n && count < m*n && matrix[row][col] != -101){
                res.add(matrix[row][col]);
                matrix[row][col] = -101;
                count++;
                col++;
            }
            //向下
            col-=1;
            row+=1;
            while(row < m &&count < m*n && matrix[row][col] != -101 ){
                res.add(matrix[row][col]);
                matrix[row][col] = -101;
                count++;
                row++;
            }
            row -= 1;
            col-=1;
            //向左
            while(col >= 0 &&count < m*n && matrix[row][col] != -101){
                res.add(matrix[row][col]);
                matrix[row][col] = -101;
                count++;
                col--;
            }
            col +=1;
            row-=1;
            //向上
            while(row >=0  &&count < m*n && matrix[row][col] != -101){
                res.add(matrix[row][col]);
                matrix[row][col] = -101;
                count++;
                row--;
            }
            row+=1;
            col+=1;
        }
        return res;
    }
}
