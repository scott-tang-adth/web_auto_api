package com.test.day05.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/8/4 20:04
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class HomeworkTest {
    public static void main(String[] args) throws InterruptedException {
        //homework1();
        homework2();
    }

    public static void homework2() throws InterruptedException {
        WebDriver driver = openBrowser("chrome");
        driver.get("http://www.lemfix.com/");
        //点击登录
        driver.findElement(By.linkText("登录")).click();
        //页面元素会重新加载--记得加等待
        Thread.sleep(2000);
        driver.findElement(By.id("user_login")).sendKeys("liletong");
        driver.findElement(By.id("user_password")).sendKeys("m15959265330");
        driver.findElement(By.xpath("//input[@name='commit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='Flutter 自动化测试-集成测试篇']")).click();
        Thread.sleep(2000);
        //JavaScript完成滚动到回帖区域
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("document.getElementById('reply_body').scrollIntoView()");
        Thread.sleep(2000);
        driver.findElement(By.id("reply_body")).sendKeys("lemon test");
    }

    public static void homework1() throws InterruptedException {
        WebDriver driver = openBrowser("chrome");
        driver.get("D:\\svn_lemon\\教学ppt\\yy\\Java全栈自动化\\03-web自动化\\特殊元素定位和操作静态页面\\iframe\\a.html");
        //第一个输入框输入数据
        Thread.sleep(2000);
        driver.findElement(By.id("aa")).sendKeys("AAA");
        Thread.sleep(2000);
        //第二个输入框输入数据 --切换iframe
        driver.switchTo().frame("bframe");
        driver.findElement(By.id("bb")).sendKeys("BBB");
        Thread.sleep(2000);
        //第三个输入框输入数据 --切换iframe
        driver.switchTo().frame("cframe");
        driver.findElement(By.id("cc")).sendKeys("CCC");
        //给第二个输入框去输入DDD -- 回到上一级iframe中
        Thread.sleep(2000);
        driver.switchTo().parentFrame();
        driver.findElement(By.id("bb")).clear();
        driver.findElement(By.id("bb")).sendKeys("DDD");
        //回到默认页面 --parentFrame defaultContent
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("aa")).clear();
        driver.findElement(By.id("aa")).sendKeys("完成");

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
