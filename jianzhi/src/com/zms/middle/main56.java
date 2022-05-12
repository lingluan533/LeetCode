package com.zms.middle;

/**
 * @author: zms
 * @create: 2022/1/19 22:47
 */
public class main56 {
    public static void main(String[] args) {
        int nums[] = new int[]{1,2,5,2};
        singleNumbers(nums);

    }
    public static int[] singleNumbers(int[] nums) {
        int res = 0;
        for(int i =0;i<nums.length;i++){
            res ^= nums[i];
        }

        int div = 1;
        while((div & res) == 0){  //按位与 全一得一 有0得0
            div<<=1;
        }

        int a = 0,b = 0;
        for(int i = 0;i< nums.length;i++){
           if((nums[i] & div) !=0){
               a^=nums[i];
           }else{
               b^=nums[i];
           }
        }
        return new int[]{a,b};
    }
}
