package com.zms.easy;

/**
 * @author: zms
 * @create: 2022/1/7 21:02
 */
public class jianzhi24 {
    public class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null ) return head;
        // 1.采用头插法插入一个新的链表 返回head.next
        ListNode p,q;
        ListNode newhead = new ListNode(0);
        p = head;
        q = head.next;
        while (p != null  ){
            p.next = newhead.next;
            newhead.next = p;
            p = q;
            if(q==null) break;
            q = q.next;

        }
        return newhead.next;

    }
}
