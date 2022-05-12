package com.java;

import com.java.utils.ListNode;

/**
 * @author: zms
 * @create: 2022/4/4 11:12
 */
public class main1902 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode fast = preHead;
        ListNode slow = preHead;
        while(n>0){
            n--;
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return preHead.next;
    }
}
