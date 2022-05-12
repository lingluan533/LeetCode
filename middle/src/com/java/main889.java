package com.java;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: zms
 * @create: 2022/4/5 16:32
 */
public class main889 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            if(preorder==null || postorder == null || preorder.length ==0 || postorder.length == 0){
                return null;
            }
            int lenpre = preorder.length;
            int lenpost = postorder.length;
            TreeNode root = new TreeNode(preorder[0]);
        ArrayList<Integer> list = new ArrayList<>();
        int leftindex = 0;
            for(int i =1;i<lenpre;i++){
                list.add(preorder[i]);
                boolean flag = true;
                for(int j = 0;j<i;j++){
                    if(!list.contains(postorder[j])){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    leftindex = i;
                }
            }
            root.left = constructFromPrePost(Arrays.copyOfRange(preorder,1,leftindex+1),Arrays.copyOfRange(postorder,0,leftindex));
            root.right = constructFromPrePost(Arrays.copyOfRange(preorder,leftindex+1,lenpre),Arrays.copyOfRange(postorder,leftindex,lenpost-1));
            return root;

    }
}
