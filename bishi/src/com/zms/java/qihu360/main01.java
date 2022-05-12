package com.zms.java.qihu360;

import java.util.Scanner;

/**
 * @author: zms
 * @create: 2022/3/19 15:33
 */
public class main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String tar = "";
        while(scan.hasNext()){
            tar = scan.nextLine();
            if(check(tar)){
                System.out.println("Ok");
            }else{
                System.out.println("Irregular password");
            }
        }
    }

    private static boolean check(String tar) {
        //长度
        if(tar==null || tar.length() < 8){
            return false;
        }
        boolean upper = false,lower= false,special= false,num= false;
        for(int i = 0;i<tar.length();i++){
            if(Character.isDigit(tar.charAt(i))){
                num = true;
                continue;
            }
            if(Character.isUpperCase(tar.charAt(i))){
                upper = true;
                continue;
            }
            if(Character.isLowerCase(tar.charAt(i))){
                lower = true;
                continue;
            }
            special = true;
        }
        return upper && lower && special && num;

    }
}
