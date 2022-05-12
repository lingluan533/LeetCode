package com.zms.java.huawei;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/23 20:23
 */
public class main03 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int n = scan.nextInt();
        int nextstart = 0;
        for(int i = 0;i<n;i++){
            int target = scan.nextInt();
            String tags = s.substring(nextstart,nextstart+2);
            int tag = to10(tags);
            if(tag == target){ //tag匹配成功
                String lens = s.substring(nextstart + 2,nextstart+4);
                int len = to10(lens);
                if(nextstart + 2 + 2 + 2*len >= s.length()){
                    return;
                }
                System.out.println(len+" "+nextstart/2+2);
                nextstart = nextstart + 2 + 2 + 2*len;
            }else{
                //匹配失败
                System.out.println(0+" "+0);
               continue;
            }
        }
    }
    private static int to10(String tags) {
        char a = tags.charAt(0);
        char b = tags.charAt(1);
        int res = 0;
        if(Character.isUpperCase(b)){
            res += b -'A' + 10;
        }else res += b-'0';
        if(Character.isUpperCase(a)){
            res += (a-'A'+10 )*16;
        }else{
            res += (a-'0')*16;
        }
        return res;
    }
}
