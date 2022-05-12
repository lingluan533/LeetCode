package com.zms.java.wangyileihuo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/3/26 14:39
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int product [] = new int[]{5,5,6,6,10,10,10,10,10,10};
        int path [][] = new int[][]{{0,1,5},{1,0,2},{5,1,0}};

        System.out.println(getMinimumTime(product, path));


    }

    public static int getMinimumTime (int[] productList, int[][] drivingTimes) {
        int dist [] = new int[drivingTimes.length];
        Dijkstra(drivingTimes,0,dist);
         int min = dist[drivingTimes.length-1];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int a : productList){
            queue.add(a);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int cur = 0;
            Integer poll = queue.poll();
           cur += poll;
            if(cur <10){
                while(!queue.isEmpty() && cur + queue.peek() <=10 ){
                    queue.poll();
                }
                count ++;
                continue;
            }else{
                count ++;
                continue;
            }
        }
        if(count % 4==0) return min + (count -4 )/4 *2*min;
        int sum = 0;
        if(count<=4) return min;
        while(count >= 4){
            sum += (count / 4) *2* min;
            count = count - (count / 4) * 4;
        }
        if(count != 0)
        return sum +  min;
        else return sum;
    }
            /*
             * 根据地杰斯特拉算法求图中一个节点v0到其他各个点的最短径及路径长度
             * g:为图的邻接矩阵表示  有向图
             * v0:为起始点
             * dist[]:记录了v0到其他各个顶点的最短路径的的长度
             * path[]:记录了v0到对应下标的顶点的最短路径的上一个节点，依次上找即可以形成一条路径
             * */
            public static void Dijkstra(int [][] g, int v0, int dist[]){
                boolean  visited[] =  new boolean[g.length];  //标识是否已经计算过，是否已经加入了S集合
                int len = g.length;
                for(int i = 0;i<len;i++){
                    dist[i] = g[v0][i] ; //初始距离
                   // path[i] = dist[i] == Integer.MIN_VALUE ? -1 : v0; //路径初始化
                }
                visited[v0] = true;
                for(int i = 0;i<len;i++){
                    int min = Integer.MAX_VALUE,temp=0;
                    for(int j = 0;j<len;j++){
                        if(visited[j] == false && dist[j] < min){  //寻找下一个加入s的节点  要求到vo的距离是t中最小的
                            temp = j;
                            min = dist[j];
                        }
                    }
                    //找到了新的未加入到S中的最短路径的点
                    for(int j=0;j<len;j++){
                        if(!visited[j] && dist[temp] + g[temp][j] < dist[j] ){
                            //更新路径及长度
                            dist[j] = dist[temp] + g[temp][j];
                         //   path[j] = temp;
                        }
                    }
                }
            }
}
