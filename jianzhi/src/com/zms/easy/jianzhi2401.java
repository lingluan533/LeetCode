package com.zms.easy;

/**
 * @author: zms
 * @create: 2022/1/7 21:02
 */
public class jianzhi2401 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null ) return head;
            ListNode newhead = reverseList(head.next);
            head.next.next = head;
        head.next = null;
        return newhead;

    }
}
