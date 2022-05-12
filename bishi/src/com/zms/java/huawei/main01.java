package com.zms.java.huawei;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/3/23 19:02
 */
public class main01 {
    public static void main(String[] args) {


    }
    public int  getMin(int nums[]){

        int dp[] = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE-10);
        for(int i = 0;i<dp.length;i++){
            int cur = nums[i];
            for(int j = i +  1; j< i + cur;j++){
                dp[j] = Math.min(dp[j], dp[i]+1);
            }
        }

        return  0;
    }
//        while(!next.isEmpty()){
//            count ++;
//           // ArrayList<Integer> temp = new ArrayList<>();
//            //temp.addAll(next);
//            next.clear();
//            for(int i = 0;i<temp.size();i++){ //遍历每一个下个点
//                int cur = temp.get(i);
//                if(cur >= nums.length) continue;
//                for(int j = 1;j<=nums[cur];j++){
//                    int tem = cur + j;
//                    if(!temp.contains(tem) ){
//                        next.add(tem);
//                        if(tem == n){
//
//                            System.out.print(++count);
//                            return ;
//                        }
//
//                    }
//                }
//            }
//        }
        /*
        * 5
2 0 1 0 3
2
        * */

}
