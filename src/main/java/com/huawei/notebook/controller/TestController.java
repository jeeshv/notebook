package com.huawei.notebook.controller;

import com.huawei.notebook.heimaStudy.reflect.Demo2_reflect;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/11/10.
 */
@Controller
@RequestMapping("/testController")
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private Demo2_reflect demo2_reflect;
    @RequestMapping("test.do")
    @ResponseBody
    public String addCategory(){
        logger.info("测试连接");
        return "com.huawei.notebook";
    }

    @RequestMapping("testReflect.do")
    @ResponseBody
    public String testReflect(){
        demo2_reflect.testReflect();
        return "testReflect";
    }
}
