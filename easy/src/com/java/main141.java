package com.java;

/**
 * @author: zms
 * @create: 2022/4/4 14:58
 */
public class main141 {
    public boolean hasCycle(ListNode head) {
        ListNode preHead = new ListNode(1);
        preHead.next = head;
        ListNode slow = preHead;
        ListNode fast = head;
        while(slow != fast && fast!=null){
            slow = slow.next;
            if(fast.next!=null){
                fast = fast.next.next;
            }else{
                return false;
            }
            if(slow == fast) return  true;
        }
        return false;
    }
}
