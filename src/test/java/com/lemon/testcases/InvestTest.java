package com.lemon.testcases;

import com.lemon.common.BaseTest;
import com.lemon.pageobject.*;
import com.lemon.util.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/8/8 10:59
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class InvestTest extends BaseTest {
    public String loanTitle="";

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUpMethod(String browserName){
        openBrowser(browserName);
        browserMaxmize();
        //前置操作-后台已加标？？？ 创建测试数据
        //UI操作
        //接口
        //数据库
        //后台添加标的数据
        createBidData();
        getUrl(Constants.LOGIN_URL);
        //前置操作-登录
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeMobilephone(Constants.INVEST_MOBILEPHONE);
        loginPage.typePassword(Constants.INVEST_PASSWORD);
        loginPage.clickLogin();

    }

    public void createBidData(){
        //后台登录动作
        getUrl(Constants.BACKSTAGE_URL);
        BackstageLoginPage backstageLoginPage = new BackstageLoginPage(driver);
        backstageLoginPage.typeUsername(Constants.BACKSTAGE_USERNAME);
        backstageLoginPage.typePassword(Constants.BACKSTAGE_PASSWROD);
        backstageLoginPage.typeVerifycode(Constants.BACKSTAGE_VERIFYCODE);
        backstageLoginPage.clickLogin();
        //后台主页加标  -- 作业
        //加完标之后，有项目的标题
        BackStageIndexPage indexPage = new BackStageIndexPage(driver);
        indexPage.clickLoanManage();
        indexPage.clickAddBid();
        indexPage.typeBorrowser(Constants.BORROWER_MOBILEPHONE);
        //每一次脚本执行，标题都不一样  时间戳--整数，记录系统从1970年以来次数
        long timeVar = System.currentTimeMillis();
        loanTitle = "测试"+timeVar;
        indexPage.typeLoanTitle(loanTitle);
        indexPage.typeLoanRate("10");
        indexPage.typeLoanTerm("5");
        indexPage.typeLoanLimit("500000");
        indexPage.typeBidTerm("5");
        indexPage.clickRiskControl();
        indexPage.typeEvaluteValue("2000000");
        indexPage.clickProjectImport();
        indexPage.typeCountry("深圳");
        indexPage.typeOccupation("测试");
        indexPage.typeAge("20");
        indexPage.clickCommit();

        //标的三次审核
        indexPage.clickLatestBid();
        indexPage.clickVerify();
        indexPage.clickVerifyPass();

        indexPage.clickLatestBid();
        indexPage.clickVerify();
        indexPage.clickVerifyPass();

        indexPage.clickLatestBid();
        indexPage.clickVerify();
        indexPage.clickVerifyPass();
    }

    @Test
    public void testInvestSuccess(){
        //1、根据项目的标题选择对应的抢投标元素，点击
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickRushtobid(loanTitle);
        InvestPage investPage = new InvestPage(driver);
        //2、投资之前获取到用户的可用余额、标的可投资金额
        String beforeLeaveAmount = investPage.getUserLeaveAmount();
        double beforeBidLeaveAmount = investPage.getBidLeaveAmount();
        //3、进入到投资页面输入投资金额
        investPage.typeInvestAmount("1000");
        //4、点击投资按钮
        investPage.clickInvestButton();
        //断言 -- 根据投标成功！的提示信息与否做断言
        Assert.assertTrue(investPage.isInvestSuccessExist());
        //刷新浏览器
        browserRefresh();
        //5、投资之后获取到用户的可用余额、标的剩余可投资金额
        //Assert.assertEquals();
        double afterBidLeaveAmount = investPage.getBidLeaveAmount();
        String afterLeaveAmount = investPage.getUserLeaveAmount();

        double actualValue = Double.valueOf(beforeLeaveAmount) - Double.valueOf(afterLeaveAmount);
        //断言-用户的余额是否减少了对应的
        Assert.assertEquals(actualValue,1000);
        int actualBidAmount = (int) ((beforeBidLeaveAmount-afterBidLeaveAmount)*10000);
        //断言--标的金额是否减少了对应的
        Assert.assertEquals(actualBidAmount,1000);
        //数据库查询？？？没有必要去做的 接口阶段保证的
    }

    @AfterMethod
    public void tearDownMethod(){
        quitBrowser();
    }


}
