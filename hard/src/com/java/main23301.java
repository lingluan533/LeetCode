package com.java;

/**
 * @author: zms
 * @create: 2022/9/4 10:16
 */
public class main23301 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
    }

    public static int countDigitOne(int n) {
        //abcde
        String ns = String.valueOf(n);
        int len = ns.length();
        int pre[] = new int[len];
        int post[] = new int[len];
        post[0] = Integer.parseInt(ns.substring(1));
        for (int i = 1; i < len - 1; i++) {
            pre[i] = Integer.parseInt(ns.substring(0, i));
            post[i] = Integer.parseInt(ns.substring(i + 1));
        }
        pre[len - 1] = Integer.parseInt(ns.substring(0, len - 1));
        int count = 0;
        // 1<_____1______<abcde
        for (int i = 0; i < len; i++) {
            int cur = ns.charAt(i) - '0', lenpost = len - i - 1;
            int prefix = pre[i], suffix = post[i];
            int res = 0;
            res += prefix * Math.pow(10, lenpost);
            if (cur == 0) {
            } else if (cur == 1) {
                res += suffix + 1;
            } else {//cur>1
                res += Math.pow(10, lenpost);
            }
            count += res;
        }
        return count;
    }
}
