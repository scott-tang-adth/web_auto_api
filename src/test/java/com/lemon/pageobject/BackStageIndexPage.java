package com.lemon.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.lemon.common.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**  
 * @Title: BackStageIndexPage.java
 * @Description: TODO(描述)
 * @author 歪歪欧巴
 * @date 2020年7月1日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved. 
 */
public class BackStageIndexPage extends BasePage{

	//借款管理
	private By loanManageby = By.xpath("//span[text()='借款管理']");

	public BackStageIndexPage(WebDriver driver) {
		super(driver);
	}

	public void clickLoanManage(){
		click(loanManageby);
	}
	//iframe元素
	private By iframeBy = By.id("mainFrame");
	
	//加标
	private By addBidBy = By.xpath("//span[text()='加标']");
	
	public void clickAddBid(){
		//切换iframe
		switchIframe(iframeBy);
		click(addBidBy);
	}
	//借款人输入框元素定位
	private By borrowerBy = By.xpath("//td[text()='借款人:']/following-sibling::td/span/input[1]");
	
	public void typeBorrowser(String data){
		//输完数据之后，需要选择结果中的数据
		type(borrowerBy, data);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//输入方向下键-->输入Enter键
		typeKey(borrowerBy, Keys.ARROW_DOWN);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		typeKey(borrowerBy, Keys.ENTER);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//借款标题
	private By loanTitleBy = By.xpath("//td[text()='贷款标题:']/following-sibling::td/input");
	
	public void typeLoanTitle(String data){
		type(loanTitleBy, data);
	}
	//年利率利息
	private By loanRateBy = By.xpath("//td[text()='年利率利息:']/following-sibling::td/input");
	
	public void typeLoanRate(String data){
		type(loanRateBy, data);
	}
	
	//借款期限
	private By loanTermBy = By.xpath("//td[text()='借款期限:']/following-sibling::td/input");
	
	public void typeLoanTerm(String data){
		type(loanTermBy, data);
	}
	
	//借款额度
	private By loanLimitBy = By.xpath("//td[text()='借款额度:']/following-sibling::td/input");
	
	public void typeLoanLimit(String data){
		type(loanLimitBy, data);
	}
	
	//竞标期限
	private By bidTermBy = By.xpath("//td[text()='竞标期限:']/following-sibling::td/input");
	
	public void typeBidTerm(String data){
		type(bidTermBy, data);
	}
	
	//风控评测
	private By riskControlBy = By.xpath("//span[text()='风控评测']");
	
	public void clickRiskControl(){
		click(riskControlBy);
	}
	
	//评估价值
	private By evaluteValueBy = By.xpath("//td[text()='评估价值:']/following-sibling::td/input");
	
	public void typeEvaluteValue(String data){
		type(evaluteValueBy, data);
	}
	
	//项目录入
	private By projectImportBy = By.xpath("//span[text()='项目录入']");
	
	public void clickProjectImport(){
		click(projectImportBy);
	}
	
	//籍贯
	private By countryBy = By.xpath("//td[text()='籍贯:']/following-sibling::td/input");
	
	public void typeCountry(String data){
		type(countryBy, data);
	}
	
	//职业
	private By occupationBy = By.xpath("//td[text()='职业:']/following-sibling::td/input");
	
	public void typeOccupation(String data){
		type(occupationBy, data);
	}
	
	//年龄
	private By ageBy = By.xpath("//td[text()='年龄:']/following-sibling::td/input");
	
	public void typeAge(String data){
		type(ageBy, data);
	}
	
	//提交
	private By commitBy = By.xpath("//span[text()='提交']");
	
	public void clickCommit(){
		click(commitBy);
	}
	
	//最新标数据（表格中的第一行）
	private By latestBidBy = By.id("datagrid-row-r1-2-0");
	
	public void clickLatestBid(){
		//表格数据加载需要时间，datagrid-row-r1-2-0定位是原始的表格（默认没有数据）
		//当你点击提交之后，发请求和服务器交互，需要时间才能把数据加载到原始的表格中
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(latestBidBy);
	}
	
	//审核
	private By verifyBy = By.xpath("//span[text()='审核']");
	
	public void clickVerify(){
		click(verifyBy);
	}
	
	//审核通过
	private By verifyPassBy = By.xpath("//span[text()='审核通过']");
	
	public void clickVerifyPass(){
		click(verifyPassBy);
	}
	
}
