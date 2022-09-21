package com.zms.java.zijie;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/28 9:50
 */
public class main03 {
    public static void swap(int []nums,int i,int j){
        while (i<j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;j--;
        }
    }
    public  static int maxSub(int []nums){
        int pre = 0;
        int maxAns = nums[0];
        for (int x:nums){
            pre = Math.max(pre + x,x);
            maxAns = Math.max(maxAns,pre);
        }
        return maxAns;
    }
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int n = scan.nextInt();
        int nums[] = new int[n];
        for (int i= 0;i<n;i++){
            nums[i] = scan.nextInt();
        }
        int ans = Integer.MIN_VALUE;
        for (int i=0;i<n-1;i++){
            for (int j = 1;j<n;j++){
                swap(nums,i,j);
                ans = Math.max(ans,maxSub(nums));
                swap(nums,i,j);
            }
        }
        System.out.println(ans);
    }
}
