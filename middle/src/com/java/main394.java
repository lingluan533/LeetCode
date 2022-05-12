package com.java;

import javax.xml.stream.events.Characters;
import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/1/12 18:58
 */
public class main394 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    public static String decodeString(String s) {
        Stack<String> sstack = new Stack<>();
        Stack<Integer> countstatck = new Stack();
        StringBuilder sb = new StringBuilder();
        StringBuilder temsb ;
        String tem ;
        int temcount;
        for(int i =0;i<s.length();){
            //栈为空的时候
            //若是字母则拼接
            //若是数字，则找到整个数据的大小，入栈count
            if(countstatck.isEmpty()){
                if(Character.isLetter(s.charAt(i))){
                    sb.append(s.charAt(i));
                    i++;
                    continue;
                }else{
                    int start = i;
                    while(Character.isDigit(s.charAt(i++)));
                    i--;
                     temcount = Integer.parseInt(s.substring(start,i));
                    countstatck.push(temcount);
                    continue;
                }

            }

            //栈不空的时候
            //若是[则入栈后面的字母
            //若是数字，则找到整个数据的大小，入栈count
            //若是]则执行一次sstack、countsatack出栈，拼接，如果count栈为空了，则拼接到最终结果上，否则需要出栈顶，拼接，再入栈
          else{
                if(s.charAt(i)=='['){
                    int start = i+1;

                    while(Character.isLetter(s.charAt(++i)));
                     tem = s.substring(start,i);
                    sstack.push(tem);
                    continue;
                }else if(Character.isDigit(s.charAt(i))){
                    int start = i;
                    while(Character.isDigit(s.charAt(i++)));
                    i--;
                     temcount = Integer.parseInt(s.substring(start,i));
                    countstatck.push(temcount);
                    continue;
                }else if(s.charAt(i)==']'){
                    i++;
                     tem = sstack.pop();
                    temsb = new StringBuilder();

                    int count = countstatck.pop();
                    while(count>0){
                        temsb.append(tem);
                        count--;
                    }
                    tem= temsb.toString();
                    if(countstatck.isEmpty()){
                        sb.append(tem);
                    }else{
                        sstack.push(sstack.pop()+tem);
                    }
                    continue;
                }else{
                    int start = i;

                    while(Character.isLetter(s.charAt(++i)));
                    tem = s.substring(start,i);
                    sstack.push(sstack.pop()+tem);
                    continue;
                }

            }

        }
    return sb.toString();
    }
}
