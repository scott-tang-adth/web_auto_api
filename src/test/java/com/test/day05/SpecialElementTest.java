package com.test.day05;

import org.omg.SendingContext.RunTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/8/1 9:34
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class SpecialElementTest {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = openBrowser("chrome");
        //1、日期时间选择框 -- 手动输入数据
        //飞猪官网
        /*driver.get("https://www.fliggy.com/?ttid=seo.000000574&seoType=origin");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//form[@id='J_FlightForm']//input[@name='depDate']")).sendKeys("2020-08-02");*/

        //2、日期时间选择框 -- 不能手动输入数据
        //12306
        //driver.get("https://www.12306.cn/index/");
        //Thread.sleep(2000);
        //执行一段JavaScript代码去移除掉日期选择框的readonly属性
        //document.getElementById("train_date").removeAttribute("readonly");
        //driver转换成JavaScriptExecutor对象
        /*ChromeDriver chromeDriver = (ChromeDriver) driver;
        JavascriptExecutor javascriptExecutor = chromeDriver;*/
        /*JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("document.getElementById('train_date').removeAttribute('readonly')");*/
        //selenium传参给JavaScript脚本 arguments[i]  i范围从0-n 让java和javaScript脚本有交互性
        /*String attributeName="readonly";
        WebElement webElement = driver.findElement(By.xpath("//input[@id='train_date']"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].removeAttribute(arguments[1])",
                webElement,attributeName);
        Thread.sleep(2000);
        driver.findElement(By.id("train_date")).clear();
        driver.findElement(By.id("train_date")).sendKeys("2020-08-02");*/

        //通过JavaScript滚动页面
        //var element = document.getElementById("index_ads");
        //element.scrollIntoView();  滚动到指定元素位置，元素在浏览器页面的可视区域最上方
        //element.scrollIntoView(0);  滚动到指定元素位置，元素在浏览器页面的可视区域最下方
        //豌豆荚App排行榜
        //driver.get("https://www.wandoujia.com/top/app");
        //driver.findElement(By.xpath("//a[@title='微信']")).click();
        //滚动到查看更多元素上，点击查看更多
        //WebElement webElement =  driver.findElement(By.id("j-refresh-btn"));
        //循环来滚动点击查看更多元素 ，判断页面中是否有包含对应的元素（迅雷）
        //当列表滚动到最末尾的时候，查看更多元素隐藏起来（不可见）
        //页面滚动到最末尾--页面没有变化了的 滚动之前和滚动之后的页面是否有变化
        /*JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        while(true){
            if(driver.getPageSource().contains("滴滴XXX")){
                driver.findElement(By.xpath("//a[@title='滴滴XXX']")).click();
                break;
            }
            //滚动之前的页面信息
            String beforeSource = driver.getPageSource();
            javascriptExecutor.executeScript("document.getElementById('j-refresh-btn').scrollIntoView(0)");
            Thread.sleep(2000);
            //滚动之后的页面信息
            String afterSource = driver.getPageSource();
            //页面滚动到最末尾--页面没有变化了的 滚动之前和滚动之后的页面是否有变化
            if(beforeSource.equals(afterSource)){
                System.out.println("找不到元素");
                break;
            }
            driver.findElement(By.id("j-refresh-btn")).click();

        }*/

        //Thread.sleep(2000);


        //3、文件上传
        //3-1、文件上传元素 input标签名，type为file 通过sendKeys来写入文件路径即可
        //driver.get("file:///C:/Users/Administrator/Desktop/fileupload.html");
        //driver.findElement(By.id("test")).sendKeys("C:\\Users\\Administrator\\Desktop\\图片1.png");
        //3-2、文件上传 非input标签名，没有type为file的属性 通过第三方自动化工具 Autoit
        driver.get("https://www.layui.com/demo/upload.html");
        //点击文件上传
        driver.findElement(By.id("test1")).click();
        Thread.sleep(2000);
        //执行本地的autoit的exe文件
        //得到Java运行时对象 runTime
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("src\\test\\resources\\autoit.exe");
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
