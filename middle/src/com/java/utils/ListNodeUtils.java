package com.java.utils;


import com.java.main148;

public class ListNodeUtils {

    public ListNode getListNodeByArray(int a[]){
        ListNode preHead = new ListNode(0);
        ListNode cur=preHead;
        for(int i = 0 ;i<a.length;i++){
            ListNode node = new ListNode(a[i]);
            cur.next = node;
            cur = cur.next;
        }
        return preHead.next;
    }

}
