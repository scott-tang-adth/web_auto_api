package com.test.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/7/28 21:14
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class ElementWaitTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = openBrowser("chrome");
        //设置全局的隐式等待，超时时间设置为5S，只需要全局设置一次即可
        //它的效果：findElement/findElements 去找元素的时候，会有隐式等待效果-一直不断的去循环找元素，
        //直到元素找到为止，超时的话的就会报异常--NoSuchElementException
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("lemon");
        driver.findElement(By.id("su")).click();
        //NoSuchElementException  -- 找不到元素异常
        //1、定位表达式写错了
        //2、没有加等待--元素没有加载出来
        //傻等--时间拿捏不准确
        //Thread.sleep(2000);
        driver.findElement(By.className("c-title-text-啊啊啊")).click();*/


        driver.get("https://www.ketangpai.com/");
        //隐式等待--只能等待元素在当前的dom中存在
        //显示等待
        //1、实例化WebDriverWait对象  第二个参数：超时时间 单位：为秒
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        //2、通过webDriverWait 的until方法--》直到某个条件满足时为止
        //条件：Selenium默认提供的
        //By:元素的定位信息：元素定位方式、元素的定位值
        //visibilityOfElementLocated -->元素存在并且可见
        //presenceOfElementLocated -->元素存在 在dom中
        //elementToBeClickable  -->元素可被点击
       WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='登录']")));
       webElement.click();
       // webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='申请机构版']")));
       // webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='申请机构版']")));
        //WebElement webElement = driver.findElement(By.xpath("//a[text()='申请机构版']"));
        //element not visible 元素能够被点击的前提是：元素要可见
        //webElement.click();


        //显示等待（常用）  VS 隐式等待（不能适应更加复杂的场景）
        //1、作用域范围 显示等待：针对于某一个元素  隐式等待：全局的（findElement/findElements）
        //2、等待的条件 显示等待：元素可见、元素存在、元素可被点击...  隐式等待：元素存在
        //3、超时报异常的区别  显示等待：TimeoutException--超时 隐式等待：NoSuchElementException-找不到元素
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
