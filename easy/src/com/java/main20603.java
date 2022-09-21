package com.java;

/**
 * @author: zms
 * @create: 2022/8/9 21:54
 */
public class main20603 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)return head;
        ListNode preHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return preHead;
    }
}
