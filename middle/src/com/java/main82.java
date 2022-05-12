package com.java;

import com.java.utils.ListNode;

/**
 * @author: zms
 * @create: 2022/3/16 11:57
 */
public class main82 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next==null ) return head;
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        ListNode cur = head;

        while(cur!=null){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if(pre.next!=cur){   //跳過重複的  這個if else保證了不斷鏈 而且執行完之後仍然是 pre.next = cur;
                pre.next = cur.next;
                cur = cur.next;
            }
            else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return preHead.next;
    }
}
