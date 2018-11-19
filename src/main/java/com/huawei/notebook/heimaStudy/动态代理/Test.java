package com.huawei.notebook.heimaStudy.动态代理;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/11/20.
 */
public class Test {
    public static void main(String[] args) {
        UserImpl user = new UserImpl();
        /*user.add();
        user.delete();*/
        //使用动态代理加 [ 权限校验 ] 和 [ 日志记录 ]
        MyInvocationHandler m = new MyInvocationHandler(user);
        User u = (User) Proxy.newProxyInstance(user.getClass().getClassLoader(),user.getClass().getInterfaces(),m);
        u.add();
    }
}
