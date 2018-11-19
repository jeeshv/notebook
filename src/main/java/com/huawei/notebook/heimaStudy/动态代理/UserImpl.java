package com.huawei.notebook.heimaStudy.动态代理;

/**
 * Created by Administrator on 2018/11/20.
 */
public class UserImpl implements User {

    public void add() {
        System.out.println("添加功能");
    }

    public void delete() {
        System.out.println("删除功能");
    }
}
