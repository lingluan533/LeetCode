package com.zms.java.mircsoft;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/1/23 16:21
 */
class Solution {
    class Node{
        public int value;
        public int[] node;

        public Node(int value, int[] node) {
            this.value = value;
            this.node = node;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int[] getNode() {
            return node;
        }

        public void setNode(int[] node) {
            this.node = node;
        }
    }
    public int solution(int[] V, int[] A, int[] B) {
        if(V.length==1) return V[0] <=0? 0:V[0];
        Map<Integer,List<Integer>> need = new HashMap<>();
        for(int i = 0;i<B.length;i++){
            if(need.containsKey(B[i])){
                need.get(B[i]).add(A[i]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(A[i]);
                need.put(B[i],list);

            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.value - o1.value;
            }
        });
        for(int i = 0;i<V.length;i++){
            for(int j = i+1;j<V.length;j++){
                int value = 0;
                if(V[i]<0 && V[j]<0)value = Math.max(V[i],V[j]);
                else if(V[i]<0) value = V[j];
                else if(V[j]<0) value = V[i];
                else value = V[i]+ V[j];
                pq.add(new Node(value,new int[]{i,j}));
            }
        }
//        for(int i = 0;i<V.length;i++){
//            pq.add(new Node(V[i],new int[i]));
//        }

        while(!pq.isEmpty()){
            Node n = pq.poll();
            int value = n.value;
            if (n.node.length==1) return value;
            int i = n.node[0];
            int j = n.node[1];

            if(!(need.containsKey(i) || need.containsKey(j))){
                return value;
            }
            if(need.containsKey(i)){
                List<Integer> tem = need.get(i);
                if(tem.size()>=2){
                    continue;
                }else{
                    if (tem.get(0)==j){
                        return value;
                    }else continue;
                }
            }else  if(need.containsKey(j)){
                List<Integer> tem = need.get(j);
                if(tem.size()>=2){
                    continue;
                }else{
                    if (tem.get(0)==i){
                        return value;
                    }else continue;
                }
            }
        }

       return 0;
    }
}


public class main02 {


}
