package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/3/20 16:07
 */
public class main5402 {
    public int [][] flag = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res  = new ArrayList<>();
        int i= 0,j=0;
        int count = 0;
        int row = matrix.length;
        int col = matrix[0].length;
       while(count < row * col){
           for( ;j<col;j++ ){//右
                if(matrix[i][j] != -101){
                    res.add(matrix[i][j]);
                    matrix[i][j] = -101;
                    count++;
                }else{
                    break;
                }
           }
           //向下
           i++;
           j--;
           for(;i<row;i++){ //下
               if(matrix[i][j]!=-101){
                   res.add(matrix[i][j]);
                   matrix[i][j] = -101;
                   count++;
               }else{
                   break;
               }
           }
           //向左
           i--;
           j--;
           for(;j>=0;j--){ // 左
               if(matrix[i][j]!=-101){
                   res.add(matrix[i][j]);
                   matrix[i][j] = -101;
                   count++;
               }else{
                   break;
               }
           }
           //向上
           j++;
           i--;

           for(;i>=0;i--){//上
               if(matrix[i][j]!=-101){
                   res.add(matrix[i][j]);
                   matrix[i][j] = -101;
                   count++;
               }else break;
           }

           i++;
           j++;

       }
        return res;
    }
}
