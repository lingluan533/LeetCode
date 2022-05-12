package com.java;

/**
 * @author: zms
 * @create: 2022/4/24 19:45
 */
public class main868 {
    public int binaryGap(int n) {

        String s = Integer.toBinaryString(n);
        int max = Integer.MIN_VALUE;
        int cur = -1;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='1') {
                cur = i;
                break;
            }
        }
        for(int i = cur + 1 ;i<s.length();i++){
            if(s.charAt(i) == '1'){
                max = Integer.max(max, i - cur);
                cur = i;
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
