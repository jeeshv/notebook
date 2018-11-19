package com.huawei.notebook.heimaStudy.reflect;

import com.huawei.notebook.utils.PropertiesUtil;

/**
 * Created by Administrator on 2018/11/20.
 */
public class Demo3_reflect {
    public static void main(String[] args) throws Exception{
        String v = PropertiesUtil.getProperty("test");
        Class clazz = Class.forName(v);
        DemoClass f = (DemoClass) clazz.newInstance();
        f.run();
    }
}
