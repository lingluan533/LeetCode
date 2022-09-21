package com.zms.java.jd1;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/27 19:21
 */
public class jd1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            in.nextLine();
            String r = in.nextLine();
            String pre = r.substring(0,b);
            String next = r.substring(b);
            System.out.println(pre.toUpperCase() + next.toLowerCase());
        }
    }}



