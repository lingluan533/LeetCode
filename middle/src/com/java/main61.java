package com.java;

import com.java.utils.ListNode;
import com.java.utils.ListNodeUtils;

/**
 * @author: zms
 * @create: 2022/4/6 17:48
 */
public class main61 {
    public static void main(String[] args) {
        ListNodeUtils listNodeUtils = new ListNodeUtils();
//        ListNode listNodeByArray = listNodeUtils.getListNodeByArray(new int[]{1, 2, 3, 4, 5});
//        rotateRight(listNodeByArray,2);
        ListNode listNodeByArray = listNodeUtils.getListNodeByArray(new int[]{1});
        rotateRight(listNodeByArray,1);

    }
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode preHead = new ListNode();
     //   preHead.next = head;
        if(k==0) return head;

        int count = 0;
        ListNode p = preHead.next;
        while (p!=null){
            count++;
            p = p.next;
        }

        k = k % count;
        if(k==0) return preHead.next;
            preHead.next = reverseList(head);
        ListNode fast = preHead;
        ListNode slow = preHead;

        for(int i = 0;i< count -  k  +1  ;i++){
            fast = fast.next;
        }
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        head = preHead.next;
        preHead.next = reverseList(head);

        head.next = reverseList(next);
        return preHead.next;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode preHead = new ListNode();
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != null){
            cur.next = preHead.next;
            preHead.next = cur;
            cur  = next;
            if(next!=null){
                next = next.next;
            }

        }
        return  preHead.next;
    }
}
