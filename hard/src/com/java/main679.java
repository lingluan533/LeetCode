package com.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zms
 * @create: 2022/9/8 19:18
 */
public class main679 {
    public static void main(String[] args) {
        
        System.out.println(judgePoint24(new int[]{4, 1, 8, 7}));
    }

    public static boolean judgePoint24(int[] cards) {

        List<Double> list = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            list.add((double) cards[i]);
        }
        return dfs(list);
    }

    private static boolean dfs(List<Double> list) {
        // 递归出口1:空列表
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 0.001;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                double a = list.get(i);
                double b = list.get(j);
                ArrayList<Double> newList = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) {
                        newList.add(list.get(k));
                    }
                }

                boolean isValid = false;
                //加法
                newList.add(a + b);
                isValid = isValid || dfs(newList);
                newList.remove(newList.size() - 1);
                //减法
                newList.add(a - b);
                isValid = isValid || dfs(newList);
                newList.remove(newList.size() - 1);
                newList.add(b - a);
                isValid = isValid || dfs(newList);
                newList.remove(newList.size() - 1);
                //乘法
                newList.add(a * b);
                isValid = isValid || dfs(newList);
                newList.remove(newList.size() - 1);
                //除法
                if (a / b != 0) {
                    newList.add(a / b);
                    isValid = isValid || dfs(newList);
                    newList.remove(newList.size() - 1);
                }
                if (a / b != 0) {
                    newList.add(b / a);
                    isValid = isValid || dfs(newList);
                    newList.remove(newList.size() - 1);
                }
                if (isValid) return true;
            }
        }
        return false;
    }
}
