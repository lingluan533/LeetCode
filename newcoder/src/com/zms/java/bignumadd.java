package com.zms.java;

/**
 * @author: zms
 * @create: 2022/9/21 10:19
 */
public class bignumadd {
    public String solve(String s, String t) {
        // write code here
        String ls = s;
        String ss = t;
        if (ls.length() < ss.length()) {
            ls = t;
            ss = s;
        }
        int jin = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int li = ls.length() - 1;
        int si = ss.length() - 1;
        while (si >= 0) {
            int scur = ss.charAt(si) - '0';
            int lcur = ls.charAt(li) - '0';
            int curSum = scur + lcur + jin;
            jin = curSum / 10;
            int curRes = curSum % 10;
            stringBuilder.append(curRes);
            si--;
            li--;
        }
        while (li >= 0) {
            int curSum = ls.charAt(li) - '0' + jin;
            jin = curSum / 10;
            int curRes = curSum % 10;
            stringBuilder.append(curRes);
            li--;
        }
        if (jin > 0) stringBuilder.append(jin);
        return stringBuilder.reverse().toString();
    }
}
