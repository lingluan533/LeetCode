package com.java;

/**
 * @author: zms
 * @create: 2022/10/30 11:30
 */
public class main20605 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int _val) {
            this.val = _val;
        }

        public ListNode(int _val, ListNode _next) {
            this.val = _val;
            this.next = _next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode preHead = new ListNode(-1);
        ListNode p = head;
        ListNode q = p.next;
        while (p != null) {
            p.next = preHead.next;
            preHead.next = p;
            p = q;
            if (q != null) {
                q = q.next;
            }
        }
        return preHead.next;
    }
}
