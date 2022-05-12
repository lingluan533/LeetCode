package com.java;

/**
 * @author: zms
 * @create: 2022/3/18 17:32
 */
public class main18902 {
    public static void main(String[] args) {
        int a [] = new int[]{1,2,3,4,5,6,7};
        rotate(a,3);
    }
    public static  void rotate(int[] nums, int k) {
      //123456789
        //k = 3   789123456
        //先将123456789进行一次翻转， 987654321
        //然后将前k个翻转 后n--k个翻转
        int len = nums.length;
        for(int i = 0;i<nums.length/2;i++){
            nums[i] = nums[i] ^ nums[len - 1 - i];
            nums[len-1-i] = nums[i] ^ nums[len - 1 - i];
            nums[i] = nums[len- 1-i] ^  nums[i];
        }

        for(int i = 0;i<k/2;i++){
            nums[i] = nums[i] ^ nums[k - 1 - i];
            nums[k-1-i] = nums[i] ^ nums[k - 1 - i];
            nums[i] = nums[k- 1-i] ^  nums[i];
        }

        for(int i = len -k -1,j=len-1 ; i<len-k+k/2;i++,j--){
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[j] ^  nums[i];
        }
    }
}

