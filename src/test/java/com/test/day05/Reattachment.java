package com.test.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * @author liletong
 * @date 2020/8/3 -21:22
 */
public class Reattachment {

    public static void main(String[] args) throws Exception {
        WebDriver driver = openBrowser("chrome");
        driver.get("http://www.lemfix.com/");
        driver.getCurrentUrl();
        //System.out.println("打开窗口之前的句柄："+driver.getWindowHandle());
        driver.findElement(By.xpath("//a[text()='登录']")).click();
        //<input class="form-control input-lg" placeholder="用户名 / Email" type="text" name="user[login]" id="user_login">
        //driver.findElement(By.id("user_login")).sendKeys("liletong");
        //Thread.sleep(2000);
        WebDriverWait webDriverWait = new WebDriverWait(driver,5);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user_login']")));
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("1111");
        /*driver.findElement(By.xpath("//input[@placeholder='用户名 / Email']")).sendKeys("liletong");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='密码']")).sendKeys("m15959265330");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='登录']")).click();
        Thread.sleep(2000);
        ////a[@title='Flutter 自动化测试-集成测试篇']
        driver.findElement(By.xpath("//a[@title='Flutter 自动化测试-集成测试篇']")).click();
        //System.out.println("打开窗口之后的句柄："+driver.getWindowHandle());
        *//*<textarea class="topic-editor form-control" rows="4" tabindex="1" name="reply[body]"
        id="reply_body" style="height: 101px;"></textarea>*//*
        ////*[@class='topic-editor form-control']回帖框
        //var element = document.getElementById("reply-button");
        //element.scrollIntoView(0);  滚动到指定元素位置，元素在浏览器页面的可视区域最下方
        //WebElement element = driver.findElement(By.id("reply-button"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("document.getElementById('reply-button')");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='topic-editor form-control']")).sendKeys("写的非常好");
        Thread.sleep(2000);
        ////button[text()='提交回复']
        driver.findElement(By.xpath("//button[text()='提交回复']")).click();*/


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
