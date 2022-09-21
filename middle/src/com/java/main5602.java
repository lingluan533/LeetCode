package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: zms
 * @create: 2022/9/3 16:47
 */
public class main5602 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> resList = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] > cur[1]) {
                    break;
                }//无需合并
                else {
                    cur[1] = Math.max(cur[1], intervals[j][1]);
                    i++;
                }
            }
            resList.add(cur);
        }
        int res[][] = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
