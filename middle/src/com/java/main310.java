package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/4/6 14:31
 */
public class main310 {
    public static void main(String[] args) {
        int a[][] = new int[3][2];
        a[0][0] = 1;
        a[0][1] = 0;
        a[1][0] = 1;
        a[1][1] = 2;
        a[2][0] = 1;
        a[2][1] = 3;
        findMinHeightTrees(4,a);
    }
    static HashMap<Integer , ArrayList<Integer>> hashMap;
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        hashMap = new HashMap<>();
       if(n==1) {
           Integer a [] = new Integer[]{0};
           return Arrays.asList(a);
       }

        int edgeLen = edges.length;
        HashMap<Integer,List> map = new HashMap<>();
        for(int i = 0 ; i < edgeLen;i++){
            int num0 = edges[i][0];
            int num1 = edges[i][1];
            if(hashMap.containsKey(num0)){
                ArrayList<Integer> list = hashMap.get(num0);
                list.add(num1);
                hashMap.put(num0,list);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(num1);
                hashMap.put(num0,list);
            }

            if(hashMap.containsKey(num1)){
                ArrayList<Integer> list = hashMap.get(num1);
                list.add(num0);
                hashMap.put(num1,list);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(num0);
                hashMap.put(num1,list);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){//分别以各个节点为根节点 求树的最大层数 即为当前根节点下的树的高度
            boolean vis[] = new boolean[n+1];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            vis[i]  = true;
            //ArrayList<Integer> list1 = new ArrayList<>();

            int curDepth = 0;
            while (queue.isEmpty() == false){
                curDepth++;
                int curSize = queue.size();
                while (curSize > 0){
                    curSize--;
                    Integer curNode = queue.poll(); //出队节点
                    ArrayList<Integer> list = hashMap.get(curNode);
                    for(int j = 0; j<list.size(); j++){
                        if(vis[list.get(j)] ==  false){
                            queue.add(list.get(j));
                            vis[list.get(j)] = true;
                        }
                    }
                }
            }

            if(curDepth < min){
                min = curDepth;
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(curDepth,list);
            }else if(curDepth == min){
                List list = map.get(curDepth);
                list.add(i);
                map.put(curDepth,list);
            }

        }

    return map.get(min);
    }
}
