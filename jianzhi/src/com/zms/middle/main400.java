package com.zms.middle;

import org.omg.PortableInterceptor.Interceptor;

/**
 * @author: zms
 * @create: 2022/3/2 11:54
 */
public class main400 {
    public static void main(String[] args) {
        int nthDigit = findNthDigit(2147483647);
        System.out.println(nthDigit);
    }
    public static int findNthDigit(int n) {
        int sum = 0;
        int curlen = 0;
        int num = 1;
        String curnum;
        for(int i = 1;i< Integer.MAX_VALUE;i++){
            if(n > sum + i * 9 * Math.pow(10,i-1) ){
                sum += i * 9 * Math.pow(10,i-1);
            }else{
                curlen = sum;
                num = (int) ( Math.pow(10,i-1));
                break;
            }
        }


        int count = (n - curlen) / (num + "".length());
        if( (n - curlen) % (num + "".length())==0){
            return (num + count -1)+"".charAt(num+"".length()-1)-'0';
        }else{
            curlen += count * num+"".length();

            return num + count+"".charAt((n-curlen)-1)-'0';
        }

//        while(curlen < n){
//            curnum = num+"";
//            if(curlen + curnum.length()<n){
//                curlen += curnum.length();
//                num++;
//                continue;
//            }else{
//                System.out.println(curnum);
//              return curnum.charAt((n-curlen)-1)-'0';
//            }
//
//            }
      //  return 0;
    }
}
