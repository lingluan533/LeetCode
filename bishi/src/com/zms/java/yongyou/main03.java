package com.zms.java.yongyou;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/9/9 20:16
 */
public class main03 {

    public int[] findBuilding(int[] heights) {
        // write code here
        int res[] = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            Stack<Integer> left = new Stack<>();
            Stack<Integer> right = new Stack<>();
            int leftC = 0;
            int rightC = 0;
            int rightMax = heights[i];
            int leftMax = heights[i];
            for (int j = i + 1; j < heights.length; j++) {
                if (right.isEmpty()) {
                    right.push(heights[j]);
                    continue;
                }
                if (right.peek() > heights[j]) {
                    continue;
                } else {
                    rightMax = Math.max(rightMax, heights[j]);
                    if (rightMax > heights[i]) {
                        break;
                    }
                    right.push(heights[j]);
                }
            }
            rightC = right.size();

            for (int j = i - 1; j >= 0; j--) {
                if (left.isEmpty()) {
                    left.push(heights[j]);
                    continue;
                }
                if (left.peek() > heights[j]) {
                    continue;
                } else {
                    leftMax = Math.max(leftMax, heights[j]);
                    if (leftMax > heights[i]) {
                        break;
                    }
                    left.push(heights[j]);
                }
            }
            leftC = left.size();
            res[i] = leftC + rightC + 1;
        }
        return res;
    }
}
