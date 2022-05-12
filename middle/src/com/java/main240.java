package com.java;

/**
 * @author: zms
 * @create: 2022/1/10 23:04
 */
public class main240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m -1;   //遍历行标
        int j = 0;      //遍历列标

        while(i>=0 && j <n){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                i--;
            }else j++;
        }
        return false;

    }
}
