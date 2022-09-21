package com.zms.java.jd1;

import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.concurrent.TransferQueue;

/**
 * @author: zms
 * @create: 2022/8/27 19:345
 */
public class jd02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int  []arr = new int [n];
        for (int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        HashMap<Integer,Integer> oddM = new HashMap<>();
        HashMap<Integer,Integer> evenM = new HashMap<>();
        int odd = 0,even = 0;
        for (int i = 0;i<n;i++){
            if (i%2==0){
                oddM.put(arr[i],oddM.getOrDefault(arr[i],0)+1);
                odd ++;
            }else{
                evenM.put(arr[i],evenM.getOrDefault(arr[i],0)+1);
                even++;
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = oddM.entrySet();
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        Set<Map.Entry<Integer, Integer>> entries1 = evenM.entrySet();
        ArrayList<Map.Entry<Integer, Integer>> list1 = new ArrayList<>(entries1);
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        if (list.size()==list1.size() && list.size()==1){
            System.out.print(list.get(0).getKey()==list1.get(0).getKey()? n/2 : 0);
            return;
        }
        if (list.get(0).getKey()!=list1.get(0).getKey()){//最大的不相同
            System.out.print(odd-list.get(0).getValue()+even-list1.get(0).getValue());
        }else{
         int r1 =  odd -  list.get(1).getValue() + even - list1.get(0).getValue();
            int r2 =  odd -  list.get(0).getValue() + even - list1.get(1).getValue();
            System.out.print(Math.min(r1,r2));
        }
    }
}
