package com.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/8/13 0:19
 */
public class main128201 {
    public  List<List<Integer>> groupThePeople(int[] groupSizes) {
        int len = groupSizes.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int  i =0;i<len;i++){
            List<Integer> mapOrDefault = map.getOrDefault(groupSizes[i], new ArrayList<Integer>());
            mapOrDefault.add(i);
            map.put(groupSizes[i],mapOrDefault);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Integer size : map.keySet()){
            List<Integer> list = map.get(size);
            List<Integer> cur = new ArrayList<>();
          for (int i = 0;i<list.size();i++){
              cur.add(list.get(i));
              if(cur.size()==size){
                  res.add(cur);
                  cur = new ArrayList<>();
              }
          }
        }
        return res;
    }
}
