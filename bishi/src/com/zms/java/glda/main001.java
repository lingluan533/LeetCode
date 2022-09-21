package com.zms.java.glda;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/8/31 21:02
 */
public class main001 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        HashMap<Integer,HashSet<Integer>>  node = new HashMap<>();
        int ary[] = new int[T];
        for (int i = 0;i<T;i++){
           ary[i] = scan.nextInt();
        }

        int ary1[] = new int[T];
        for (int i = 0;i<T;i++){
            ary1[i] = scan.nextInt();
        }
        for (int i=0;i<T;i++){
            node.put(ary[i],new HashSet<>());
            for (int j = i-1;j>=0;j--){
                node.get(ary[i]).add(ary[j]);
            }
        }

        HashSet<Integer> unNormal = new HashSet<>();
        for (int j=1;j<T;j++){
            for (int k=0;k<=j-1;k++){
                if (unNormal.contains(ary1[k])) continue;
                if (!node.get(ary1[j]).contains(ary1[k])) unNormal.add(ary1[k]);
            }
        }
        System.out.println(unNormal.size());

    }
}
