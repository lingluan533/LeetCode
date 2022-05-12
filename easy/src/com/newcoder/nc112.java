package com.newcoder;

/**
 * @author: zms
 * @create: 2022/3/14 17:31
 */
public class nc112 {
    public static void main(String[] args) {
        //System.out.println(100000%16);
        System.out.println(solve(-100000000, 16));
    }
    public static String solve (int M, int N) {
        // write code here
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        if(M<0){
            M = -1*M;
            flag = false;
        }
        while(M!=1){
            int yu = M%N;
            if(yu>9){
                sb.append((char)('A' + (yu-10)));
            }else{
                sb.append(yu+"");
            }
            M = M / N;
        }
        sb.append('1');
        String res = sb.reverse().toString();
        if(!flag) return "-"+res;
        return res;
    }
}
