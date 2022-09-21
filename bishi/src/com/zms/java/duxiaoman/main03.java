package com.zms.java.duxiaoman;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/31 19:22
 */
public class main03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        HashMap<Integer,int[]> check = new HashMap<>();
        for (int i = 0;i<m;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            int c = scan.nextInt();
            check.put(x,new int[]{y,c});
        }
        try {
            dfs(check,0,new StringBuilder(),n);
        } catch (Exception e) {
            System.out.println(count);
        }

    }
    static  int count = 0;
    private static void dfs(HashMap<Integer,int[]> check, int start, StringBuilder stringBuilder,int len) throws Exception {
        if (start==len){
            throw new Exception();
        }
        stringBuilder.append("1");
        count++;
        if (checkPass(stringBuilder,check)){
            dfs(check,stringBuilder.length(),stringBuilder,len);
        }else {
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            count--;
            stringBuilder.append("0");
            dfs(check,stringBuilder.length(),stringBuilder,len);
        }

    }

    private static boolean checkPass(StringBuilder stringBuilder,HashMap<Integer,int[]> check) {
        int len = stringBuilder.length();
        for (Map.Entry<Integer,int[]> en :check.entrySet()){
                int x = en.getKey();
                int y = en.getValue()[0];
                int count = en.getValue()[1];
                if (len>= x && len <=y){
                    int count1 = 0;
                    for (int i = x-1;i<len;i++){
                        if (stringBuilder.charAt(i)=='1') count1++;
                        if (count1 > count) return false;
                    }
                }
        }
        return true;


    }


}
