package com.java;

/**
 * @author: zms
 * @create: 2022/3/17 22:32
 */
public class main4201 {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax ,rightMax,sum=0;
        leftMax = height[0];
        rightMax = height[n-1];
        for(int i=0;i<n;i++){

            for(int j = 0;j<=i;j++){  //注意这里的等号 一定要加上，因为这个能判断当前位置是否能够存水，如果当前位置是左边的最大值
                leftMax = Math.max(leftMax,height[j]);
            }
            for(int k = n-1;k>=i;k--){
                rightMax = Math.max(rightMax,height[k]);
            }
            sum += Math.min(leftMax,rightMax) - height[i];
        }
        return sum;
    }
}
