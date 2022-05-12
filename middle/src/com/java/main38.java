package com.java;

/**
 * @author: zms
 * @create: 2022/4/10 16:50
 */
public class main38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
    public static String countAndSay(int n) {
        int i = 1;
        String cur = "1";
        if(n == 1) return  cur;
        for(i = 2;i<=n;i++){
            char cs [] = cur.toCharArray();
            char curC = cs[0];
            String temp = "";
            int countCurC = 0;
            int j = 0;
            while (j < cs.length){
                curC = cs[j];
                countCurC = 0;
                while (j<cs.length && cs[j] == curC){
                    countCurC++;
                    j++;
                }
                temp += countCurC+""+curC;

            }
            cur = temp;
            if (i==n) return cur;
        }
        return "";
    }
}
