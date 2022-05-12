package com.java;



/**
 * @author: zms
 * @create: 2022/3/18 19:44
 */
public class main101101 {
    public static void main(String[] args) {
        shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10},5);
    }
    public static   int[] Weights =null ;
    public  static int Days =0 ;
    public static int shipWithinDays(int[] weights, int days) {
        Weights = weights;
        Days = days;
        int sum = 0;
        for(Integer i :  weights){
            sum += i;
        }
        int left = 0;
        int right = sum;
        while(left < right){
            int mid = left + (right - left ) / 2 ; //右移一位等于缩小二倍
            if(check(mid)){
                //符合要求，可以尝试更小的
                right = mid -1 ;
            }else{
                //不符合要求，尝试更大的
                left = mid +1 ;
            }
        }
        return left;
    }
    public static boolean check(int target){
            int curDay = 0;
            int day = 0;
            for(int i = 0;i<Weights.length;i++){
                if(day >= Days) return false;
                if(curDay + Weights[i] < target){
                    curDay += Weights[i];
                    continue;
                }else if(curDay + Weights[i] == target){
                    curDay = 0;
                    day ++;
                    continue;
                }else{
                    i--;
                    curDay = 0;
                    day++;
                }
            }
            if(day <= Days){
                return true;
            }
            return false;
    }
}
