package com.java;

import javax.xml.stream.events.Characters;

/**
 * @author: zms
 * @create: 2022/1/12 20:33
 */
public class main39401 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
    public static String decodeString(String s) {


        return getString(s);

    }

    private static String getString(String s) {
        if(onlyString(s)){          //判断是否纯字母串，这也是递归的出口
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                sb.append(s.charAt(i));
            }else if (Character.isDigit(s.charAt(i))){  //如果是数字的话 说明找到了下一个递归的子串
                                                        //结构一定是12[子串]
                                                        //所以递推公式为 getString(s) = "abc"+ 12 * getString(s1) + 3 * getString(s2)+....
                int start = i;
                while(Character.isDigit(s.charAt(i))){
                    i++;
                }
                int count = Integer.parseInt(s.substring(start,i));
                int lcount = 0;
                int end = 0;
                for(int j = i ;j<s.length();j++){
                    if(s.charAt(j) == '[')lcount++;
                    else if(s.charAt(j) == ']'){
                        if(lcount==1){
                            end = j;
                            break;
                        }else{
                            lcount--;
                        }
                    }
                }
                String next = s.substring(i+1,end);
                i = end;
                String nextres = getString(next);   //递归[ ] 内的子串
                StringBuilder stringBuilder   = new StringBuilder();
                for(int j = 0;j<count;j++){
                    stringBuilder.append(nextres);
                }
                sb.append(stringBuilder.toString());

            }
        }
        return sb.toString();

    }

    private static boolean onlyString(String s) {
        for(int i =0;i<s.length();i++){
            if(!Character.isLetter(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
