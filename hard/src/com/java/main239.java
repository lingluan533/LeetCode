package com.java;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/9/6 9:44
 */
public class main239 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 7, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        int res[] = new int[len - k + 1];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            queue.add(new int[]{i, nums[i]}); //先将新值加入到优先级队列中
            if (i >= k - 1) {    // 如果超过了最小的窗口时
                while (queue.peek()[0] <= i - k)
                    queue.poll();//移除不在窗口中的最大值 i-k为当前窗口的下标下限 ， 如果队列首部的元素的下标小于下限，则应该弹出 直到队列首部为当前窗口内的最大元素
                res[ans++] = queue.peek()[1];
            }
        }
        return res;
    }
}
