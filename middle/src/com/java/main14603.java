package com.java;

import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/10/30 19:32
 */
public class main14603 {
    private class LRUCache {
        private class LinkedNode {
            int key;
            int val;
            LinkedNode pre;
            LinkedNode next;

            public LinkedNode() {

            }

            public LinkedNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        public int capacity;
        public HashMap<Integer, LinkedNode> map;
        public LinkedNode head;
        public LinkedNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<Integer, LinkedNode>();

            this.head = new LinkedNode(1, 1);
            this.tail = new LinkedNode(1, 1);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                //刷新到队头
                LinkedNode linkedNode = map.get(key);
                deleteNode(linkedNode);
                addAfterHead(linkedNode);
                return linkedNode.val;
            } else return -1;
        }


        public void put(int key, int value) {
            //先看是否修改操作
            if (map.containsKey(key)) {
                LinkedNode old = map.get(key);
                deleteNode(old);
                old.val = value;
                map.put(key, old);
                addAfterHead(old);

            } else {
                //再看是否超出了容量大小
                if (map.size() == capacity) {
                    //先淘汰
                    LinkedNode linkedNode = tail.pre;
                    deleteNode(linkedNode);
                    map.remove(linkedNode.val);
                    //在添加
                    LinkedNode newNode = new LinkedNode(key, value);
                    map.put(key, newNode);
                    addAfterHead(newNode);

                } else {
                    //添加
                    LinkedNode newNode = new LinkedNode(key, value);
                    map.put(key, newNode);
                    addAfterHead(newNode);

                }
            }

        }

        private void addAfterHead(LinkedNode linkedNode) {
            linkedNode.next = head.next;
            head.next.pre = linkedNode;
            head.next = linkedNode;
            linkedNode.pre = head;


        }

        private void deleteNode(LinkedNode linkedNode) {
            linkedNode.pre.next = linkedNode.next;
            linkedNode.next.pre = linkedNode.pre;
        }
    }

}

