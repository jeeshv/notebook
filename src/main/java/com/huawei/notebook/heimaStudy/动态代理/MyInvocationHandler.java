package com.huawei.notebook.heimaStudy.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/11/20.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;
    public MyInvocationHandler(Object target){  //target被代理的对象
        this.target = target;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { //Method 通过反射要获取的方法，动态代理本质是反射
        System.out.println("权限校验");
        method.invoke(target,args); //执行被代理target对象的方法
        System.out.println("日志记录");
        return null;
    }
}
