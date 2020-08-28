package com.lemon.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2020/8/13 20:21
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class ScreenShotUtil {
    //截图的时候，以File文件形式输出
    public static void takeScreenShotFile(WebDriver driver){
        //截图 API -->TakeScreenShot
        //JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        //OutputType.FILE --> 把截图保存为file对象
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //把file对象保存到本地，并且是图片(.jpg/.png)
        //保证每一次生成的图片名字都不一样 -- 时间戳
        //把图片生成在项目的根目录 screenshot的目录下
        //得到当前的时间戳
        long currentTime = System.currentTimeMillis();
        String picPath = System.getProperty("user.dir")+"\\"+"screenshot"+"\\"+currentTime+".png";
        File targetFile = new File(picPath);
        //commons-io
        try {
            FileUtils.copyFile(srcFile,targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //截图的时候，是以字节数组形式输出
    public static byte[] takeScreenShotByte(WebDriver driver){
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        //OutputType.BYTES --》 输出是字节数组
        byte[] arr = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return arr;
    }

    public static void main(String[] args) {
        //当前项目的路径
        System.out.println();
    }
}
