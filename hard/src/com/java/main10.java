package com.java;

/**
 * @author: zms
 * @create: 2022/8/27 16:06
 */
public class main10 {
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        boolean ma[][] = new boolean[n+1][m+1];
        ma[0][0] = true;
        for (int i=1;i<=n;i++){
            if (p.charAt(i-1)=='*'){
                ma[i][0] = ma[i-2][0];
            }
        }
        for (int i = 1;i<=n;i++){ // 遍历p
            for (int j = 1;j<=m;j++){ //遍历s
                if (p.charAt(i-1)==s.charAt(j-1) || p.charAt(i-1)=='.'){
                    ma[i][j] = ma[i-1][j-1];
                }else if (p.charAt(i-1)=='*'){
                    if(p.charAt(i-2)==s.charAt(j-1)|| p.charAt(i-2)=='.'){
                        ma[i][j] = ma[i-2][j] || ma[i][j-1] ;
                    } else{ //只能让*前面的一个字母消失，才有可能匹配（取决于去掉之后的结果）
                        ma[i][j] = ma[i-2][j];
                    }
                }
            }
        }
        return ma[n][m];
    }
}
