package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/3/6 10:08
 */
public class main2601 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubStructure (TreeNode A,TreeNode B) {
        if(B==null) return false;
        List<Integer> res =new ArrayList<>();
        acess(A,B, res) ;
        return res.size() > 0 ?true : false;}

        private void acess(TreeNode A,TreeNode B,List<Integer> res) {
            if (res.size() > 0) return;
            if (A == null) return;
            if (A.val == B.val) {
                if (compare(A, B)) {
                    res.add(0);
                    return;
                }
            }
            acess(A.left, B, res);
            acess(A.right, B, res);
        }
            private boolean compare (TreeNode A , TreeNode B){
                if(B==null) return true;
                if (A!= null && B != null &&A.val ==B.val) {
                    return compare(A.left,B.left) && compare (A.right,B.right);}
                return false;
            }

        }
