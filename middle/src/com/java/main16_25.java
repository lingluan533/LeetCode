package com.java;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: zms
 * @create: 2021/12/23 19:28
 */
class Node{
    Node next;
    int val;

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", val=" + val +
                '}';
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node( int val) {
        this.val = val;
    }

}
class LRUCache {
    HashMap<Integer,Integer> map = null;
    int capactity;
    Node head = null;
    public LRUCache(int capacity) {
        head =  new Node();
        head.next = null;
        this.capactity  = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        int res =  map.getOrDefault(key,-1) ;
        if (res == -1){
            return -1;
        }else{
            //执行排序操作 移动到最前面
            Node p = head;
            Node q = p;
            p = p.next;
            while(p!=null){
                if(p.val == key){
                    q.next = p.next;
                    p.next = head.next;
                    head.next = p;
                    break;
                }else{
                   q = p;
                   p = p.next;
                }
            }
            return res;
        }
    }

    public void put(int key, int value) {//put 也会使保持为最新的排序
        if(map.get(key) == null){
            if(map.size()<capactity){
                map.put(key,value);
                Node p,q=head;
                p = head.next;
                while(p!=null){
                    q = p;
                    p = p.next;
                }
                q.next = new Node(key);
                get(key);
        }else{
            //执行删除
                map.put(key,value);
                Node p = head;
                Node q = p;
                p = head.next;
                while(p.next!=null){
                    q = p;
                    p = p.next;
                }
                map.remove(p.val);
                p = null;
                q.next = null;

                //插入新的
                Node p1,q1=head;
                p1 = head.next;
                while(p1!=null){
                    q1 = p1;
                    p1 = p1.next;
                }
                q1.next = new Node(key);
                get(key);


            }
        }else{
            //重复的key为修改
            map.put(key,value);
            get(key);
        }
    }
}
public class main16_25 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 );

        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(1, 1);    // 该操作会使得密钥 2 作废
       // System.out.println(cache.get(2));
        cache.put(4, 1);    // 该操作会使得密钥 1 作废
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
        System.out.println(cache.get(2));


    }

}

