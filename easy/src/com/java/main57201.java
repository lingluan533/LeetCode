package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/3/6 9:30
 */
public class main57201 {
     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {

    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null) return false;
            //boolean flag = false;  由于基本数据类型是值传递 所以如果将这个值传递给函数，不能在此得到函数对他的改变
        List<Integer> li =new ArrayList<>();
            dfs(A,B,li);

            return li.size() > 0;
        }



    private void dfs(TreeNode a, TreeNode b,  List<Integer> li) {
        if(li.size()>0) return;
         if(a==null) return ;
         if(a.val == b.val){
             if(isSameTree(a,b)){
                 li.add(0);
                 return ;
             }

         }
        dfs(a.left,b,li);
        dfs(a.right,b,li);



    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        if(b==null) return true;

         if(a!=null && b!=null && a.val == b.val )
         return isSameTree(a.left,b.left) && isSameTree(a.right,b.right);
         else return false;
    }
}
