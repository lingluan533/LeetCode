package com.java;

/**
 * @author: zms
 * @create: 2022/3/14 22:59
 */
public class Fanzhuanlianbiao {
     static class ListNode{
         public int val;
         public ListNode next;
         public  ListNode(int val){
             this.val = val;
             this.next = null;
         }
     }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(9);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(8);
        ListNode head4 = new ListNode(3);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        ListNode listNode = fanzhuanLianbiao(head);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
     public static ListNode fanzhuanLianbiao(ListNode head){
            ListNode beforehead = new ListNode(-1);
            beforehead.next = head;
            ListNode beforeOdd = new ListNode(-1);
            ListNode p = head;
            ListNode q = p.next;
            ListNode tail = beforehead;
            int flag = 1;
            //工作指针
            while(p!=null){
                if(flag % 2 == 0){//偶数节点
                    //头插法插入到偶数的链条
                    p.next = beforeOdd.next;
                    beforeOdd.next = p;

                    //更新p q
                    if(q==null){
                        break;
                    }else{
                        p = q;
                        q = q.next;
                    }

                }else{//奇数节点
                    //尾插法插入到奇数的链条
                    p.next = null;
                    tail.next = p;
                    tail = tail.next;
                    //更新p q
                    if(q==null){
                        break;
                    }else{
                        p = q;
                        q = q.next;
                    }
                }
                flag++;
            }
            ListNode res = new ListNode(-1);
            ListNode tailres = res;
         ListNode pODD = beforeOdd.next;
         ListNode qODD = pODD.next;

         ListNode pEVEN = beforehead.next;
         ListNode qEVEN = pEVEN.next;

         while(pODD!=null && pEVEN!=null){
             if(pODD.val <= pEVEN.val){
                 pODD.next = null;
                 tailres.next = pODD;
                 tailres = tailres.next;
            if(qODD!=null){
                pODD = qODD;
                qODD = qODD.next;
            }
             }else{
                 pEVEN.next = null;
                 tailres.next = pEVEN;
                 tailres = tailres.next;
                 if(qEVEN!=null){
                     pEVEN = qEVEN;
                     qEVEN = qEVEN.next;
                 }else{
                     pEVEN = qEVEN;
                 }
             }
         }


         if(pODD!=null){
             tailres.next = pODD;
         }
         if(pEVEN!=null){
             tailres.next = pEVEN;
         }

         return res.next;



     }
}
