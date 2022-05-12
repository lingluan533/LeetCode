package com.java;

/**
 * @author: zms
 * @create: 2022/3/20 16:29
 */
public class main5001 {
    public static void main(String[] args) {
        longestPalindrome("aacabdkacaa");
    }
    public static String longestPalindrome(String s) {
            int n = s.length();
            int dp[][] = new int[n][n];
            for(int i = 0;i<n;i++){
                dp[i][i] = 1;
            }
            int start = 0;
            int end = 0;
            char[] cs = s.toCharArray();
            int max =Integer.MIN_VALUE;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<i;j++){
                    if(cs[i]!=cs[j]){
                        continue;
                    }
                    if(i-j<3)dp[j][i] = 1;
                    else
                    dp[j][i] = dp[j+1][i-1];
                    if(dp[j][i] ==1)
                  if(max <i-j+1){
                      max = Math.max(max,i-j+1);
                      start = j;
                      end = i;
                  }


                }
            }
    return s.substring(start,end+1);

    }
}
