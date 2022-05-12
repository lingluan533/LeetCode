package com.java;

/**
 * @author: zms
 * @create: 2022/3/17 22:45
 */
public class main4202 {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax [] = new int[n];
        int rightMax [] = new int[n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        for(int i =1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i] );
        }
        for(int j = n-2;j>=0;j--){
            rightMax[j] = Math.max(rightMax[j+1],height[j]);
        }
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
    return sum;
    }
}
