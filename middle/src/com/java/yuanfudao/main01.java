package com.java.yuanfudao;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/8/26 19:23
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int  T = scan.nextInt();
        for (int i = 0;i<T;i++){
            int a = scan.nextInt();
            String words[] = new String[a];
            for (int j=0;j<a;j++){
                 words[j] = scan.next().toLowerCase();
            }
            int b = scan.nextInt();
            String stops [] = new String[b];
            for (int j=0;j<b;j++){
                stops[j] = scan.next().toLowerCase();
            }
            int max = 0;
            HashMap<String,Integer> map = new HashMap<>();
            for (int j=0;j<a;j++){
                if (!isBaned(words[j],stops)){
                    map.put(words[j],map.getOrDefault(words[j],0)+1 );
                 max = Math.max( map.getOrDefault(words[j],0),max);
                }
            }
            System.out.println(max);





        }
    }

    private static boolean isBaned(String word, String[] stops) {
        for (String s : stops) {
            if (word.length() != s.length()) {
                continue;
            }
            String stop = s;
            for (int j = 0; j < stop.length(); j++) {
                if (stop.charAt(j) == '?') continue;
                if (stop.charAt(j) != word.charAt(j)) return false;
            }
            return true;
        }
        return false;

    }

}
