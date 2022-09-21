package com.zms.java.mircsoft.round4;

/**
 * @author: zms
 * @create: 2022/8/25 19:03
 */
public class main01 {
    public static void main(String[] args) {
        System.out.println(solution(-5859));
    }
    public static  int solution(int N) {
        // write your code in Java 8 (Java SE 8)
        int max = Integer.MIN_VALUE;
        String a = "";
        if (N<0){
            a = (N+"").substring(1);
        }else {
            a= N+"";
        }
        int len = a.length();
        for (int i = 0;i<len;i++){
            if(a.charAt(i)=='5'){
                StringBuilder s = new StringBuilder(a);
                s.deleteCharAt(i);
                int i1 = Integer.parseInt(s.toString());
                if(N<0){
                    max = Math.max(max,-1*i1);
                }else{
                    max = Math.max(max,i1);
                }
            }
        }
        return max;
    }
}
