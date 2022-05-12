package com.java;

/**
 * @author: zms
 * @create: 2021/12/28 16:57
 */
public class main20601 {
    private   class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode listNode = reverseList(head.next);
            head.next.next = head;
        head.next = null;

        return listNode;
    }

}
