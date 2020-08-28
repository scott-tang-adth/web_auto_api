package com.test.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/7/28 20:12
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class WebElementApi {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = openBrowser("chrome");
        driver.get("https://www.ketangpai.com/");
        //WebElement webElement = driver.findElement(By.id("kw"));
        //webElement.sendKeys("lemon");
        //让代码暂停执行 单位为毫秒
        //Thread.sleep(3000);
        //clear 方法
        //webElement.clear();
        //ctrl + a 全选 组合键
        /*webElement.sendKeys(Keys.CONTROL,"a");
        Thread.sleep(1000);
        //ctrl + c 复制
        webElement.sendKeys(Keys.CONTROL,"c");
        Thread.sleep(1000);
        //ctrl + v 粘贴
        webElement.sendKeys(Keys.CONTROL,"v");
        Thread.sleep(1000);
        webElement.sendKeys(Keys.CONTROL,"v");
        Thread.sleep(1000);
        webElement.sendKeys(Keys.CONTROL,"v");*/
        //getAttribute
        //System.out.println(webElement.getAttribute("maxlength"));
        //getTagName
       // System.out.println(webElement.getTagName());
        //getText
        //WebElement webElement = driver.findElement(By.id("virus-2020"));
        //System.out.println(webElement.getText());
       // System.out.println(webElement.isDisplayed());
        //申请机构版 元素 --不可见
        //WebElement webElement = driver.findElement(By.xpath("//a[text()='申请机构版']"));
        //System.out.println(webElement.isDisplayed());

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
