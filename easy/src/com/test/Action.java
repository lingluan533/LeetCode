package com.test;

/**
 * @author: zms
 * @create: 2021/12/29 9:06
 */
public interface Action {
   static int INIT(){           //jdk8 中接口可以定义静态方法
        System.out.println("我是接口类中的静态方法");
        return 1;
    }

    default int defaultmethod(){
       return 2;
    }
}
