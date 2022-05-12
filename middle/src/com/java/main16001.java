package com.java;

import com.java.utils.ListNode;

import java.lang.ref.SoftReference;

/**
 * @author: zms
 * @create: 2022/3/18 20:57
 */
public class main16001 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode rootA = headA,rootB = headB;
        if(rootA == rootB ) return  rootA;
        int lena = 0;
        int lenb = 0;
        //SoftReference softReference = new SoftReference();

        while(rootA !=null && rootB != null){
            lena++;
            lenb++;
            rootA = rootA.next;
            rootB = rootB.next;
        }
        while(rootA!=null){
            lena++;
            rootA = rootA.next;
        }
        while(rootB!=null){
            lenb++;
            rootB = rootB.next;
        }
        rootA = headA;
        rootB = headB;
        if(lena > lenb){
            while(lena > lenb){
                rootA = rootA.next;
                lena--;
            }
        }else if(lena < lenb){
            while(lenb > lena) {
                rootB = rootB.next;
                lenb--;
            }
        }

        while(rootA!=null){
            if(rootA == rootB) return rootA;
            rootA = rootA.next;
            rootB = rootB.next;
        }
        return  null;


    }
}
