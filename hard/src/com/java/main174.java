package com.java;

/**
 * @author: zms
 * @create: 2022/4/28 15:45
 */
public class main174 {
    public static void main(String[] args) {
        int a[][] = new int[][]{{1,-3,3},{0,-2,0},{-3,-3,-3}};
        System.out.println(calculateMinimumHP(a));
    }
    public static int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int dp[][] = new int[row][col];
        int left[][] = new int[row][col];
        dp[0][0] = dungeon[0][0] > 0 ? 1 : -1*dungeon[0][0] + 1;
        left[0][0] = dungeon[0][0] >= 0 ? dp[0][0] + dungeon[0][0] : dp[0][0] + dungeon[0][0] ;
        for(int i = 0;i<row;i++){
            for(int j = 0; j < col; j ++ ){
                if(i == 0 && j == 0) continue;
                if(i==0){
                    if(dungeon[i][j] >= 0){
                        dp[i][j] = dp[i][j-1];
                        left[i][j] = left[i][j-1] + dungeon[i][j];
                    }else{
                        int rightleft = left[i][j-1] + dungeon[i][j];
                        int temright = dp[i][j-1];
                        if(rightleft <= 0){
                            temright += 1 - rightleft;
                            rightleft = 1;
                        }
                        dp[i][j] = temright;
                        left[i][j] = rightleft;
                    }
                    continue;
                }
                if(j==0){
                    if(dungeon[i][j] >= 0){
                        dp[i][j] = dp[i-1][j];
                        left[i][j] = left[i-1][j] + dungeon[i][j];
                    }else{
                        int topleft = left[i-1][j] + dungeon[i][j];
                        int temtop = dp[i-1][j];
                        if(topleft <= 0) {
                            temtop += 1 - topleft;
                            topleft = 1;
                        }
                        dp[i][j] = temtop;
                        left[i][j] = topleft;
                    }
                    continue;
                }
                    if(dungeon[i][j] >= 0){ //left 和 dp的选择策略？

                        if(left[i-1][j] < left[i][j-1]){
                             
                        }


                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
                        if(dp[i-1][j] < dp[i][j-1]){
                            left[i][j] = left[i-1][j] + dungeon[i][j];
                        }else if(dp[i-1][j] > dp[i][j-1]){
                            left[i][j] = left[i][j-1] + dungeon[i][j];
                        }else{
                            left[i][j] = Math.max( left[i-1][j] + dungeon[i][j],left[i][j-1] + dungeon[i][j]);
                        }
                        continue;
                    }else{
                        int topleft = left[i-1][j] + dungeon[i][j];
                        int temtop = dp[i-1][j];
                        if(topleft <= 0) {
                            temtop += 1 - topleft;
                            topleft = 1;
                        }

                        int rightleft = left[i][j-1] + dungeon[i][j];
                        int temright = dp[i][j-1];
                        if(rightleft <= 0){
                            temright += 1 - rightleft;
                            rightleft = 1;
                        }

                        if(temtop < temright){
                            dp[i][j] = temtop;
                            left[i][j] = topleft;
                        }else if(temtop == temright){
                            dp[i][j] = temtop;
                            left[i][j] = Math.max(rightleft,topleft);
                        }else{
                            dp[i][j] = temright;
                            left[i][j] = rightleft;
                        }

                    }
            }
        }
        return dp[row-1][col-1];
    }
}
