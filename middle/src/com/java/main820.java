package com.java;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author: zms
 * @create: 2022/10/17 15:31
 */
public class main820 {
    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"p", "grah", "qwosp"}));
    }

    public static int minimumLengthEncoding(String[] words) {
        String ts[] = new String[words.length];
        for (int i = 0; i < ts.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(words[i]);
            ts[i] = stringBuilder.reverse().toString();
        }
        Collections.sort(Arrays.asList(ts));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                if (sb.toString().contains(ts[i] + "#")) break;
                sb.append(ts[i] + "#");
                break;
            }
            if (ts[i].startsWith(ts[i + 1]) && !sb.toString().contains(ts[i] + "#")) {
                sb.append(ts[i] + "#");
                i++;
                continue;
            } else if (ts[i + 1].startsWith(ts[i]) && !sb.toString().contains(ts[i + 1] + "#")) {
                sb.append(ts[i + 1] + "#");
                i++;
                continue;
            }
            if (!sb.toString().contains(ts[i] + "#"))
                sb.append(ts[i] + "#");
        }
        return sb.length();

    }
}
