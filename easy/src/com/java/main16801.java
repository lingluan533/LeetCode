package com.java;

/**
 * @author: zms
 * @create: 2022/3/3 11:09
 */
public class main16801 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(702));
    }
    public static String convertToTitle(int columnNumber) {
        //10进制转换为26进制
        StringBuilder stringBuilder = new StringBuilder();
        while(columnNumber!=0){
            columnNumber--;
            int i = columnNumber % 26;
            stringBuilder.append((char)(i+'A'));
            columnNumber /= 26;
        }
        return stringBuilder.reverse().toString();
    }
}
