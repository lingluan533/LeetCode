package com.java;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/1/17 11:53
 */
public class main179 {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int []{3,30,34,5,9}));
    }
    public static String largestNumber(int[] nums) {
        //对Comparetor.compare(o1, o2)方法的返回值，如果返回的值小于零，则不交换两个o1和o2的位置；如果返回的值大于零，则交换o1和o2的位置。
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
               if(a.charAt(0) > b.charAt(0)) return -1;
               else if(a.charAt(0) < b.charAt(0)) return 1;
               else {
                 String s = a+b;
                 String ss = b+a;
                 for(int i = 0;i<s.length();i++){
                     if(s.charAt(i) == ss.charAt(i)) continue;
                     else return s.charAt(i) > ss.charAt(i)  ? -1 :1;
                 }
                    return 1;
               }
            }
        });
    boolean flag = false;
        for(int i = 0;i< nums.length;i++){
            if(nums[i] !=0) flag = true;
            pq.add(nums[i]+"");
        }
        if(!flag) return "0";
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        return sb.toString();


    }
}
