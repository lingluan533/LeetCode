package com.java;

import com.java.utils.ListNode;

/**
 * @author: zms
 * @create: 2022/3/31 10:38
 */
public class main8202 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3,new ListNode(3,new ListNode(4,new ListNode(5,null)))))));
        deleteDuplicates(listNode);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode cur = head;
        ListNode next = cur.next;
        while(cur != null){
            if(next == null){
                break;
            }
            boolean flag = false;
            while(next!=null && next.val == cur.val){
                next = next.next;
                flag = true;
            }
           if(flag){
               //有重复 需要跳过所有重复的
               cur = next;
               pre.next = cur;
               if(next!=null)next=next.next;
               else break;
           }else{
               pre = cur;
               cur = cur.next;
               next = next.next;
           }
        }
        return preHead.next;
    }
}
