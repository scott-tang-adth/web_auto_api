package com.test.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/7/28 20:34
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class WebDriverApi {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = openBrowser("chrome");
        driver.get("https://www.baidu.com");
        //driver.findElement(By.xpath("//a[text()='登录']")).click();
        //System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getTitle());
        //System.out.println(driver.getPageSource());
        //driver.findElement(By.id("virus-2020")).click();
        //Thread.sleep(2000);
        //把之前的窗口给关闭的 driver驱动-》打开了一个新的窗口的时候，它不知道
        //driver.close();
        //navigate对象的操作
        /*Navigation navigation = driver.navigate();
        Thread.sleep(2000);
        navigation.to("https://www.jd.com");
        Thread.sleep(2000);
        navigation.back();
        Thread.sleep(2000);
        navigation.forward();
        Thread.sleep(2000);
        navigation.refresh();*/

        //window对象 --》窗口
        Window window = driver.manage().window();
        //全屏
        //window.fullscreen();
        //最大化
        //window.maximize();
        //获取到浏览器窗口的尺寸
        Dimension dimension = window.getSize();
        System.out.println(dimension.getWidth());
        System.out.println(dimension.getHeight());
        Dimension dimension1 = new Dimension(500,500);
        window.setSize(dimension1);
        Thread.sleep(2000);
        //获取到浏览器位置-坐标   屏幕左上角为坐标轴的原点
        Point point = window.getPosition();
        System.out.println(point.getX());
        System.out.println(point.getY());
        Point point1 = new Point(100,100);
        window.setPosition(point1);
    }

    public static WebDriver openBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            //1、打开浏览器 --Chrome
            //The path to the driver executable must be set by the webdriver.chrome.driver system property
            //设置代码环境变量-让代码可以知道驱动在哪里
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
            //驱动--控制/操作浏览器 exe格式
            ChromeDriver chromeDriver = new ChromeDriver();
            return chromeDriver;
        } else if (browserName.equalsIgnoreCase("firefox")) {
            //打开浏览器 --Firefox
            //Cannot find firefox binary in PATH. Make sure firefox is installed -- Firefox没有装在默认的C盘
            //设置代码环境变量-让代码可以知道Firefox启动文件路径在哪里
            //The path to the driver executable must be set by the webdriver.gecko.driver system property --驱动
            System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
            System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
            FirefoxDriver firefoxDriver = new FirefoxDriver();
            return firefoxDriver;
        } else if (browserName.equalsIgnoreCase("ie")) {
            //打开浏览器 --IE 政府机关
            //The path to the driver executable must be set by the webdriver.ie.driver system property; -- 驱动
            //unexpected error launching Internet Explorer. Browser zoom level was set to 125%. It should be set to 100%
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            desiredCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
            InternetExplorerDriver ieDriver = new InternetExplorerDriver(desiredCapabilities);
            return ieDriver;
        }
        return null;
    }
}
