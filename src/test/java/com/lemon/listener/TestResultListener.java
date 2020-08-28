package com.lemon.listener;

import com.lemon.common.BaseTest;
import com.lemon.testcases.LoginTest;
import com.lemon.util.ScreenShotUtil;
import io.qameta.allure.Attachment;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/8/13 20:24
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */

//动态替换每一个被@Test注解标注的测试方法 --全局监听器
public class TestResultListener implements IHookable {
    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        //每一条用例里面的@Test注解标注的测试方法都会被当前这个run替换掉
        //需求：正常执行测试方法
        iHookCallBack.runTestMethod(iTestResult);
        //并且需要知道用例执行结果
        //iTestResult ——>保存用例执行结果 getThrowable()-->获取异常
        if(iTestResult.getThrowable() != null){
            //用例结果统计了异常信息（包括用例失败）
            //调用截图方法来截图
            //问题点：driver驱动从哪里来？？？
            //iTestResult提供了一个getInstance ，这个方法可以获取当前测试类的实例（对象）
            //写法一
           /* Object object = iTestResult.getInstance();
            LoginTest loginTest = (LoginTest)object; */
            //写法二
            //问题点：只能适用于LoginTest测试类的执行情况，如果换了其他的测试类，这个就会报错
            //通过所有测试类的共同父类来接收测试类的对象BaseTest
            BaseTest baseTest = (BaseTest) iTestResult.getInstance();
            byte[] arr = ScreenShotUtil.takeScreenShotByte(baseTest.driver);
            //把截图作为附件添加到Allure报表中
            saveScreenshot(arr);
        }
    }

    //value：附件名 type：附件类型
    @Attachment(value = "screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
