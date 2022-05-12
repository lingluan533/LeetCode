package com.java;

import com.java.utils.ListNode;

/**
 * @author: zms
 * @create: 2022/4/4 15:15
 */
public class main9202 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode cur = preHead,pre=preHead;
        int count = 0;
        ListNode start = null;
        while(count < left ){
            count ++;
            pre = cur;
            cur = cur.next;
        }
        start = cur;
        while(count<right){
            count++;
            cur = cur.next;
        }
       ListNode next =  cur.next ;
        cur.next = null;
        pre.next = reverse(start);
        start.next = next;
        return preHead.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode preHead = new ListNode();
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur!=null){
            cur.next = preHead.next;
            preHead.next = cur;
            cur = next;
            if(next!=null) next = next.next;
        }
        return preHead.next;
    }
}
