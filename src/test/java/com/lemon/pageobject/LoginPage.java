package com.lemon.pageobject;

import com.lemon.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author 歪歪欧巴
 * @Description 登录页面
 * @date 2020/8/6 20:24
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //手机号码输入框 By类型里面存储就是元素的定位方式+元素定位值
    private By mobilephoneBy = By.name("phone");
    //密码输入框
    private By passwordBy = By.name("password");
    //登录按钮
    private By loginBy = By.xpath("//button[text()='登录']");
    //页面中间提示信息
    private By centerInfoBy = By.className("layui-layer-content");
    //输入框的错误提示信息
    private By inputErrorInfoBy = By.className("form-error-info");



    //获取手机号码输入框的value值
    public String getMobilephoneInputText(){
        return getElementAttributeValue(mobilephoneBy,"value");
    }

    public String getPhoneErrorInfoText(){
        return getElementText(inputErrorInfoBy);
    }

    public String getCenterInfoText(){
        return getElementText(centerInfoBy);
    }

    public void typeMobilephone(String mobilephone){
        //driver从哪里来？？？
        //显示等待
        type(mobilephoneBy,mobilephone);
    }

    public void typePassword(String password){
        type(passwordBy,password);
    }

    public void clickLogin(){
        //waitElementClickable(driver,loginBy).click();
        click(loginBy);
    }

}
