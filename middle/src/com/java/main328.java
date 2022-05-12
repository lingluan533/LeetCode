package com.java;

import com.java.utils.ListNode;

/**
 * @author: zms
 * @create: 2022/3/10 22:35
 */
// class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
public class main328 {
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode oddP = odd;
        ListNode evenP = even;
                ListNode p = head;
        ListNode q = p.next;
        boolean flag = false;
        while(p!=null){
            if(!flag){
                p.next = null;
                evenP.next = p;
                evenP = evenP.next;
                if(q == null) break;
                p = q;
                q=q.next;
                flag = !flag;
            }else{
                p.next = null;
                oddP.next = p;
                oddP = oddP.next;
                if(q == null) break;
                p = q;
                q=q.next;
                flag = !flag;
            }

        }
        evenP.next = odd.next;
        return even.next;
        }






}
