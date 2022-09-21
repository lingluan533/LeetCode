package com.zms.java.zijie;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/28 9:50
 */
public class main05 {
    public static  void maxProduct(int nums[]){
        int len = nums.length;
        long maxn[] = new long[len];
        long minn[] = new long[len];
        int maxindex[] = {0,0};
        int ansindex[] = {0,0};
        long ans;
        ans = maxn[0]=minn[0] = nums[0];
        for (int i = 1;i<len;i++){
            if (nums[i]>0){
                if (nums[i]<=maxn[i-1]*nums[i]){
                    maxindex[1] = i;
                }
                if (nums[i]>maxn[i-1]*nums[i]){
                    maxindex[0] = maxindex[1] =i;
                }
                maxn[i]=Math.max(maxn[i-1]*nums[i], nums[i]);
                minn[i] = Math.min(minn[i-1]*nums[i],nums[i] );
            }
            if (maxn[i]>ans){
                ansindex=maxindex;
            }
            ans = Math.max(ans,maxn[i]);
        }
        System.out.println((ansindex[0]+1)+" "+(ansindex[1]+1));
    }
    public static void main(String[] args) {

        Scanner scan =new Scanner(System.in);
        int t = scan.nextInt();
        while (t-->0){
            int n = scan.nextInt();
            int nums[] = new int[n];
            for (int i=0;i<n;i++){
                nums[i] = scan.nextInt();
            }
            maxProduct(nums);

        }
    }
}
