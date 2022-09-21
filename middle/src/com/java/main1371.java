package com.java;

import java.util.HashMap;

/**
 * @author: zms
 * @create: 2022/8/26 23:21
 */
public class main1371 {
    public static void main(String[] args) {
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
    }
    public static int findTheLongestSubstring(String s) {
        HashMap<String,Integer> preMap = new HashMap<>();
        preMap.put("00000",-1);
        String [] preString = new String[s.length()];
        int max = Integer.MIN_VALUE;
        for (int i = 0;i<s.length();i++){
            if (i==0){
                switch (s.charAt(0)){
                    case 'a':
                        preString[0] = "10000";//奇数为1 偶数为0
                        preMap.put(preString[0],0 );
                        break;
                    case 'e':
                        preString[0] ="01000";
                        preMap.put(preString[0],0 );
                        break;
                    case 'i':
                        preString[0] = "00100";
                        preMap.put(preString[0],0 );
                        break;
                    case 'o':
                        preString[0] ="00010";
                        preMap.put(preString[0],0 );
                        break;
                    case 'u':
                        preString[0] = "00001";
                        preMap.put(preString[0],0 );
                        break;
                    default :
                        preString[0] = "00000";
                        break;
                }
                continue;
            }
            switch (s.charAt(i)){
                case 'a':
                    if (preString[i-1].charAt(0)=='1'){
                        preString[i] =new StringBuilder(preString[i-1]).replace(0,1,"0").toString();
                    }else{
                        preString[i] =new StringBuilder(preString[i-1]).replace(0,1,"1").toString();
                    }
                    break;
                case 'e':
                    if (preString[i-1].charAt(1)=='1'){
                        preString[i] =new StringBuilder(preString[i-1]).replace(1,2,"0").toString();
                    }else{
                        preString[i] =new StringBuilder(preString[i-1]).replace(1,2,"1").toString();
                    }
                    break;
                case 'i':
                    if (preString[i-1].charAt(2)=='1'){
                        preString[i] =new StringBuilder(preString[i-1]).replace(2,3,"0").toString();
                    }else{
                        preString[i] =new StringBuilder(preString[i-1]).replace(2,3,"1").toString();
                    }
                    break;
                case 'o':
                    if (preString[i-1].charAt(3)=='1'){
                        preString[i] =new StringBuilder(preString[i-1]).replace(3,4,"0").toString();
                    }else{
                        preString[i] =new StringBuilder(preString[i-1]).replace(3,4,"1").toString();
                    }
                    break;
                case 'u':
                    if (preString[i-1].charAt(4)=='1'){
                        preString[i] =new StringBuilder(preString[i-1]).replace(4,5,"0").toString();
                    }else{
                        preString[i] =new StringBuilder(preString[i-1]).replace(4,5,"1").toString();
                    }
                    break;
                default :
                    preString[i] = preString[i-1];
                    break;
            }
            if (!preMap.containsKey(preString[i])){
                preMap.put(preString[i], i);
            }
            if (preMap.containsKey(preString[i])){
                max = Math.max(max,i- preMap.get(preString[i]));
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}
