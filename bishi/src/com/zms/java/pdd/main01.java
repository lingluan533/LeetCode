package com.zms.java.pdd;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/20 18:52
 */
public class main01 {
    static class Gua{
        int num;
        int start;
        int end;
        int last;

        public Gua(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
          //  this.last = last;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int i = 0;i<T;i++){
            int n = scan.nextInt();//瓜田数量
            int v = scan.nextInt();//每日最多
            int maxday = 0;int minday = Integer.MAX_VALUE;
            PriorityQueue<Gua> queue = new PriorityQueue<>(new Comparator<Gua>() {
                @Override
                public int compare(Gua o1, Gua o2) {
                    if(o1.start != o1.start)return o1.start-o2.start;
                    return o1.end-o2.end;
                }
            });
            for(int j = 0;j<n;j++){
                int ki = scan.nextInt();
                int ai = scan.nextInt();
                int bi = scan.nextInt();
                if(ai<minday)minday = ai;
                if(bi>maxday) maxday = bi;
                queue.add(new Gua(ki,ai,bi));
            }
            int sum = 0;
        for(int k = minday;k<=maxday;k++){
            int today = v;
            while(today > 0 && !queue.isEmpty()){
                Gua poll = queue.poll();
                if( poll.start<k ){
                    break;
                }
                if(poll.num < today){
                    today -= poll.num;
                    sum += poll.num;

                }else if(poll.num > today){
                    poll.num -= today;
                    sum+=today;
                    today = 0;
                    queue.add(poll);

                }else{
                    sum+=today;
                    today = 0;
                }
            }
        }

            System.out.println(sum);



        }
    }
}
