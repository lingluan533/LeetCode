package com.java;

import sun.security.ec.CurveDB;

import java.net.URL;
import java.util.zip.Checksum;

/**
 * @author: zms
 * @create: 2021/12/30 9:10
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("********引导类加载器所加载**********");
        //获取BootStrapClassLoader能够加载的api的路径
        URL[] urls =  sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for(URL element : urls){
            System.out.println(element.toExternalForm());
        }
        //从上面的路径中随意选择一个类，看看他的类加载器是什么  果然是null 说明这个类的类加载器就是引导类加载器
        ClassLoader classLoader = Checksum.class.getClassLoader();
        System.out.println(classLoader);

        System.out.println("********扩展类加载器所加载**********");
        String extDirs = System.getProperty("java.ext.dirs");

        for(String path : extDirs.split(";")){
            System.out.println(path);
        }
        //从上面的路径中随意选择一个类，看看他的类加载器是什么
        ClassLoader classLoader1 =  CurveDB.class.getClassLoader();
        System.out.println(classLoader1);//sun.misc.Launcher$ExtClassLoader@1b6d3586 为扩展类加载器
    }
}