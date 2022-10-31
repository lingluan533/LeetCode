package com.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zms
 * @create: 2022/9/21 15:08
 */
public class main554 {
    public static void main(String[] args) {
        List<List<Integer>> ints = Arrays.asList(Arrays.asList(1, 2, 2, 1), Arrays.asList(3, 1, 2), Arrays.asList(1, 3, 2), Arrays.asList(2, 4), Arrays.asList(3, 1, 2), Arrays.asList(1, 3, 1, 1));
        leastBricks(ints);
    }

    public static int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> w : wall) {
            int sum = 0;
            for (int i = 0; i < w.size() - 1; i++) {
                sum += w.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == wall.size()) continue;
            max = Math.max(entry.getValue(), max);
        }
        return wall.size() - max;
    }
}
