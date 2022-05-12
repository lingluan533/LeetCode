package com.zms.middle;

/**
 * @author: zms
 * @create: 2022/2/14 23:52
 */
public class main04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        int m = matrix.length;;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while( i>= 0 && j<= n-1){
            if(matrix[i][j] > target){
                i -- ;
            }else if(matrix[i][j] < target){
                j ++;
            }else return true;
        }
        return false;
    }
}
