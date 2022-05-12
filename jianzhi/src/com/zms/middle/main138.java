package com.zms.middle;

/**
 * @author: zms
 * @create: 2022/1/7 22:24
 */
public class main138 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList(Node oldhead) {
        if(oldhead == null) return oldhead;
        Node newhead = new Node(oldhead.val);
        newhead.next = null;
        Node p = newhead;
        Node head = oldhead;
        while(head.next!=null){
            head = head.next;
            Node tem = new Node(head.val);
            tem.next = null;
          //  tem.random = p;
            tem.next = null;
            p.next = tem;
            p = p.next;
        }

        Node pp = newhead;
        Node qq = oldhead;
        while(qq!=null){
            Node currandom = qq.random;
            if(currandom == null){
                pp.random = null;
            }else{
                Node tempoldhead = oldhead;
                Node tempnewhead = newhead;
                int curindex = 0;
                while(tempoldhead != null && tempoldhead != currandom){
                    curindex ++;
                    tempoldhead = tempoldhead.next;
                }
                while(curindex > 0){
                    curindex--;
                    tempnewhead = tempnewhead.next;
                }
                pp.random = tempnewhead;

            }
            pp = pp.next;
            qq = qq.next;
        }


        return newhead;
    }

    public static void main(String[] args) {
        Node n7 = new Node(7);

        Node n13 = new Node(13);
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n1 = new Node(1);
        n7.next = n13;
        n7.random = null;
        n13.next=n11;
        n13.random = n7;
        n11.next=n10;
        n11.random = n1;
        n10.next = n1;
        n10.random = n11;
        n1.next=null;
        n1.random = n7;
        copyRandomList(n7);
    }
}
