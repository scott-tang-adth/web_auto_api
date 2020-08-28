package com.lemon.pageobject;

import com.lemon.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/8/8 11:06
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class BackstageLoginPage extends BasePage {

    //用户名输入框
    private By usernameBy = By.name("admin_name");
    //密码输入框
    private By passwordBy = By.name("admin_pwd");
    //验证码的输入框
    private By verifyCodeBy = By.name("code");
    //登录按钮
    private By loginButtonBy = By.xpath("//button[text()='登陆后台']");

    public BackstageLoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeUsername(String username){
        type(usernameBy,username);
    }

    public void typePassword(String password){
        type(passwordBy,password);
    }

    public void typeVerifycode(String verifycode){
        type(verifyCodeBy,verifycode);
    }

    public void clickLogin(){
        click(loginButtonBy);
    }

}
