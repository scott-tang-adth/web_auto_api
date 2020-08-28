package com.lemon.listener;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/8/15 9:40
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
//在TestNG执行过程中动态修改@Test注解的参数
public class RetryListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        //1、得到@Test注解对应参数对象  --> retryAnalyzer 参数对象
        //annotation -->注解
        IRetryAnalyzer iRetryAnalyzer =  annotation.getRetryAnalyzer();
        //2、判断@Test注解里面有没有加上retryAnalyzer参数
        if(iRetryAnalyzer == null){
            //if判断+黑名单 testMethod.getName()
            //3、给retryAnalyzer设置值：重试机制监听类
            annotation.setRetryAnalyzer(TestngRetry.class);

        }
    }
}
