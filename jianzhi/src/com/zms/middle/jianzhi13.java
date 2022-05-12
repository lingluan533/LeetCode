package com.zms.middle;

/**
 * @author: zms
 * @create: 2022/2/15 18:46
 */
public class jianzhi13 {
    public static void main(String[] args) {
        System.out.println(movingCount(16, 8, 4));
    }
    public static  int movingCount(int m, int n, int k) {
        int count = 0;
        boolean v [] [] = new boolean[m][n];
        dfs(0,0,v,k,m,n);
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(v[i][j]) count++;
            }
        }
        return  count;
    }

    private static void dfs(int i, int j, boolean[][] v,int k,int m,int n) {
        if( i<0 || i== m || j<0 || j==n|| v[i][j] ){
            return ;
        }
        if(getSum(i,j) <= k ){
            v[i][j] = true;
        }else{
            return ;
        }
        //向上
        dfs(i-1,j,v,k,m,n);
        //向左
        dfs(i,j-1,v,k,m,n);
        //向右
        dfs(i,j+1,v,k,m,n);
        //向下
        dfs(i+1,j,v,k,m,n);
    }


    private static int getSum(int m, int n) {
        int sum = 0;
        for (Character a:(m+"").toCharArray()){
            sum += (a -'0');
        }
        for (Character a:(n+"").toCharArray()){
            sum += (a -'0');
        }
        return sum;
    }
}
