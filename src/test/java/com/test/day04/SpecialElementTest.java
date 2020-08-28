package com.test.day04;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/7/30 20:11
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class SpecialElementTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = openBrowser("chrome");
        //（1）、非select下拉框
        //driver.get("https://www.layui.com/demo/form.html");
        //driver.findElement(By.xpath("//label[text()='联动选择框']/following-sibling::div[1]")).click();
        //Thread.sleep(3000);
        //driver.findElement(By.xpath("//dd[text()='福建省']")).click();
        //（2）、Select下拉框
        driver.get("C:\\Users\\Administrator\\Desktop\\Alert.html");
        WebElement webElement = driver.findElement(By.id("test"));
        //将元素包装为Select对象
        Select select = new Select(webElement);
        //根据索引选择选项
        //select.selectByIndex(1);
        //根据文本来选择
        //select.selectByVisibleText("地理");
        //select.selectByValue();


        //2、iframe切换
        /*driver.get("https://ke.qq.com/?tuin=54f4618b");
        driver.findElement(By.id("js_login")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='QQ登录']")).click();
        Thread.sleep(2000);
        ///需要切换iframe
        //1、根据iframe 元素来切换
        //WebElement webElement = driver.findElement(By.name("login_frame_qq"));
        //driver.switchTo().frame(webElement);
        //2、根据iframe的索引index来去切换,索引值从0开始 缺点：你必须要全局搜索当前的iframe位于页面中的第几个
        driver.switchTo().frame(2);
        //3、根据iframe的id属性
        //driver.switchTo().frame();
        //点击选择账号密码登录
        driver.findElement(By.id("switcher_plogin")).click();
        //输入QQ号
        driver.findElement(By.id("u")).clear();
        driver.findElement(By.id("u")).sendKeys("1425301899");
        //输入密码
        driver.findElement(By.id("p")).clear();
        driver.findElement(By.id("p")).sendKeys("123456");
        Thread.sleep(2000);
        //关闭弹框
        //回到默认的页面中
        ///driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();
        driver.findElement(By.id("login_close")).click();*/

        //3、window-窗口的切换
        /*driver.get("https://www.baidu.com/");
        //getWindowHandle()  --> 获取当前窗口的句柄
        System.out.println("打开窗口之前的句柄："+driver.getWindowHandle());
        driver.findElement(By.xpath("//a[text()='高考加油']")).click();
        Thread.sleep(2000);*/
        //切换window  -- 句柄handle——>窗口唯一标识
        //通过新的窗口的句柄来切换
        //获取当前打开的所有窗口对应的句柄
        /*Set<String> handles = driver.getWindowHandles();
        for (String handle: handles){
            //找到新窗口的句柄--根据窗口的特殊标识-title（推荐）、URL
            //如果当前driver的焦点在对应的窗口的话，那么它获取到的title也是对应窗口的
            if(driver.getTitle().equals("高考_百度搜索")){
                break;
            }else{
                //如果当前driver的焦点不在对应的窗口的话
                driver.switchTo().window(handle);
            }
        }
        System.out.println("打开新窗口之后所有句柄："+handles);
        System.out.println("打开窗口之后的句柄："+driver.getWindowHandle());
        driver.findElement(By.xpath("//a[text()='AI志愿']")).click();*/

        //4、Alert弹框
        /*driver.get("C:\\Users\\Administrator\\Desktop\\Alert.html");
        driver.findElement(By.id("abtn")).click();
        Thread.sleep(2000);
        //Alert处理弹框
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();*/

        //5、鼠标操作 -Actions类处理
        /*driver.get("https://www.baidu.com");
        Actions actions = new Actions(driver);
        WebElement webElement = driver.findElement(By.xpath("//div[@id='s-top-left']/a[text()='贴吧']"));
        actions.contextClick(webElement);
        //调用perform方法，让动作生效
        actions.perform();*/
        /*driver.get("http://www.treejs.cn/v3/demo/cn/exedit/drag.html");
        WebElement webElement1 = driver.findElement(By.id("treeDemo_2_span"));
        WebElement webElement2 = driver.findElement(By.id("treeDemo_3_span"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        //一连串鼠标动作
        //1、通过鼠标一直按住元素 2、拖拽到指定文件夹下面 3、鼠标释放 4、让动作生效
        actions.clickAndHold(webElement1).dragAndDrop(webElement1,webElement2).release().perform();
        */


        //NoSuchElementException 异常导致的原因
        //1、元素定位表达式写错
        //2、元素等待问题，元素没有加载出来
        //3、元素在iframe里头，没有切换iframe
        //4、元素在新的window里头，没有切换window


        //总结
        //1、下拉框 非Select标签名--》通过点击选择选项  Select标签名--》包装为Select对象
        //2、Iframe切换 driver.switchTo.frame(WebElement)，
        //2-1、parentFrame回到上一级页面  defaultContent 回到默认的页面
        //2-2、怎么区分元素是否在iframe：通过F12路径，看路径中是否有iframe
        //3、window 句柄，根据句柄来切换，通过for循环遍历->条件：根据窗口的title判断句柄是否为当前窗口
        //4、Alert 弹框， Alert类处理  accept方法/getText()
        //5、鼠标操作 Actions，单击、双击、右键、拖拽、释放 ，不要忘记加perform
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
