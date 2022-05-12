package com.java;

/**
 * @author: zms
 * @create: 2022/3/31 10:29
 */
public class main8301 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(3,null)))));
        deleteDuplicates(listNode);
    }
    public static ListNode deleteDuplicates(ListNode head) {
    ListNode preHead = new ListNode(0);
    preHead.next = head;
    ListNode cur = head;
    ListNode next = cur.next;
        while(cur != null){
            if(next==null) break;
        while(next!=null && next.val == cur.val){
            next = next.next;
        }
        if(next == null){
            cur.next = next;
            break;
        }
        cur.next = next;
        cur =  next;
        next = next.next;

    }
        return preHead.next;
}
}

