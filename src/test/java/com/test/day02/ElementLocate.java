package com.test.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/7/25 9:40
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class ElementLocate {
    public static void main(String[] args) {
        WebDriver driver = openBrowser("chrome");
        //怎么选择合适的元素定位方式：保证定位方式可以唯一的定位到对应的元素
        //driver.get("https://www.baidu.com");
        //一、六种基本元素定位
        //1、id属性元素定位
        //driver.findElement(By.id("kw")).sendKeys("lemon");
        //2、name属性元素定位
        //driver.findElement(By.name("wd")).sendKeys("lemon");
        //findElement : 只会找到一个元素（通过定位方式找到多个的话，选择第一个）
        //findElements : 找到的所有元素全部保存到集合中
        //3、tagName 标签名定位 -- 几乎不用
        /*List<WebElement> list = driver.findElements(By.tagName("input"));
        for(WebElement webElement : list){
            System.out.println(webElement);
        }*/
        //4、class属性定位--className定位
        //bg s_btn btn_h btnhover 复合类名  Compound class names not permitted
        //解决方案：选取其中一个（前提是要保证这一个全局唯一的）
        //driver.findElement(By.className("s_ipt")).sendKeys("lemon");
        //driver.findElement(By.className("s_btn")).click();
        //5、超链接(a标签)文本定位linkText
        //driver.findElement(By.linkText("高考加油")).click();
        //6、超链接部分文本匹配 --partialLinkText  模糊匹配
        //driver.findElement(By.partialLinkText("高考加油")).click();

        //浏览器调试窗口定位元素的时候最好是通过代码打开的全新的浏览器里面去定位（大坑） -- 保持一致

        //二、cssSelector CSS选择器
        //1、基本的
        //（1）tagName ~ By.tagName定位
        //driver.findElement(By.cssSelector("input"));
        //（2）id ~By.id定位
        //driver.findElement(By.cssSelector("#kw")).sendKeys("lemon");
        //（3）classname ~ By.className 支持复合类名(把空格替换为.)--少用
        //driver.findElement(By.cssSelector("#kw")).sendKeys("lemon");
        //driver.findElement(By.cssSelector(".bg.s_btn")).click();

        //2、高级一些的--属性选择
        //driver.findElement(By.cssSelector("input[name=\"wd\"][maxlength=\"255\"]")).sendKeys("lemon");

        //三、xpath定位
        //1、绝对路径 -- 禁止使用？？？ 很难维护
        driver.get("http://120.78.128.25:8765/Index/login.html");
        driver.findElement(By.xpath("/html/body/div[2]/div/form/div[5]/button")).click();
        //src\test\resources\chromedriver.exe


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
