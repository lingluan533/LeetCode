package com.java;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2022/3/18 22:11
 */
public class main460 {
    class Node implements Comparable{
        int key;
        int val;
        int freq;       //用于描述使用的次数
        int idx;        //全局的操作自增id，用于描述操作的顺序
        public Node(int key, int val, int freq, int idx) {
            this.key = key;
            this.val = val;
            this.freq = freq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Object o) {
            Node other = (Node)o;
            if(this.freq != other.freq){
                return this.freq - other.freq;
            }else{
                return this.idx - other.idx;
            }
        }
    }
    class LFUCache {
        public PriorityQueue<Node> queue ;
        public HashMap<Integer,Node> map;
        public Integer max ;
        public Integer idx = 0;
        public LFUCache(int capacity) {
            this.queue = new PriorityQueue<>(capacity);
            this.max = capacity;
            this.map = new HashMap<Integer,Node>();
        }

        public int get(int key) {
            if(this.max == 0) {
                return -1;
            }
            if(map.containsKey((Integer)key)){
                //如果存在这个值
                Node node = map.get(key);
                //更新对应的节点于队列中
                queue.remove(node);
                node.freq +=1;
                node.idx = idx++;
                queue.add(node);
                return node.val;
            }else{
                return -1;
            }
        }

        public void put(int key, int value) {
            if(this.max == 0) {
                return ;
            }

            if(map.containsKey(key)){
                //如果包含这个key  则为修改操作
                Node node = map.get(key);
                queue.remove(node);
                node.val = value;
                node.freq ++;
                node.idx = idx++;
                queue.add(node);
            }else{
                //否则，为添加  需要判断是否满了
                if(map.size() == max){
                    System.out.println(map.size());
                    //满了，先移除
                    Node peek = queue.peek(); //使用频率最小 并且频率最小的之中 最近最久未使用的
                    map.remove((Integer)peek.key);
                    System.out.println(map.size());
                    queue.poll();
                    Node node = new Node(key, value, 1, idx++);
                    map.put(key,node);
                    queue.add(node);
                }else{
                    //添加
                    Node node = new Node(key, value, 1, idx++);
                    map.put(key,node);
                    queue.add(node);
                }
            }


        }
    }

}
