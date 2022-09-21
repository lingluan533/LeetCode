package com.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/8/12 23:28
 */
public class main1282 {
    static  class Temp{
        int index;
        int groupCount;

        public Temp(int index, int groupCount) {
            this.index = index;
            this.groupCount = groupCount;
        }
    }

    public static void main(String[] args) {
        groupThePeople(new int[]{3,3,3,3,3,1,3});
    }
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        int len = groupSizes.length;
        List<Temp> ts = new ArrayList<>();
        for (int i = 0;i<groupSizes.length;i++){
            ts.add(new Temp(i,groupSizes[i]));
        }
        ts.sort(new Comparator<Temp>() {
            @Override
            public int compare(Temp o1, Temp o2) {
                return o1.groupCount - o2.groupCount;
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        for (int  i = 0;i<ts.size();i++){
            List<Integer> temp = new ArrayList<>();
            int  curLeft = ts.get(i).groupCount;
            while (curLeft>0){
                temp.add(ts.get(i++).index);
                curLeft--;
            }
            res.add(temp);
            i--;
        }
        return res;

    }
}
