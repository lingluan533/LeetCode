package com.zms.easy;

/**
 * @author: zms
 * @create: 2022/1/8 23:43
 */
public class jianzhi05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i)==' '){
                sb.append("%20");
            }else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
