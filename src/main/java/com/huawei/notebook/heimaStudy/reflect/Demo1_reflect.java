package com.huawei.notebook.heimaStudy.reflect;

import com.huawei.notebook.heimaStudy.testBean.Person;

/**
 * Created by Administrator on 2018/11/18.
 * 反射专题：获取类字节码的三种方法
 */
public class Demo1_reflect {
    public static void main(String[] args) {
        try {
            Class clazz1 = Class.forName("com.huawei.notebook.heimaStudy.testBean.Person");
            Class clazz2 = Person.class;
            Person p = new Person();
            Class clazz3 = p.getClass();
            System.out.println(clazz1 == clazz2);   //true
            System.out.println(clazz2 == clazz3);   //true
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
