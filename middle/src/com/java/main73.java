package com.java;

/**
 * @author: zms
 * @create: 2022/4/6 17:27
 */
public class main73 {
    public static void main(String[] args) {
        int a [][] = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(a);
    }
    public static void setZeroes(int[][] m) {
        boolean rowFlag = false;
        boolean colFlag = false;
        int row = m.length;
        int col = m[0].length;
        for(int i = 0;i<row;i++){
            if(m[i][0] == 0) {
                colFlag = true;
                break;
            }
        }

        for(int i = 0;i<col;i++){
            if(m[0][i] == 0){
                rowFlag = true;
                break;
            }
        }

        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                if(m[i][j] == 0){
                    m[0][j] = 0;
                    m[i][0] = 0;
                }
            }
        }

        for(int i = 1;i<col;i++){
            if(m[0][i] == 0){
               for(int j = 1;j<row;j++){
                   m[j][i] = 0;
               }
            }
        }

        for(int i = 1;i<row;i++){
            if(m[i][0] == 0){
                for(int j = 1;j<col;j++){
                    m[i][j] = 0;
                }
            }
        }

        if(rowFlag){
            for(int i = 0;i<col;i++){
                m[0][i] = 0;
            }
        }
        if(colFlag){
            for(int i = 0;i<row;i++){
                m[i][0] = 0;
            }
        }

    }
}
