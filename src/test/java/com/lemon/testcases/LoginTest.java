package com.lemon.testcases;

import com.lemon.common.BaseTest;
import com.lemon.listener.TestngRetry;
import com.lemon.pageobject.IndexPage;
import com.lemon.pageobject.LoginPage;
import com.lemon.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {
    @Parameters({"browserName"})
    @BeforeMethod
    public void setUpTest(String browserName){
        //用例前置
        //1、打开浏览器
        openBrowser(browserName);
        //2、访问登录页面的URL地址
        getUrl(Constants.LOGIN_URL);
        //3、浏览器最大化
        browserMaxmize();
    }

    @Test()
    public void testLoginSuccess() throws InterruptedException {
        //（1）实例化LoginPage对象
        LoginPage loginPage = new LoginPage(driver);
        //（2）调用对象的行为
        loginPage.typeMobilephone(Constants.INVEST_MOBILEPHONE);
        loginPage.typePassword(Constants.INVEST_PASSWORD);
        loginPage.clickLogin();

        //4、断言是否登录成功 页面变化/提示信息
        //（1）根据跳转之后页面的地址-主页
        Thread.sleep(3000);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,Constants.INDEX_URL);
        //（2）跳转之后的主页是否有当前用户的昵称
        /*WebElement webElement = driver.findElement(By.xpath("//a[contains(text(),'我的帐户')]"));
        //2-1,获取到昵称元素完整文本值,根据元素是否有包含用户的昵称文本做断言
        String text = webElement.getText();
        if(text.contains("自动化测试帐号1")){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }*/
        //2-2，根据昵称是否可见做断言
        String userNickname = Constants.INVEST_NICKNAME;
        IndexPage indexPage = new IndexPage(driver);
        Assert.assertTrue(indexPage.isNicknameVisible(userNickname));
        //用例结果为失败的话
        //1、断言不通过
        //2、断言之前的代码运行抛异常
    }

    @Test(dataProvider = "getLoginFailureDatas001")
    public void testLoginFailure_001(String phone, String password, String expectedValue){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeMobilephone(phone);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        //等待提示信息出来 --显示等待
        //断言 --根据页面的提示信息-此账号没有经过授权，请联系管理员
        Assert.assertEquals(loginPage.getCenterInfoText(),expectedValue);
    }

    @Test(enabled = false,dataProvider ="getLoginFailureDatas002")
    public void testLoginFailure002(String phone, String password, String expectedValue){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeMobilephone(phone);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        //断言
        Assert.assertEquals(loginPage.getPhoneErrorInfoText(),expectedValue);
    }

    @Test(enabled = false)
    public void remeberMobilephone(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeMobilephone(Constants.INVEST_MOBILEPHONE);
        loginPage.typePassword(Constants.INVEST_PASSWORD);
        loginPage.clickLogin();
        //进入到主页
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickQuit();
        indexPage.clickLogin();
        //断言 -- 手机号码输入框里面是否有手机号码 -value属性值
        Assert.assertEquals(loginPage.getMobilephoneInputText(),Constants.INVEST_MOBILEPHONE);
    }

    @DataProvider
    public Object[][] getLoginFailureDatas001() {
        Object[][] datas = {{"15859019266", "123456", "账号没有经过授权，请联系管理员!"},
                {"13323234545", "LEMON123456", "帐号或密码错误!"},
                {"13323234545", "lemon1234567890", "帐号或密码错!"},
                {"13323234545", "le", "帐号或密码错!"},
                {"13323234545", "lemon 123456", "帐号或密码错误!"},
        };
        return datas;

    }

    @DataProvider
    public Object[][] getLoginFailureDatas002() {
        Object[][] datas = {{"", "123456", "请输入手机号"},
                {"1585901925", "123456", "请输入正确的手机号"},
                {"158590192534", "123456", "请输入正确的手机号"},
                {"1585901925%", "123456", "请输入正确的手机号"},
                {"13323234545", "", "请输入密码"},
        };
        return datas;

    }


    @AfterMethod
    public void tearDownTest() throws InterruptedException {
        //用例后置
        //关闭浏览器
        //Thread.sleep(3000);
        quitBrowser();
    }

}
