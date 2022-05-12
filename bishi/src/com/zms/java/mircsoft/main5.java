package com.zms.java.mircsoft;

/**
 * @author: zms
 * @create: 2022/3/13 9:34
 */
public class main5 {
    public static void main(String[] args) {
        int a[] = new int[]{41,52,4,11,23,65,2};
        int len  = a.length;
        for(int i = 0;i<len;i++){
            for(int j = 0;j<len-i-1;j++){
                if(a[j] < a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }


        }
        for(Integer  i: a){
            System.out.print(i+" ");
        }
    }
}
