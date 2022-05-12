package com.java;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: zms
 * @create: 2022/3/29 16:14
 */
public class main5601 {
    class Data {
        int start;
        int end;
        public Data(int _start, int _end){
            this.start = _start;
            this.end = _end;
        }
    }
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        Data[] di = new Data[intervals.length];
        for (int i = 0;i<len;i++){
            di[i] = new Data(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(di, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if(o1.start != o2.start)return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });

        int [][] res = new int[len][2];
        int cur = 0;
        Data temp ;
        res[cur][0] = di[0].start;
        res[cur][1] = di[0].end;
        temp = di[0];
        for(int i = 1;i<len;i++){
           if(di[i].start > temp.end){
               //上个结果可以落地了
               res[cur][0] = temp.start;
               res[cur][1] = temp.end;
               cur++;
               temp = di[i];
           }else if(di[i].start<= temp.end){
               temp.end = Math.max(di[i].end, temp.end);
           }

           if(i == len-1){
               res[cur][0] = temp.start;
               res[cur][1] = temp.end;
               cur++;
           }
        }

        return Arrays.copyOf(res,cur);


    }
}
