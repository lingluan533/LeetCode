package com.zms.java.jd1;

import java.util.*;

public class main02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Map<Long, Integer> map1 = new HashMap<>();
        for (int i = 0; i < n; i += 2) {
            map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Long, Integer>> list1 = new ArrayList<>(map1.entrySet());
        list1.sort((o1, o2) -> (o2.getValue() - o1.getValue()));
        Long maxKey1 = list1.get(0).getKey();
        int maxValue1 = list1.get(0).getValue();
        Map<Long, Integer> map2 = new HashMap<>();
        for (int i = 1; i < n; i += 2) {
            map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Long, Integer>> list2 = new ArrayList<>(map2.entrySet());
        list2.sort((o1, o2) -> (o2.getValue() - o1.getValue()));
        Long maxKey2 = list2.get(0).getKey();
        int maxValue2 = list2.get(0).getValue();
        if (!Objects.equals(maxKey1, maxKey2)) {
            if (n % 2 == 0) {
                System.out.println(((n / 2) - maxValue1) + ((n / 2) - maxValue2));
            } else {
                System.out.println(((n / 2) + 1 - maxValue1) + ((n / 2) - maxValue2));
            }
        } else {
            int nums1 = list1.get(1).getValue();
            int nums2 = list2.get(1).getValue();
            if (nums1 > nums2) {
                if (n % 2 == 0) {
                    System.out.println(((n / 2) - nums1) + ((n / 2) - maxValue2));
                } else {
                    System.out.println(((n / 2) + 1 - nums1) + ((n / 2) - maxValue2));
                }
            } else {
                if (n % 2 == 0) {
                    System.out.println(((n / 2) - maxValue1) + ((n / 2) - nums2));
                } else {
                    System.out.println(((n / 2) + 1 - maxValue1) + ((n / 2) - nums2));
                }
            }
        }
    }
}
