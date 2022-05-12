package com.zms.java.qihu360;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/19 15:53
 */
public class main02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
      long n = scan.nextLong();
      int q = scan.nextInt();
      Long l = 0L,r = 0L;
        PriorityQueue<Long[]> whiteq = new PriorityQueue<>(new Comparator<Long[]>() {
            @Override
            public int compare(Long[] o1, Long[] o2) {
                return (int) (o1[0] - o2[0]);
            }
        });
        PriorityQueue<Long[]> blackq = new PriorityQueue<>(new Comparator<Long[]>() {
            @Override
            public int compare(Long[] o1, Long[] o2) {
                return (int) (o1[0] - o2[0]);
            }
        });
        blackq.add(new Long[]{1L,n});
        ArrayList<Long[]> whiteL ,blackL;
        ArrayList<Long[]> newblackL,newwhiteL;
      for(int i =0;i<q;i++){
            l = scan.nextLong();
            r = scan.nextLong();
            //把所有的白的区间和黑的区间取出来
          whiteL = new ArrayList<>();
          blackL = new ArrayList<>();
          newblackL = new ArrayList<>();
          newwhiteL = new ArrayList<>();
          while(!whiteq.isEmpty()){
              Long[] peek = whiteq.peek();
              if(peek[0]>r || peek[1]<l){
                  whiteL.add(whiteq.poll());
              }     //判断是否在当前翻转的外面
              else{     //根据具体情况进行区间切分
                if(peek[0]>=l && peek[1]<=r){//完全包含
                    Long[] poll = whiteq.poll();
                    newblackL.add(poll);
                }else if(peek[0]<l && peek[1] > r){ //分三段
                    Long[] poll = whiteq.poll();
                    whiteL.add(new Long[]{peek[0],(l-1)});
                    newblackL.add(new Long[]{l,r});
                    whiteL.add(new Long[]{r+1,peek[1]});
                }else if(peek[0] < l && peek[1]<=r){ //左两端
                    Long[] poll = whiteq.poll();
                    whiteL.add(new Long[]{peek[0],r});
                    newblackL.add(new Long[]{r+1,peek[1]});
                }else{
                    Long[] poll = whiteq.poll();
                    newblackL.add(new Long[]{peek[0],r});
                    whiteL.add(new Long[]{r+1,peek[1]});
                }
              }//得到的newblackL在黑色处理完再加入到黑色的链表中
          }
/*
* 100 2
1 30
21 40*/
          while(!blackq.isEmpty()){
              Long[] peek = blackq.peek();
              if(peek[0]>r || peek[1]<l){
                  blackL.add(blackq.poll());
              }     //判断是否在当前翻转的外面
              else{     //根据具体情况进行区间切分
                  if(peek[0]>=l && peek[1]<=r){//完全包含
                      Long[] poll = blackq.poll();
                      newwhiteL.add(poll);
                  }else if(peek[0]<l && peek[1] > r){ //分三段
                      Long[] poll = blackq.poll();
                      blackL.add(new Long[]{peek[0],(l-1)});
                      newwhiteL.add(new Long[]{l,r});
                      blackL.add(new Long[]{r+1,peek[1]});
                  }else if(peek[0] < l && peek[1]<=r){ //左两端
                      Long[] poll = blackq.poll();
                      blackL.add(new Long[]{peek[0],r});
                      newwhiteL.add(new Long[]{r+1,peek[1]});
                  }else{
                      Long[] poll = blackq.poll();
                      newwhiteL.add(new Long[]{peek[0],r});
                      blackL.add(new Long[]{r+1,peek[1]});
                  }
              }//得到的newblackL在黑色处理完再加入到黑色的链表中
          }

          for(Long[] newwl: newwhiteL){
              whiteL.add(newwl);
          }
          for(Long[] newbl : newblackL){
              blackL.add(newbl);
          }

            Long sum = 0L;
          for(Long[] black : blackL){
              sum += black[1] - black[0] + 1 ;
          }
          System.out.println(sum);

          whiteq.addAll(whiteL);
          blackq.addAll(blackL);
      }
    }
}
