package com.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/1/4 11:03
 */
public class test {
    public static void main(String[] args) {
        String a = "_500";
        String b = "500_";
        String[] s = b.split("_");
        System.out.println(s.length);
        System.out.println(s[0]);
        System.out.println(s[1]);
    }
}
