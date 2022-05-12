package com.java;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: zms
 * @create: 2022/3/22 15:17
 */
public class test01 {
    public static void main(String[] args) {

    }
    class LRUCache {
        private class LinkedNode{
            int key;
            int val;
            LinkedNode pre;
            LinkedNode next;

          public  LinkedNode(int key,int val ){
                this.key = key;
                this.val = val;
            }
        }

        public Map<Integer,LinkedNode> map;
        public int capacity;
        public LinkedNode head;
        public LinkedNode tail;
        public LRUCache(int capacity) {
            this.map = new LinkedHashMap<>();
            this.capacity = capacity;
            this.head = new LinkedNode(1,1);
            this.tail = new LinkedNode(1,1);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                LinkedNode node = map.get(key);
                //先删除
                remove(node);
                //再添加到最前面
                addAfterHead(node);
                return node.val;
            }else{
                return -1;
            }
        }
        public void put(int key, int value) {
                if(map.containsKey(key)){
                    //修改操作
                    LinkedNode node = map.get(key);
                    remove(node);
                    node.val = value;
                    map.put(key,node);
                    addAfterHead(node);
                }else{
                    if(map.size() == capacity){
                        //先删除
                        LinkedNode node1 = tail.pre ;
                        remove(node1);
                        map.remove(node1.key);
                        //再生成新节点 插入前面
                        LinkedNode node = new LinkedNode(key,value);
                        map.put(key,node);
                        addAfterHead(node);

                    }else{
                        //再生成新节点 插入前面
                        LinkedNode node = new LinkedNode(key,value);
                        map.put(key,node);
                        addAfterHead(node);
                    }
                }
        }
        private void addAfterHead(LinkedNode node) {
            node.next = head.next;
            head.next.pre = node;

            head.next = node;
            node.pre = head;
        }

        private void remove(LinkedNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;

        }




    }
}
