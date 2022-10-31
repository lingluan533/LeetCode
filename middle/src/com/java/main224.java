package com.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/9/25 10:04
 */
public class main224 {
    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));

        //System.out.println(calculate("1-(     -2)"));
    }

    static Map<Character, Integer> map = new HashMap<>();


    public static int calculate(String s) {
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        Stack<Integer> nums = new Stack<>();
        nums.add(0);//避免有-1+2 这种表达式 ，先添加一个数0放入栈中
        Stack<Character> ops = new Stack<>();
        // 将所有的空格去掉
        s = s.replaceAll(" ", "");
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {//数字：入栈
                int j = i;
                int num = 0;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + s.charAt(j) - '0';
                    j++;
                }
                nums.push(num);
                i = j - 1;
            } else if (cur == '(') { // 括号：计算括号内的内容
                ops.push('(');
                continue;
            } else if (cur == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    cal(nums, ops);
                }
                if (ops.peek() == '(') {
                    ops.pop();
                }
            } else {
                if (i > 0 && s.charAt(i - 1) == '(') nums.push(0);
                while (!ops.isEmpty() && ops.peek() != '(' && map.get(cur) <= map.get(ops.peek())) {
                    cal(nums, ops);
                }
                ops.push(cur);
            }
        }
        while (!ops.isEmpty()) {
            cal(nums, ops);
        }
        return nums.pop();
    }

    private static void cal(Stack<Integer> nums, Stack<Character> ops) {
        if (nums.size() == 0 || nums.size() == 1) return;
        int a = nums.pop();
        int b = nums.pop();
        char op = ops.pop();
        switch (op) {
            case '+':
                nums.push(a + b);
                break;
            case '-':
                nums.push(b - a);
                break;
            case '*':
                nums.push(b * a);
                break;
            case '/':
                nums.push(b / a);
                break;
        }
    }
}
