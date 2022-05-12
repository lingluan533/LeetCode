package com.java;

/**
 * @author: zms
 * @create: 2022/3/18 16:30
 */
public class mianshi1003 {
    public static void main(String[] args) {
        search(new int[]{1,1,1,1,1,2,1,1,1
        },2);
    }
    public static int search(int[] arr, int target) {
        if(arr.length == 1) return arr[0] == target ? 0 : -1;
        int left =  0;
        int len = arr.length;
        int right = len - 1 ;
        while(left < right){
            int mid = left + (right - left ) / 2;
            if(arr[mid] == target){
                while(arr[--mid] == target);
                return mid+1;
            }
            if(arr[mid] > arr[right]){

                if(arr[mid] > target && target >= arr[right]) {
                right = mid - 1;
                }else{
                    left = mid;
                }
            }else if(arr[mid] < arr[right]){
              if(arr[mid] < target && target <= arr[right]){
                  left = mid+1;
              }else{
                  right = mid - 1;
              }
            }else{
                right -- ;
            }
        }

        return arr[left] == target ?  left : -1;
    }
}
