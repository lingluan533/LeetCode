package com.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: zms
 * @create: 2021/12/29 16:52
 */
public class main1995 {
    public static int countQuadruplets(int[] nums) {
        int len = nums.length;
        if(len==4) return nums[0] + nums[1] + nums[2] == nums[3] ? 1:0;
        int i=0,j=1,k=2;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for  ( int t = 0;t<len;t++){
            if(map.containsKey(nums[t])){
                map.get(nums[t]).add(t);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(t);
                map.put(nums[t],list);
            }
        }
        int ans = 0;
    int temp;
        for (i=0;i<j;i++){
            for (j=i+1;j<k;j++){
                for(k=j+1;k<len;k++){
                  temp =   nums[i] + nums[j] + nums[k];
                  if (map.containsKey(temp)){
                      for(int l = 0;l<map.get(temp).size();l++){
                          if(map.get(temp).get(l) > k){
                              ans++;
                          }
                      }
                  }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        countQuadruplets(new int[]{1,1,1,3,5});
    }
}
