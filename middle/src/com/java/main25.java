//package com.java;
//
///**
// * @author: zms
// * @create: 2022/3/22 11:39
// */
//public class main25 {
//    public ListNode reverseKGroup(ListNode head, int k) {
//
//        ListNode preHead = new ListNode(0);
//        //K个一组
//        ListNode next = head;
//        ListNode lastTail = preHead;
//        int count = 0;
//        ListNode cur = lastTail;
//        while(cur != null){
//            while(count < k && cur.next != null){
//                count++;
//                cur = cur.next;
//            }
//            if(count < k) break;
//            if(cur  != null ){
//                //将cur 到 next的逆转 并连接到cur的后面
//                ListNode nextFirst  = cur ;
////                ListNode q = p.next;
////                ListNode nextHead = new ListNode();
////                while(p!=null){
////                    p.next = nextHead.next;
////                    nextHead.next = p;
////                    p = q;
////                    if(q != null){        //精髓
////                        q = q.next;
//                    }
//                }}}}
//
////            }else if(next == null){
////
////            }
//        //}
//
//
//   // }
////}
