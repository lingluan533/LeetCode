package com.java;

import com.java.utils.ListNode;

/**
 * @author: zms
 * @create: 2022/4/4 11:01
 */
public class main1901 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode cur = head;
        int count = 0;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        int target = count - n;
        cur = preHead; //指示被删除节点的上一个节点
        while (target > 0){
            target--;
            cur = cur.next;
        }
        ListNode next = cur.next.next; //删除节点的下一个节点 可能为空
        cur.next = next;

        return preHead.next;

    }
}
