package com.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/4/18 9:11
 */
public class main386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        if(n==1){
            list.add(1);
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                char cs1 [] = (o1 + "").toCharArray();
                char cs2 [] = (o2 + "").toCharArray();
                int len1 = cs1.length;
                int len2 = cs2.length;
                if(cs1.length == cs2.length){// 如果长度相同 那么数字小的字典序肯定也小
                    return o1 - o2;
                }else{
                    int minlen = Math.min(len1,len2);
                    char tem1 []; //短的
                    char tem2[];
                    if(minlen == len1){
                        tem1 = cs1;
                        tem2 = cs2;
                    } else{
                        tem1 = cs2;
                        tem2 = cs1;
                    }
                    for(int i = 0;i<minlen;i++){
                        if (cs1[i] < cs2[i]){
                            return o1-o2;
                        }else if(cs1[i] > cs2[i]) {
                            return o2 - o1;
                        }
                    }
                    if(minlen == len1)
                        return o1-o2;
                    else return o2 - o1;


                }
               // return 0;
            }
        });
        for(int i = 1;i<=n;i++){
            queue.add(i);
        }
     list = new ArrayList<>(queue);
     return list;
    }
}
