package com.java;

/**
 * @author: zms
 * @create: 2022/8/9 21:35
 */
public class main20602 {
    public ListNode reverseList(ListNode head) {
        ListNode preHead = new ListNode(-1,null);
        if (head==null) return head;
        ListNode pre = head,next = head.next;
        while (next!=null){
            pre.next = preHead.next;
            preHead.next = pre;
            pre = next;
            next = next.next;
        }
        pre.next = preHead.next;
        preHead.next = pre;
        return preHead.next;

    }
}
