package com.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: zms
 * @create: 2022/1/17 12:38
 */
public class main17901 {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int []{3,30,34,5,9}));
    }
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String s[] = new String[n];
        for(int i = 0;i<nums.length;i++){
            s[i]  = nums[i] +"";
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            //对Comparetor.compare(o1, o2)方法的返回值，如果返回的值小于零，则不交换两个o1和o2的位置；如果返回的值大于零，则交换o1和o2的位置。

            //《正交原则》
            public int compare(String o1, String o2) {
                String a = o1+o2;
                String b = o2+o1;
                return b.compareTo(a); //返回值大于0说明b>a ，字符串比较  ： b.compareTo(a)按字符进行挨个比较，如果b某个位上的值大于对应a位置的字符串则返回正数
                                                                        // 如果b某个位上的值小于对应a位置的字符串则返回负数
                                                                        //如果minlen(a,b) 长度的字符串比较完了但是没比较出结果，则比较长度，如果len(b)>len(a) 则返回正数
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String ss : s)sb.append(ss);
        int len = sb.length();
        int k = 0;
        while(k<len-1 && sb.charAt(k)=='0') k++;
        return sb.substring(k);


    }
}
