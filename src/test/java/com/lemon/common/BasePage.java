package com.lemon.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author 歪歪欧巴
 * @Description 页面的共性操作
 * @date 2020/8/6 21:33
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class BasePage {
    //日志对象
    private Logger logger = Logger.getLogger(BasePage.class);

    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }
    //投资金额输入框
    //投资按钮
    //等待元素可见二次封装
    public WebElement waitElementVisible(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        return webDriverWait.until(ExpectedConditions.
                visibilityOfElementLocated(by));
    }

    //等待元素可被点击二次封装
    public WebElement waitElementClickable(By by) {
        WebDriverWait webDriverWait = new WebDriverWait( driver,10);
        return webDriverWait.until(ExpectedConditions.
                elementToBeClickable(by));
    }

    //显示等待并且点击元素进行封装
    public void click(By by){
        waitElementClickable(by).click();
        //todo -- 做点击操作统一日志
        logger.info("点击了元素【"+by+"】");
    }

    //显示等待并且给元素输入数据
    public void type(By by,String data){
        waitElementVisible(by).clear();
        waitElementVisible(by).sendKeys(data);
        //todo  --做输入数据操作统一日志
        logger.info("往元素【"+by+"】里面输入了数据【"+data+"】");
    }

    //显示等待并且获取元素文本值
    public String getElementText( By by){
        //todo  --做获取元素文本操作统一日志
        String elementText=waitElementVisible(by).getText();
        logger.info("获取元素【"+by+"】文本值【"+elementText+"】");
        return elementText;
    }

    //显示等待并且获取元素某一个属性的值
    public String getElementAttributeValue( By by,String attributeName){
        //todo  --做获取元素属性值操作统一日志
        String ElementValue=waitElementVisible(by).getAttribute(attributeName);
        logger.info("获取元素【"+by+"】属性名【"+attributeName+"】属性值【"+ElementValue+"】");
        return ElementValue;
    }

    //显示等待并且等待元素可见
    public boolean isElementVisible( By by){
        //todo  --做获取元素是否可见操作统一日志
        boolean isDisplay = waitElementVisible(by).isDisplayed();
        logger.info("获取元素【"+by+"】可见状态【"+isDisplay+"】");
        return waitElementVisible(by).isDisplayed();
    }

    /**
     * 切换iframe的二次封装
     * @param by
     */
    public void switchIframe(By by ){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        //等待iframe元素可用并且自动切换到iframe中--》frameToBeAvailableAndSwitchToIt
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
        logger.info("切换iframe【"+by+"】");
    }

    /**
     * 输入按键操作的二次封装
     */
    public void typeKey(By by, Keys keys){
        logger.info("给元素【"+by+"】输入按键操作【"+keys.name()+"】");
        waitElementVisible(by).sendKeys(keys);
    }
}
