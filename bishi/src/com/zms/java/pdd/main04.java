package com.zms.java.pdd;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author: zms
 * @create: 2022/3/20 18:52
 */
public class main04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scan.nextInt();//瓜田数量
            int v = scan.nextInt();//每日最多
            int maxday = 0;
            int minday = Integer.MAX_VALUE;
            ArrayList<int[]> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int ki = scan.nextInt();
                int ai = scan.nextInt();
                int bi = scan.nextInt();
                if(ai<minday)minday = ai;
                if(bi>maxday) maxday = bi;
                list.add(new int[]{ki,ai,bi});
            }
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                   // if( o1[1] != o2[1]) return o1[1] - o2[1];
                    return o1[2] - o2[2];
                }
            });
            int sum  = 0;
            for(int k = minday;k<=maxday;k++){
                int today = v;//今日剩余可以摘
                for(int l =0;l<list.size();l++){
                    if(list.get(l)[1] > k) continue;//还没熟透呢
                    if(list.get(l)[2] < k) {
                        list.remove(l);//过期了
                    }
                    else if(list.get(l)[0] > today){
                        list.get(l)[0] -= today;
                        sum+=today;
                        break;
                    }else if(list.get(l)[0]<=today){ //全部摘掉
                        sum+=list.get(l)[0];
                        today -=list.get(l)[0];
                        list.remove(l);
                        if(today==0)break;
                    }
                }
            }

            System.out.println(sum);





        }
    }}
