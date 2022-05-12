package com.java;

import java.util.Random;

/**
 * @author: zms
 * @create: 2022/4/25 10:25
 */
public class main398 {
    int [] nums ;
    public main398(int[] nums) {
        this.nums  = nums;
    }

    public int pick(int target) {
        int index = 0;
        int num = 0;
        Random random = new Random();
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == target){
                int d = random.nextInt(++num);
                if(d == 0) index = i;
            }
        }
        return index;
    }
}
