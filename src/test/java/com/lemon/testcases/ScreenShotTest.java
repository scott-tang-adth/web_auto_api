package com.lemon.testcases;

import com.lemon.common.BaseTest;
import com.lemon.listener.TestngRetry;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/8/13 20:02
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class ScreenShotTest extends BaseTest {
    @BeforeTest
    public void setUpTest(){
        openBrowser("chrome");
        browserMaxmize();
        getUrl("https://www.baidu.com");
    }

    //retryAnalyzer = TestngRetry.class 让测试方法指向重试类是TestngRetry
    @Test(retryAnalyzer = TestngRetry.class)
    public void testScreenShot() throws InterruptedException, IOException {
        int a = 10;
        int b = 0;
        int c = a/b;
    }


}
