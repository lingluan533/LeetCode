package com.zms.middle;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: zms
 * @create: 2022/3/11 11:02
 */
public class main2901 {
    static  class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
    public static void main(String[] args) {
//        Node node = new Node(3);
//      Node node1 = new Node(5);
//        Node node2 = new Node(1);
//        node.next = node1;
//        node1.next = node2;
//        node2.next = node;
//        insert(node,0 );
//        Node node = new Node(1);
//        insert(node,0);




        int a [] = new int[]{41,12,457,10};
        int b [] = new int[] {1,2,3,4,7,8,5};
        System.arraycopy(a,2,b,0,2);
        for(int i =0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        for(int j = 0;j<b.length;j++){
            System.out.print(b[j]+" ");
        }
    }
    public static Node insert(Node head, int insertVal) {
        if(head == null) {
           Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node p = head;
        Node q = head.next;
        boolean flag = false;
        boolean finished = false;
        int count = 0;
        while (p != head || count ==0 ){   //保证只循环一圈
            if(p==head) count++;
            if(insertVal >= p.val  && insertVal<= q.val){  //最正常的逻辑 插入中间 结束
                p.next = new Node(insertVal,q);
                finished = !finished;
                break;
            }else if(q.val < p.val && insertVal >=p.val && insertVal >= q.val){     //如果前面的大于后面的值，说明这是首尾交界分两种情况
                                                                                //如果插入值大于两边的值的话 说明这是链表末尾的元素，应该插在这里
                                                                                //如果插入值小于两边的值的话，说明这是链表的头部元素，也应该插在这里
                                                                                //除此之外的情况都不应插入在这里
                p.next = new Node(insertVal,q);
                finished = !finished;
                break;
            }else if(q.val < p.val && insertVal <= p.val && insertVal<=q.val){
                p.next = new Node(insertVal,q);
                finished = !finished;
                break;
            }
            p = q;
            q=q.next;
        }
        if(!finished){                                              //如果找了一圈都没有找到插入的位置，说明这个链表是全部都相等的元素。随便找个位置插入即可。
            head.next=new Node(insertVal,head.next);
        }
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 120, 30, TimeUnit.SECONDS,
//                new LinkedBlockingDeque<>(), new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                Thread thread = new Thread(r);
//                return thread;
//            }
//        }
//        );


        return head;
    }
}
