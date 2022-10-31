package com.java;

import java.util.*;

/**
 * @author: zms
 * @create: 2022/10/16 21:56
 */
public class main451 {
    public static void main(String[] args) {
        frequencySort("tree");
    }

    public static String frequencySort(String s) {
        char cs[] = s.toCharArray();
        Map<Character, Integer> map = new TreeMap<Character, Integer>();

        for (int i = 0; i < cs.length; i++) {
            map.put(cs[i], map.getOrDefault(cs[i], 0) + 1);
        }
        List<Map.Entry<Character, Integer>> treeMapList =
                new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
        Collections.sort(treeMapList, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < treeMapList.size(); i++) {
            for (int j = 0; j < treeMapList.get(i).getValue(); j++) {
                sb.append(treeMapList.get(i).getKey());
            }
        }
        return sb.toString();

    }
}
