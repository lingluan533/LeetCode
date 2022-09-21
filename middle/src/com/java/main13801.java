package com.java;

/**
 * @author: zms
 * @create: 2022/9/2 16:25
 */
public class main13801 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node cur = head;
        while (cur != null) {
            Node t = new Node(cur.val);
            t.next = cur.next;
            cur.next = t;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        Node preHead = new Node(-1);
        Node curNew = preHead;
        cur = head;
        while (cur != null) {
            Node t = cur.next.next;
            cur.next.next = null;
            curNew.next = cur.next;
            curNew = curNew.next;
            cur.next = t;
            cur = cur.next;
        }
        return preHead.next;

    }
}
