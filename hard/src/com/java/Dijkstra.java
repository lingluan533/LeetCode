package com.java;

import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/3/8 22:03
 */

public class Dijkstra {

    public static void main(String[] args) {

    }
    /*
    * 根据地杰斯特拉算法求图中一个节点v0到其他各个点的最短径及路径长度
    * g:为图的邻接矩阵表示  有向图
    * v0:为起始点
    * dist[]:记录了v0到其他各个顶点的最短路径的的长度
    * path[]:记录了v0到对应下标的顶点的最短路径的上一个节点，依次上找即可以形成一条路径
    * */
    public static void Dijkstra(int [][] g, int v0, int dist[], int path[]){
            boolean  visited[] =  new boolean[g.length];  //标识是否已经计算过，是否已经加入了S集合
            int len = g.length;
        for(int i = 0;i<len;i++){
            dist[i] = g[v0][i] ; //初始距离
            path[i] = dist[i] == Integer.MIN_VALUE ? -1 : v0; //路径初始化
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
                    path[j] = temp;
                }
            }

        }

    }

    //关键操作结束
    //结束之后dist中保存了v点到其余顶点的最短路径长度 path[]中存放v点到其余各顶点的最短路径

    public void printPath(int []path,int a) { //输出v0---->a的路径以及最短路径的长度
        Stack<Integer> stack = new Stack<>();

        while(path[a]!=-1){
            stack.push(path[a]);
            a = path[a];
        }
        stack.push(a);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }


}

