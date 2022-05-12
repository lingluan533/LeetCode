package com.zms.java.pdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/20 18:52
 */
public class main03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        String s1 = scan.next();
        char ans[] = new char[s1.length()];
        Arrays.fill(ans,' ');
        for(int i =0;i< s1.length();i++){
            if(s1.charAt(i) == 0){
                if(i>=k){
                    ans[i-k] = '0';
                }
                if(i+k < s1.length()){
                    ans[i+k] = '0';
                }
            }
            if(s1.charAt(i)=='1'){
                if(i+k<s1.length()){
                    ans[i+k] = '1';
                }else if(i>=k){
                    ans[i-k] = '1';
                }
            }
        }

        for(int i = 0;i<s1.length();i++){
            if(ans[i] ==' '){
                ans[i] = '0';}
        }
        System.out.println(ans);
    }
}
