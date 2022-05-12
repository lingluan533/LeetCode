package com.java;

import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/1/12 23:34
 */
public class main33402 {
    public static void main(String[] args) {
        increasingTriplet(new int []{2,1,5,0,4,6});
    }
    public static boolean increasingTriplet(int[] nums) {
    int n = nums.length, ans = 1;
    int[] f = new int[n + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        for (int i = 0; i < n; i++) {
        int t = nums[i];
        int l = 1, r = i + 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (f[mid] >= t) r = mid;
            else l = mid + 1;
        }
        f[r] = t;
        ans = Math.max(ans, r);
    }
        return ans >= 3;


}
}
