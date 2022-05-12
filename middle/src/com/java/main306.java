package com.java;

/**
 * @author: zms
 * @create: 2022/1/10 23:19
 */
public class main306 {
    public static void main(String[] args) {
        isAdditiveNumber("112358");
    }
    public static boolean isAdditiveNumber(String num) {
        if(num.length() < 3) return false;

        return backTrace(num, 0,num.length(),0,0,0);

    }
    private static boolean backTrace(String num,  int begin, int len, long sum,long pre,int k ) {
        if(begin == len) return k>2;
        for(int i=begin; i < len;i++){
            long cur = getcurnum(num,begin,i);
            if(cur<0) continue;
            if(k>=2 && cur!=sum) continue;
            if(backTrace(num,i+1,len,pre+cur,cur,k+1)) return true;
        }
        return false;
    }
    private static long getcurnum(String num, int begin, int i) {
        if(begin < i && num.charAt(begin)=='0') return -1;
        long res = 0;
        while( begin <= i )
        {
            res = res*10 + (num.charAt(begin)-'0');
            begin++;
        }return res;

    }

}