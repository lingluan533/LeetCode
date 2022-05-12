package com.java;








import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zms
 * @create: 2022/3/20 10:25
 */
public class main297 {
   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root.left = root2;
        root.right = root3;
        root3.left = root4;
        root3.right = root5;
        String serialize = serialize(root);
        TreeNode deserialize = deserialize(serialize);
    }


    // Encodes a tree to a single string.
//    public static String serialize(TreeNode root) {
//        String NULL = "#";
//        String SEP = ",";
//        //层序遍历BFS的模板
//        Queue<TreeNode> queue = new LinkedList();
//        queue.add(root);
//        StringBuilder builder = new StringBuilder();
//        while(!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if(node == null) {
//                builder.append(NULL).append(SEP);
//                continue;
//            }
//            builder.append(node.val).append(SEP);
//            queue.add(node.left);
//            queue.add(node.right);
//        }
//        return builder.toString();
//    }


    // Encodes a tree to a single mstring.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("null");
            return sb.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll == null){
                sb.append("null,");
                continue;
            }else{
                sb.append(poll.val).append(",");
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return sb.substring(0,sb.toString().length() - 1 );
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] split = data.split(",");
        if(split[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for(int i = 1;i<split.length;i++){
            TreeNode poll = queue.poll();
            String leftval = split[i++];
            String rightval = split[i];
            if(!leftval.equals("null")){
                poll.left = new TreeNode(Integer.parseInt(leftval));
                queue.add(poll.left);
            }
            if(!rightval.equals( "null")){
                poll.right = new TreeNode(Integer.parseInt(rightval));
                queue.add(poll.right);
            }

        }
        return root;
    }
}
