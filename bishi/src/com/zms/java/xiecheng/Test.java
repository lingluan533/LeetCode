package com.zms.java.xiecheng;

import java.io.FileNotFoundException;

/**
 * @author: zms
 * @create: 2022/8/30 22:25
 */
public class Test {
    public interface Interface1{
        Integer getAge();
    }
    public interface Interface2{
        String getName();
    }
    public interface Interface3 extends Interface1,Interface2{

    }
   static abstract class Father{
        String name;
        public Father(String name){
            this.name = "ssssss";
        }
        public Father(){

        }
     //  public abstract void Eat();

       @Override
       protected Object clone() throws CloneNotSupportedException {

            return super.clone();
       }
   }
   static abstract class Person{
       protected abstract void Eat();
   }
    static class Son extends Father implements Interface3{
        String name;

        public Son(String name) {

            this.name = name;
        }

        @Override
        public Integer getAge() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }
    }

    public class MyClassLoasder extends ClassLoader{
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try{
                byte[] result = getClassFromCustomPath(name);
                if(result==null){
                    throw new FileNotFoundException();
                }else{
                    return defineClass(name,result,0,result.length);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return super.findClass(name);
        }
        private byte[] getClassFromCustomPath(String path){
            //从自定义路径中加载指定类的二进制文件 细节略
            //如果指定路径的字节码文件进行了加密，需要在此进行解密操作再返回
            return null;
        }

    }
    public static void main(String[] args) {
        Father son = new Son("sdss");
        System.out.println(son.name);
    }
}
