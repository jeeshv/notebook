package com.huawei.notebook.heimaStudy.reflect;

import com.huawei.notebook.utils.PropertiesUtil;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Administrator on 2018/11/19.
 * 榨汁机案例
 *
 */
@Service
public class Demo2_reflect {
    public void testReflect() {
        //多态方式
        Juicer j = new Juicer();    //购买榨汁机
        //j.run(new Apple());         //向榨汁机放入苹果
        //j.run(new Banana());         //向榨汁机放入香蕉
        //反射方式
        try {
            String v = PropertiesUtil.getProperty("key");
            Class clazz = Class.forName(v);
            System.out.println(clazz);
            Fruit f = (Fruit) clazz.newInstance();
            j.run(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

interface Fruit{
    public void squeeze();
}

class Apple implements Fruit{
    public void squeeze(){
        System.out.println("榨出一杯苹果汁");
    }
}

class Banana implements Fruit{
    public void squeeze(){
        System.out.println("榨出一杯香蕉汁");
    }
}

class Juicer{
    public void run(Fruit a){
        a.squeeze();
    }
}
