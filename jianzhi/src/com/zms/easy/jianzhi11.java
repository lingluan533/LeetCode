package com.zms.easy;

/**
 * @author: zms
 * @create: 2022/2/15 18:06
 */
public class jianzhi11 {
    public static void main(String[] args) {
        minArray(new int[]{3,4,4,4,4,4,5,1,2});
    }
    public static int minArray(int[] numbers) {

        int left = 0;
        int right = numbers.length-1;

        while(left < right){
            int mid = left + (right - left  ) /2 ;
            if(numbers[mid] > numbers[right] ){
                left = mid +1 ;
            }else if(numbers[mid] < numbers[right]){
                right = mid;
            }else right = right - 1;
        }
        return numbers[right];


    }
    }
