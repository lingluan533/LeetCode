package com.java.week283;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zms
 * @create: 2022/3/6 11:28
 */
public class main03 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      } }

    public TreeNode createBinaryTree(int[][] descriptions) {
            Map<Integer,TreeNode[]> map = new HashMap<>();
            for(int i =0;i<descriptions.length;i++){
                int father = descriptions[i][0];
                int child = descriptions[i][1];
                int leftright = descriptions[i][2];
                //获取父亲节点 若没有则新建一个
                TreeNode fatherNode = null;
                if(map.get(father)==null){
                    fatherNode = new TreeNode(father);
                    map.put(father,new TreeNode[]{fatherNode,null});
                }else fatherNode =  map.get(father)[0];
                    //获取子节点 若没有则新建一个
                    TreeNode childNode = null;
                    if(map.get(child)==null){
                        childNode = new TreeNode(child);
                        map.put(child,new TreeNode[]{childNode,null});
                    }else childNode = map.get(child)[0];
                    if(leftright==1){//是左节点
                        fatherNode.left = childNode;
                        map.get(child)[1] = fatherNode;
                    }else{
                        fatherNode.right = childNode;
                        map.get(child)[1] = fatherNode;
                    }

            }
        Collection<TreeNode[]> values = map.values();
        for(TreeNode[] value : values){
            if(value[1] == null)return value[0];
        }
        return null;
    }
}
