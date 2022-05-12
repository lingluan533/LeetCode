package com.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: zms
 * @create: 2022/1/22 11:05
 */
class Solution1 {
    private int [] nums ;

    public Solution1(int[] nums) {
        this.nums = nums;
    }



    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int tem [] = nums.clone();
        Random r = new Random();
        for(int i = 0;i< tem.length;i++){
            swap(tem,i,r.nextInt(tem.length)); //洗牌算法
        }
        return tem;
    }

    private void swap(int[] tem, int i, int nextInt) {
        int a = tem[i];
        tem[i] = tem[nextInt];
        tem[nextInt] = a;
    }


}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
public class main38401 {
}
