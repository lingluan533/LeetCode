package com.java;

/**
 * @author: zms
 * @create: 2021/12/28 20:16
 */
abstract class Man{
    public abstract  int find();
    //private abstract  int get(); 不被允许的
    protected  abstract  String getstr();
}

public class yihuo {
    public static void main(String[] args) {
        int[] arr={3,3,10,2,4,2,5,5,4};
        int res=0;//初始值
        for(int i=0;i<arr.length;i++){
            res = res ^ arr[i];   //对于二进制的位运算：异或 ：相同为0，相异为1
                                    //相应的对应到十进制中： 异或的两个数：相同为0  任何数和0异或为自己
        }
        String a = new String();
        System.out.println(res);
    }

}
