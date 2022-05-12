package com.zms.middle;

import jdk.internal.org.objectweb.asm.Handle;

/**
 * @author: zms
 * @create: 2022/3/11 10:25
 */

public class main029 {
    static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    public static void main(String[] args) {
        Node node = new Node(3);
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node;
        insert(node,0 );
    }
    public static Node insert(Node head, int insertVal) {
        if(head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node p = head;
        Node q = head.next;
        boolean flag = true;
        boolean finished = false;
        while(true){
            if(p == head){
                if(flag){
                    flag = false;
                }else{

                    break;
                }

            }
            if(insertVal >= p.val && insertVal <= q.val || insertVal >= p.val && insertVal >= q.val && q.val <= p.val || insertVal <= p.val && insertVal <= q.val && q.val <= p.val && flag  ){
                p.next = new Node(insertVal,q);
                finished = !finished;
                break;
            } //插入pq之间
            else {
                p = q;
                q=q.next;
            }

        }
        if(!flag && !finished){
            head.next = new Node(insertVal,head.next);
        }

        return head;
    }
}
