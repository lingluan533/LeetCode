package com.java;

/**
 * @author: zms
 * @create: 2022/10/29 21:41
 */
public class main1864 {
    public int minSwaps(String s) {
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else count1++;
        }
        if (Math.abs(count0 - count1) > 1) return -1;
        int countOdd1 = 0;
        int countOdd0 = 0;
        if (count0 == count1) { // 0 1 相当
            for (int i = 0; i < s.length(); i++) {
                if ((i + 1) % 2 == 1 && s.charAt(i) == '1') {
                    countOdd1++;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if ((i + 1) % 2 == 1 && s.charAt(i) == '0') {
                    countOdd0++;
                }
            }
            return Math.min(countOdd0, countOdd1);
        } else {
            if (count0 > count1) {//0 1 0 1 0
                for (int i = 0; i < s.length(); i++) {
                    if ((i + 1) % 2 == 1 && s.charAt(i) == '1') {
                        countOdd1++;
                    }

                }
                return countOdd1;
            } else { //1 0 1 0 1
                for (int i = 0; i < s.length(); i++) {
                    if ((i + 1) % 2 == 1 && s.charAt(i) == '0') {
                        countOdd0++;
                    }

                }
                return countOdd0;
            }
        }

    }
}
