package com.lemon.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/8/13 21:41
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
//实现此接口可以让失败的用例运行重试机制
public class TestngRetry implements IRetryAnalyzer {
    //最大的重试次数
    public int maxRetryCount = 2;
    //当前的重试次数
    public int currentRetyCount = 0;

    //日志
    private Logger logger = Logger.getLogger(TestngRetry.class);
    @Override
    public boolean retry(ITestResult iTestResult) {
        //如果retry方法返回的为false，表示不会去执行重试机制
        //如果retry方法返回的为true，表示会去执行重试机制
        //如果只返回true，没有做限制，就是死循环
        if(currentRetyCount < maxRetryCount) {
            currentRetyCount++;
            logger.info("当前运行第【"+currentRetyCount+"】次重试机制");
            return true;
        }else {
            return false;
        }
    }

}
