package com.java;

import javax.jnlp.ClipboardService;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/8/13 16:10
 */
public class main876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.next;
    }
}
