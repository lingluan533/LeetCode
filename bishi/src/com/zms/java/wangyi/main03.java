package com.zms.java.wangyi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: zms
 * @create: 2022/3/27 15:35
 */
public class main03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();
        int num[] = new int[n+1];



        for(int j = 1;j<=n;j++){
            Stack<Integer> stackodd = new Stack<>();
            Stack<Integer> stackeven = new Stack<>();
            for(int i = n;i>=1;i--){
                if (i%2==0) stackeven.push(i);
                else stackodd.push(i);
            }
            num[1] = j;
            for(int i = 1;i<=n/2;i++){
                int left = 2 * i;
                int right = 2 * i + 1;
                if(num[i] % 2 == 0){
                    if(left<=n && !stackodd.isEmpty()){
                        if(stackodd.peek()==num[1]){
                            stackodd.pop();
                        }
                        num[left] = stackodd.size() == 0? stackeven.pop() : stackodd.pop();
                    }
                    if(right<=n &&!stackodd.isEmpty()){
                        if(stackodd.peek()==num[1]){
                            stackodd.pop();
                        }
                        num[right] = stackodd.size()==0? stackeven.pop(): stackodd.pop();
                    }

                }else{
                    if(left<=n && !stackeven.isEmpty()){
                        if(stackeven.peek()==num[1]){
                            stackeven.pop();
                        }

                        num[left] = stackeven.size()==0? stackodd.pop() : stackeven.pop() ;
                    }

                    if(right<=n && !stackeven.isEmpty()){
                        if(stackeven.peek()==num[1]){
                            stackeven.pop();
                        }
                        num[right] = stackeven.size()==0? stackodd.pop(): stackeven.pop();
                    }

                }

            }
            if (num[n]!=0){
                for(int i = 1;i<=n;i++){
                    if (i==n)
                        System.out.println(num[i]);
                    else System.out.print(num[i]+" ");
                }
                return;
            }

        }
//        num[1] = 2;
//        stackeven.pop();




    }
}
