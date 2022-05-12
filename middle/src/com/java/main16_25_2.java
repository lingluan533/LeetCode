package com.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zms
 * @create: 2021/12/23 21:33
 */
class LRUCache2 {

    private class LinkedNode {
        private int val;
        private int key;
        private LinkedNode before;
        private LinkedNode next;

        public LinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, LinkedNode> map;

    // 虚拟头尾节点
    LinkedNode head, tail;

    private int capacity;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new LinkedNode(0, 0);
        tail = new LinkedNode(0, 0);

        head.next = tail;
        tail.before = head;
    }

    public int get(int key) {
        int val = -1;
        LinkedNode node = map.get(key);
        if (node != null) {
            val = node.val;

            // 将node从链表先移除，再添加到head后面
            remove(node);
            addBeforeHead(node);
        }
        return val;
    }

    public void put(int key, int value) {
        // 如果map里有这个词
        if (map.containsKey(key)) {
            LinkedNode node = map.get(key);
            node.val = value;

            // 将node从链表先移除，再添加到head后面
            remove(node);
            addBeforeHead(node);
        }
        // 如果map里没有这个词，则先看容量有没有填满
        else {
            // 如果已经没有容量的话
            if (map.size() == capacity) {
                // 先移除最后一个
                LinkedNode last = tail.before;
                map.remove(last.key);
                remove(last);
            }

            // 新增一个新的
            LinkedNode node = new LinkedNode(key, value);
            map.put(key, node);

            // 添加到head后面
            addBeforeHead(node);
        }
    }


    /**
     * 将node节点从链表中移除
     *
     * @param node
     */
    private void remove(LinkedNode node) {
        node.before.next = node.next;
        node.next.before = node.before;
    }

    /**
     * 添加node节点到链表head后面
     *
     * @param node
     */
    private void addBeforeHead(LinkedNode node) {
        LinkedNode next = head.next;

        head.next = node;
        node.before = head;

        node.next = next;
        next.before = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class main16_25_2 {


}
