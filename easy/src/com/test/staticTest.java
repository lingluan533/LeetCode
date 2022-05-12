package com.test;

/**
 * @author: zms
 * @create: 2021/12/30 9:23
 */
public class staticTest {
    static int NUM = 10;
    String name = "zms";
    public static int  getNum(){
       getNext();
     //  name = "ww";
      // getName();  // 编译错误，静态方法中只能访问静态成员，即静态成员变量和静态方法
        return NUM;
    }
    public static int getNext(){
        return NUM+1;
    }

    public String getName(){
        name = "wlh";
        NUM +=1;
        getNum();
        return "zms";
    }
}
