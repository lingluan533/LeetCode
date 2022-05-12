package com.zms.middle;

import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/1/7 22:24
 */
public class main13802{

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList(Node head) {
        if(head == null) return null;

        Node dummy = new Node(-1);
        dummy.next = head;

        while(head != null){
            Node n = new Node(head.val);
            n.next = head.next;
            head.next = n;
            head = n.next;
        }
        head = dummy.next;
        while(head !=null){
            if(head.random!=null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }

        head = dummy.next;
        Node newhead = head.next;
        while(head != null){    //实现了 一个链表拆分为两个！！  写的很妙 这里
            Node tmp = head.next;
            if (head.next != null) head.next = head.next.next;
            head = tmp;
        }


        return newhead;
    }

    public static void main(String[] args) {
        Node n7 = new Node(7);

        Node n13 = new Node(13);
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n1 = new Node(1);
        n7.next = n13;
        n7.random = null;
        n13.next=n11;
        n13.random = n7;
        n11.next=n10;
        n11.random = n1;
        n10.next = n1;
        n10.random = n11;
        n1.next=null;
        n1.random = n7;
        copyRandomList(n7);

    }
}
