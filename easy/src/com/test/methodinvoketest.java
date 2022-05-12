package com.test;

/**
 * @author: zms
 * @create: 2021/12/30 10:21
 */
class Person {
    String name ;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class methodinvoketest {
    public static void main(String[] args) {
        Person p1 = new Person("zms",15);
        System.out.println(p1);
        changePerson(p1);

        System.out.println(p1);
    }

    private static void changePerson(Person p1) {
        p1.setName("张茂盛");
    }

}
