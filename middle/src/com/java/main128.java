package com.java;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: zms
 * @create: 2022/1/9 22:58
 */
public class main128 {
    public int longestConsecutive(int[] nums) {

        //HashSet的底层是HashMap set.add(val) 方法实际上是调用了hashmap的map.put(val,PRESENT) ，这里的PRESENT实际上是一个Object类型的对象 ，没有实际的含义，作为一个虚值
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums){
            set.add(i);
        }
        Iterator<Integer> iterator = set.iterator();
        int max = 0;
        while (iterator.hasNext()){
            int cur = iterator.next();
            int curlen = 1;
            if(!set.contains(cur-1)){
                while(set.contains(++cur)){
                    curlen++;
                }
            }
            max = Math.max(max,curlen);
        }


        return max;
    }
}
