package com.java;

import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/3/14 11:15
 */
public class main447 {
    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int res = 0;
        for(int i = 0;i<len;i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j  = 0;j<len;j++){
                if(i == j) continue;
                int x = points[i][0] - points[j][0] ;
                int y = points[i][1] - points[j][1];
                int xy = x*x + y*y;
                map.put(xy,map.getOrDefault(xy,0)+1);
            }
            for(Integer key : map.keySet()){
                res += key * (key-1);
            }
        }
        return res;

    }
}
