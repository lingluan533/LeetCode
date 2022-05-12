package com.zms.java.mircsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: zms
 * @create: 2022/1/23 15:56
 */
public class main01 {
    public static void main(String[] args) {
solution("babaa");
    }
    public static int solution(String S) {
      if(S.length() == 1) return 0;
      int len = S.length();
      int count = 1;
      int cur = S.charAt(0);
      int last = 0;
      int maxlen = 0;
      char cs [] = S.toCharArray();
        Set<Integer> set = new HashSet<>();
        int duanshu = 0;
        int i ;
      for( i=1;i<len;i++){
            if(cs[i] == cur){
                count++;
                continue;

            }else{
                duanshu++;
                cur = cs[i];
                count = 1;
                set.add(i-last);
                maxlen = Math.max(maxlen,i-last);
                last = i;

            }
      }
      duanshu+=1;
      set.add(i-last);
      maxlen = Math.max(maxlen,i-last);
      if(set.size()==1){
            return 0;
      }else{
          return maxlen*duanshu - S.length();
      }

    }
}
