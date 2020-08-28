package com.lemon.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.rmi.runtime.Log;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/8/8 10:42
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class BaseTest {
    private Logger logger = Logger.getLogger(BaseTest.class);
    public WebDriver driver;
    //打开浏览器统一封装
    public void openBrowser(String browserName) {
        //todo -- 打开浏览器日志
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
            ChromeDriver chromeDriver = new ChromeDriver();
            driver = chromeDriver;
            logger.info("============================打开Chrome浏览器=======================");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
            System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
            FirefoxDriver firefoxDriver = new FirefoxDriver();
            driver=firefoxDriver;
            logger.info("============================打开Firefox浏览器=======================");
        } else if (browserName.equalsIgnoreCase("ie")) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
            InternetExplorerDriver ieDriver = new InternetExplorerDriver(desiredCapabilities);
            driver=ieDriver;
            logger.info("============================打开IE浏览器=======================");
        }
    }

    //访问对应的页面
    public void getUrl(String urlPath){
        //todo
        logger.info("访问对应的URL页面【"+urlPath+"】");
        driver.get(urlPath);
    }

    //最大化浏览器
    public void browserMaxmize(){
        //todo -- 浏览器最大日志处理
        logger.info("浏览器最大化");
        driver.manage().window().maximize();
    }

    //浏览器全屏
    public void browserFullScreen(){
        //todo -- 浏览器最大日志处理
        logger.info("浏览器全屏");
        driver.manage().window().fullscreen();
    }

    //浏览器前进操作
    public void browserForward(){
        //todo -- 浏览器前进处理
        logger.info("浏览器前进");
        driver.navigate().forward();
    }

    //浏览器后退操作
    public void browserBack(){
        //todo -- 浏览器后退处理
        logger.info("浏览器后退");
        driver.navigate().back();
    }

    //浏览器前进操作
    public void browserRefresh(){
        //todo -- 浏览器刷新处理
        logger.info("浏览器刷新");
        driver.navigate().refresh();
    }

    public void quitBrowser(){
        //todo -- 浏览器退出处理
        logger.info("浏览器退出");
        driver.quit();
    }
}
